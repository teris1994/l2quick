/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import l2bot.interfaz.logger;


/**
 *
 * @author carl
 */
public class GShocket extends PacketsHandler implements Runnable {
    	private int puerto;
	private String host;
	
        public boolean Conectado;
        
        
	private Socket game;
	
        private DataOutputStream salida;
        private DataInputStream entrada;
        
        private GameCrypt crypt = new GameCrypt();
    public GShocket(String _host, int port ,logger l){
                puerto = port;
                host = _host;
                log = l;
            
            try{
		game = new Socket(host,puerto);
		//System.out.println( "Conectado a" + host + ":" + puerto );
                salida = new DataOutputStream( game.getOutputStream() );      
                salida.flush();

                entrada = new DataInputStream(game.getInputStream());
            }catch ( EOFException excepcionEOF ) {
                log.logError( "El cliente termino la conexión" );
                return;
            }
            catch ( IOException excepcionES ) {
                log.logError( "Error: imposible conectar al game server" );
                return;
            }
            //this.estado = LoginHandler.LoginStatus.WF_INIT; //hay que implementar algo parecido
            Conectado = true;
            onConect();
            Thread hilo = new Thread(this);
           // System.out.println("empieza el hilo");
            hilo.start();
            
       
	 }
	
    public void run()
    {
		try{
			while (Conectado /*&& !error*/)
			{
                                //System.out.println("empieza el bucle");
				//System.out.println("hola");
				//System.out.println(lentrada.readUTF());				
				byte[] buf = new byte[2];
				entrada.read(buf);
				//System.out.println("empieza leeidos los dos primeros bytes" + buf[0] + "  " + buf[1]);
				int tama = Sbyte2int(buf[0]) + Sbyte2int(buf[1])*256;
				
				byte[] buf2 = new byte[tama];
				
				entrada.read(buf2,2,tama -2);
				
                                try{
                                    buf2[0] = buf[0];
                                    buf2[1] = buf[1];
                                }catch(ArrayIndexOutOfBoundsException e){
                                    if(game.isConnected()){
                                        paquete(null);
                                        game.close();
                                        Conectado = false;
                                        //onDisconect(false,null);
                                    }else
                                    {
                                        log.logError("Desconectado");
                                    }
                                    return;
                                }
                                crypt.decrypt(buf2,2,tama-2);
                                String mensaje = byteArrayToHexString(buf2);
				//log.logInfo("mensaje recivido:" + mensaje);
                                paquete(buf2);

			}
		}
		catch (ConnectException e){
			log.logError("Error: Error de conexion");
		}
                catch (IOException e){
			log.logError("Error: Error de comunicacion");
		}
   } 
   
    @Override
    public void sendPacketToGame(byte[] raw){
        try{
            byte[] h = new byte[raw.length + 2];
            h[0] = (byte)(h.length % 256);
            h[1] = (byte) (h.length /256);
            System.arraycopy(raw,0,h,2,raw.length);
            //System.out.println("D"+LoginCrypt.byteArrayToHexString(h));
            crypt.encrypt(h,2,h.length-2);
            //System.out.println("E"+LoginCrypt.byteArrayToHexString(h));
            salida.write(h);
        }
        catch(IOException e){
            log.logError("Excepcion :(");
            e.printStackTrace();
        }
    }
/*    @Override
    public void desconectar(boolean todoOk, GameServerInfo server){
        onDisconect(todoOk,server);
        Conectado = false;
        try {
            Login.close();
        } catch (IOException ex) {
            Logger.getLogger(LShocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void onDisconect(boolean todoOk,GameServerInfo Server){};

   */
   
	public static String byteArrayToHexString(byte in[]) 
	{
		String rslt = "";
		String thes = "";
		for ( int iuo = 0 ; iuo < in.length ; iuo++ ) {
			int wtrf = in[iuo];
			if(wtrf < 0){
				wtrf = 256+wtrf;
			}			
			//rslt += " " + (in[iuo]);
			
			thes = Integer.toHexString(wtrf);
			if(thes.length() < 2){
				thes = "0" + thes;
			}
			rslt += " " + thes;
		}
		return rslt.toUpperCase();
	} 
	private int Sbyte2int(byte sb){
			int wtrf = sb;
			if(wtrf < 0){
				wtrf = 256+wtrf;
			}
			return wtrf;
	}
        
        public void setKey(byte[] key){
            crypt.setKey(key);
        }

}
    

