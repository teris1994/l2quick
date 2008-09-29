/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.puppet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import l2bot.interfaz.Sniffer;
import l2bot.network.puppet.serverpackets.*;
import l2bot.pj.Pj;
/**
 *
 * @author carl
 */
public class PuppetPacketsHandler {
        Pj puppetPj;
        
        int estado;
        private static final int ESTADO_LOGIN = 0;
        private static final int ESTADO_GAME = 1;
        
        LoginCrypt lc = new LoginCrypt();
        
        
        protected void paquete(byte[] raw){
            if(raw == null){
                System.out.println("error");
                return;
            }
            try {
                boolean  res = lc.decrypt(raw, 2, (raw[0]&0xFF) + ((raw[1]&0xFF)*255) - 2);
                Sniffer.getInstance().addPacket(raw, Sniffer.CLIENTE_LOGIN, "puppet");
                if(!res){
                    System.out.println("Incorrect Checksum");
                }
                //System.out.println(res);
            } catch (IOException ex) {
                Logger.getLogger(PuppetPacketsHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(LoginCrypt.byteArrayToHexString(raw));
            switch(raw[2] & 0xFF){
                case 0x07:
                    System.out.println("recibigo authgg");
                    GGAuth pa = new GGAuth();
                    send(pa.getBytes());
                    return;
                case 0x00:
                    LoginOk lok = new LoginOk();
                    send(lok.getBytes());
                    return;
                case 0x05:
                    ServerList pa2 = new ServerList();
                    send(pa2.getBytes());
                    return;
                case 0x02:
                    PlayOk pa3 = new PlayOk();
                    send(pa3.getBytes());
                    System.out.println("playok");
                    return;
            }
        }
        
        protected void sendInit(){
            Init init = new Init();
            send(init.getBytes());
        }
        
        public void send(byte[] raw){
            try {
                
                //System.out.println(raw.length-2);
                //System.out.println(raw.length+14);
                Sniffer.getInstance().addPacket(raw, Sniffer.LOGIN_SERVER, "puppet");
                int s = raw.length-2;
                if(lc._static){
                    s+=4;
                }
                s +=4;
                s += (8 - (s%8));
                s += 2;
                byte[] raw2 = new byte[s];
                System.arraycopy(raw,0, raw2,0,raw.length);
                
                lc.encrypt(raw2, 2, raw.length-2);
                
                int s0 = (s) % 256;
                int s1 = ((s) - s0)/256;
                raw2[0] = (byte) s0;
                raw2[1] = (byte) s1;
                sendToClient(raw2);
            } catch (IOException ex) {
                Logger.getLogger(PuppetPacketsHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void sendToClient(byte[] raw){}
        public void desconectar(){}
        
}
