/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.puppet.GameServerPackets;

/**
 *
 * @author carl
 */
public class KeyPacket extends l2bot.network.puppet.serverpackets.ServerBasePacket{
        public void write(){
            writeC(0x2e);
            writeC(0x01);
            byte[] key = new byte[8];
            key[0] = 0x05;
            key[1] = 0x05;
            key[2] = 0x05;
            key[3] = 0x05;
            key[4] = 0x05;
            key[5] = 0x05;
            key[6] = 0x05;
            key[7] = 0x05;
           /* key[8] = (byte) 0xc8;
            key[9] = (byte) 0x27;
            key[10] = (byte) 0x93;
            key[11] = (byte) 0x01;
            key[12] = (byte) 0xa1;
            key[13] = (byte) 0x6c;
            key[14] = (byte) 0x31;
            key[15] = (byte) 0x97;*/
            writeB(key);
            
            writeD(0x01);
            writeD(0x01);
            writeC(0x00);
            writeD(0x00);
        }
}
