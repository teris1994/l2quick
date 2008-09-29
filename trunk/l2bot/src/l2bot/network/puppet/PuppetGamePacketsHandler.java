/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.puppet;

import l2bot.interfaz.Sniffer;
import l2bot.network.game.GameCrypt;
import l2bot.network.puppet.GameServerPackets.*;

/**
 *
 * @author carl
 */
public class PuppetGamePacketsHandler {
 
    GameCrypt gc = new GameCrypt();
    boolean encriptado = false;
  
    public PuppetGamePacketsHandler(){
        byte[] key = new byte[16];
        key[0] = 0x05;
        key[1] = 0x05;
        key[2] = 0x05;
        key[3] = 0x05;
        key[4] = 0x05;
        key[5] = 0x05;
        key[6] = 0x05;
        key[7] = 0x05;
        key[8] = (byte) 0xc8;
        key[9] = (byte) 0x27;
        key[10] = (byte) 0x93;
        key[11] = (byte) 0x01;
        key[12] = (byte) 0xa1;
        key[13] = (byte) 0x6c;
        key[14] = (byte) 0x31;
        key[15] = (byte) 0x97;
        gc.setKey(key);
        gc.enable();
    }
   
    
    public void paquete(byte[] raw){
        
        if(encriptado){
            gc.decrypt(raw, 2, raw[0] + (raw[1]*256) -2);
        }
        Sniffer.getInstance().addPacket(raw, Sniffer.CLIENTE_GAME, "puppet");
        
        switch(raw[2] & 0xFF){
            case 0x0e:
                send(new KeyPacket().getBytes());
                encriptado = true;
                return;
            case 0x2B:
                send(new CharSelectionInfo().getBytes());
                return;
             
        }
    }

    public void send(byte[] raw){
       
       byte[] raw2 = new byte[raw.length+2];
       System.arraycopy(raw, 0, raw2, 2, raw.length);
       Sniffer.getInstance().addPacket(raw2, Sniffer.GAME_SERVER, "puppet");
       if(encriptado){
            gc.encrypt(raw, 2, raw.length-2);
       }
       int s = raw2.length;
       int s0 = (s) % 256;
       int s1 = ((s) - s0)/256;
       raw2[0] = (byte) s0;
       raw2[1] = (byte) s1;
       
       System.out.println("S->C " + (encriptado?"Y ":"N ")  + LoginCrypt.byteArrayToHexString(raw2)); 
       sendToClient(raw2);
    }
    

    
    public void sendToClient(byte[] raw){}
}
