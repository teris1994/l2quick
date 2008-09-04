/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login.ClientPackets;

/**
 *
 * @author carl
 */
public class RequestServerLogin  extends ClientPacket{
    public RequestServerLogin(byte[] sessionId2,byte serverId){
        writeC(0x02);
        writeB(sessionId2);
        writeC(serverId);
    }
}
