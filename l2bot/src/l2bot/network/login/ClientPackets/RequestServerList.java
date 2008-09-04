/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login.ClientPackets;

/**
 *
 * @author carl
 */
public class RequestServerList extends ClientPacket {
    public RequestServerList(byte[] sessionId2){
        writeC(0x05);
        writeB(sessionId2);
        writeC(0x04);
    }
}
