/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login;

/**
 *
 * @author carl
 */
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import l2bot.Main;
import l2bot.interfaz.Sniffer;
import l2bot.interfaz.dialogs.ServerSelect;
import l2bot.network.login.ClientPackets.*;
import l2bot.network.login.ClientPackets.ClientPacket;
import l2bot.pj.Pj;



public class LoginHandler{
	
	public enum LoginStatus{DESCONECTADO,WF_INIT,WF_authGG,WF_authLogin,WF_auth}
        
        String user,password;
        String gameservers;
        
        public Pj pj;
        
	public LoginStatus estado;
	
        public LoginCrypt Loginc;
        
        public boolean error = false;
        
        public byte[] sessionId2;
        
        
        byte _server;
        
        GameServersHandler gameServersHandler;
        
	public LoginHandler(){
	estado = LoginStatus.DESCONECTADO;
	}
	
        public void Paquete(byte[] raw)throws IOException{
            if(raw == null){
                if(!error)
                {
                    pj.getLogger().logError("Paquete demaseado corto");
                    error = true;
                }
                return;
            }


            switch(estado){
                case DESCONECTADO:
                    return;
                case WF_INIT:
                    pj.getLogger().logInfo("Recivido Init,enviando Auth GameGuard...");
                    Loginc = new LoginCrypt(raw,pj);
                    EnviarAuthGG();
                    estado = LoginStatus.WF_authGG;
                    return;
                case WF_authGG:
                    Loginc.Desencriptar(raw, raw[0] + raw[1]*256);

                    if(raw[2] == 0x0B){
                        pj.getLogger().logInfo("Recivido skip Auth Gameguard, enviando peticion de login...");
                        EnviarAuthLogin();
                        estado = LoginStatus.WF_auth;
                    }
                    return;
                case WF_auth:
                    Loginc.Desencriptar(raw, raw[0] + raw[1]*256);
                    if(raw[2] == 0x02){
                        parseError(raw[2],raw[3]);
                        error = true;
                        return;
                    }
                    break;  
            }
            
            //Loginc.Desencriptar(raw, raw[0] + raw[1]*256);
            switch(raw[2]){
                case 0x02:
                    parseError(raw[2],raw[3]);
                    error = true;
                    return;
                case 0x03:
                    pj.getLogger().logInfo("Login ok, Pidiendo lista de servers...");
                    sessionId2 = new byte[8];
                    System.arraycopy(raw, 3, sessionId2, 0, 8);
                    enviarReqestServerList();
                    return;
                case 0x04:
                    pj.getLogger().logInfo("recivida lista de servers");
                    gameServersHandler = new GameServersHandler(raw);
                    ServerSelect sc = new ServerSelect(Main.g,gameServersHandler,gameservers){
                        @Override
                        public void onAceptar(byte ser){
                            pj.getLogger().logInfo("enviando server login...");
                            _server = ser;
                            enviarReqestServerLogin((byte)(ser+1));
                        }
                        @Override
                        public void onCancelar(){
                            
                        }
                        @Override
                        public void onActualizar(){
                            enviarReqestServerList();
                        }
                    };
                    sc.setVisible(true);
                     return;
                case 0x06:
                    parseError(raw[2],raw[3]);
                    return;
                case 0x07:
                    pj.getLogger().logInfo("recivido play ok");
                    pj.getLogger().logInfo("desconectado del ls");
                    byte[] gsk = new byte[16];
                    gsk[4] = raw[3];
                    gsk[5] = raw[4];
                    gsk[6] = raw[5];
                    gsk[7] = raw[6];
                    
                    gsk[0] = raw[7];
                    gsk[1] = raw[8];
                    gsk[2] = raw[9];
                    gsk[3] = raw[10];
                    System.arraycopy(sessionId2, 0, gsk, 8, 8);
                    desconectar(true,gameServersHandler.gameServers[_server],gsk);
                    return;
            }
            
    }
        
