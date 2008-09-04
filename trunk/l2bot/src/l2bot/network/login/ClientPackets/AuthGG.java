/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login.ClientPackets;

/**
 *
 * @author carl
 */
public class AuthGG extends ClientPacket {
    
    int Seid;
    public AuthGG(byte[] Sid){

        rellenar = Rellenar.SI;
        
        Seid= (Sid[0] &0xFF);
        Seid |= (Sid[1] & 0xFF) << 8;
        Seid |= (Sid[2] & 0xFF) << 16;
        Seid |=  (Sid[3] & 0xFF) << 24;
        
        
        
        writeC(0); //size
        writeC(0); //size
        
        
        
        writeC(0x07);
        writeD(Seid);
        
        
        byte[] fixe = {(byte)0x23,(byte)0x92,(byte)0x90,(byte)0x4D,(byte)0x18,(byte)0x30,(byte)0xB5,(byte)0x7C,(byte)0x96,(byte)0x61,(byte)0x41,(byte)0x47,(byte)0x05,(byte)0x07,(byte)0x96,(byte)0xFB,(byte)0x00,(byte)0x00,(byte)0x00};
        writeB(fixe);
        
        writeD(0); //checksum
        

        
    }
    
}