        public void EnviarAuthLogin() throws IOException{
            try {
                RequestLogin rl = new RequestLogin(user, password, Loginc.RSApublickey, Loginc.SessionID);
                System.out.println(LoginCrypt.byteArrayToHexString(rl.getBytes()));
//                Send(rl.getBytes(),0xB2,rl.getLength(),rl.rellenar.SI);
                Send2(rl.getBytes());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }    
        public void EnviarAuthGG() throws IOException{
            AuthGG agg = new AuthGG(Loginc.SessionID);
            Send(agg.getBytes(),0x2A,agg.getLength(),agg.rellenar());
        }
        
        public void enviarReqestServerList(){
            RequestServerList rss = new RequestServerList(sessionId2);
            try {
                Send2(rss.getBytes());
            } catch (IOException ex) {
            }
        }
        public void enviarReqestServerLogin(byte serverId){
            RequestServerLogin rss = new RequestServerLogin(sessionId2, serverId);
            try {
                Send2(rss.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
        public void Send(byte[] raw, int size,int chkoff, ClientPacket.Rellenar fillmode) throws IOException{
            LoginCrypt.appendChecksum(raw,2,chkoff);
            Sniffer.getInstance().addPacket(raw, Sniffer.CLIENTE_LOGIN, pj.connectionInfo.user);
            switch(fillmode){
                case SI:
                    if(raw.length < size){
                        byte[] asd = new byte[size];
                        System.arraycopy(raw, 0, asd, 0, raw.length);
                        raw = asd;
                    }
                    break;
                case NO:
                case PADDING:
            }
            Loginc.Encriptar(raw, size);
            
            int s0,s1;
            s0 = size % 256;
            s1 = (size - s0)/256;
            raw[0] = (byte) s0;
            raw[1] = (byte) s1;
            
            //System.out.println(LoginCrypt.byteArrayToHexString(raw));
            
            this.SendPacketToLogin(raw);
            
        }
        
        public void Send2(byte[] buf) throws IOException{
            
            
            
            int size = buf.length;
            
            //System.out.println("[" + size + "] " + LoginCrypt.byteArrayToHexString(buf));
            
            size += (8 - (size%8));
            
            
            byte[] buf2 = new byte[size+18];    //16`para checksum, 2 para el tamaño
            
            //System.out.println("[" + size + "] " + LoginCrypt.byteArrayToHexString(buf2));
            
            System.arraycopy(buf,0, buf2,2, buf.length);
            
            //System.out.println("[" + size + "] " + LoginCrypt.byteArrayToHexString(buf2));
            
            LoginCrypt.appendChecksum(buf2,2,size+6);
            Sniffer.getInstance().addPacket(buf2, Sniffer.CLIENTE_LOGIN, pj.connectionInfo.user);
            //System.out.println("[" + size + "] " + LoginCrypt.byteArrayToHexString(buf2));
            
            Loginc.crypt(buf2, 2, size+16);
            
            //System.out.println("[" + size + "] " + LoginCrypt.byteArrayToHexString(buf2));
            
            
            
            //LoginCrypt.appendChecksum(buf2,2,size);
            // System.out.println(LoginCrypt.verifyChecksum(buf2,2,size));
            //System.out.println(LoginCrypt.byteArrayToHexString(buf2));

 
            //Loginc.Encriptar(buf2, size);
            int s0,s1;
            size +=18;
            s0 = size % 256;
            s1 = (size - s0)/256;
            buf2[0] = (byte) s0;
            buf2[1] = (byte) s1;
            //System.out.println(LoginCrypt.byteArrayToHexString(buf2)); 
            this.SendPacketToLogin(buf2);
            
        }
        
    public void parseError(byte t,byte w){
    switch(t){
        case 0x02:   //Account kicked
                    switch(w){
                        default:
                            pj.getLogger().logError("No se pudo logear: Razon desconocida.");
                            break;
                        case 0x01:
                            pj.getLogger().logError("No se pudo logear: Ladron de datos");
                            break;          
                        case 0x08:
                            pj.getLogger().logError("No se pudo logear: Violacion general");
                            break; 
                        case 0x10:
                            pj.getLogger().logError("No se pudo logear: Cuenta suspendida durante 7 dias");
                            break; 
                        case 0x20:
                            pj.getLogger().logError("No se pudo logear: Cuenta baneada");
                            break; 
                    }
            break;
        case 0x01:  //Login fail
                    switch(w){
                        default:
                            pj.getLogger().logError("No se pudo logear: Razon desconocida");
                            break;
                        case 0x01:
                            pj.getLogger().logError("No se pudo logear: Error del sistema");
                            break; 
                        case 0x02:
                            pj.getLogger().logError("No se pudo logear: Contraseña incorrecta");
                            break;                                   
                        case 0x03:
                            pj.getLogger().logError("No se pudo logear: Usuario o contraseña incorrecta");
                            break; 
                        case 0x04:
                            pj.getLogger().logError("No se pudo logear: Acseso fallido");
                            break; 
                        case 0x07:
                            pj.getLogger().logError("No se pudo logear: Cuenta en uso");
                            break; 
                        case 0x0f:
                            pj.getLogger().logError("No se pudo logear: Servidor sobracargado");
                            break; 
                        case 0x10:
                            pj.getLogger().logError("No se pudo logear: Servidor en mantenimiento");
                            break; 
                        case 0x11:
                            pj.getLogger().logError("No se pudo logear: Contraseña temporal caducada");
                            break; 
                        case 0x23:
                            pj.getLogger().logError("No se pudo logear: DualBox");
                            break; 
                        }
            break;
        case 0x06:  //Play fail
                    switch(w){
                        case 0x01:
                            pj.getLogger().logError("No se pudo logear en el gameserver: Error del sistema");
                            break;
                        case 0x02:
                            pj.getLogger().logError("No se pudo logear en el gameserver: Usuario o contraseña incorrecto");
                            break;
                        case 0x03:
                            pj.getLogger().logError("No se pudo logear en el gameserver: razon 3");
                            break;
                        case 0x04:
                            pj.getLogger().logError("No se pudo logear en el gameserver: razon 4");
                            break;
                        case 0x0f:
                            pj.getLogger().logError("No se pudo logear en el gameserver: demaseados jugadores");
                            break;
                    }
            break;
    }
}
        public void setLoginInfo(String user,String password,String gameservers){
            this.user = user;
            this.password = password;
            this.gameservers = gameservers;
        }
        
        public void SendPacketToLogin(byte[] raw){
        
        }
        
        public void desconectar(boolean todoOk,GameServerInfo server,byte[] key){}
        
        
}
        
	
	
	
	
	
//}