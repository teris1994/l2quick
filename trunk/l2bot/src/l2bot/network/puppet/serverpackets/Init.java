/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package l2bot.network.puppet.serverpackets;

//import net.sf.l2j.loginserver.L2LoginClient;

import l2bot.network.puppet.LoginCrypt;





/**
 * Format: dd b dddd s
 * d: session id
 * d: protocol revision
 * b: 0x90 bytes : 0x80 bytes for the scrambled RSA public key
 *                 0x10 bytes at 0x00
 * d: unknow
 * d: unknow
 * d: unknow
 * d: unknow
 * s: blowfish key
 *
 */
public final class Init extends ServerBasePacket
{
	//private int _sessionId;

	//private byte[] _publicKey;
	//private byte[] _blowfishKey;
//
	//public Init(L2LoginClient client)
	//{
		//this(client.getScrambledModulus(), client.getBlowfishKey(), client.getSessionId());
	//}

    //public Init(byte[] publickey, byte[] blowfishkey, int sessionId)
    //{
    	//_sessionId = sessionId;
    	//_publicKey = publickey;
    	//_blowfishKey = blowfishkey;
    //}

	/**
	 * @see com.l2jserver.mmocore.network.SendablePacket#write()
	 */
	@Override
	public void write()
	{
        writeC(0);
        writeC(0);
            
        writeC(0x00); // init packet id

    	writeD(0x12345678); // session id
    	writeD(0x0000c621); // protocol revision
        byte[] RSAKey = new byte[128];
        for(int i = 0; i < 128; i++){
            RSAKey[i] = (byte)i;
        }
    	writeB(RSAKey); // RSA Public Key

    	// unk GG related?
    	writeD(0x29DD954E);
    	writeD(0x77C39CFC);
    	writeD(0x97ADB620);
    	writeD(0x07BDE0F7);
        byte[] bfkey = LoginCrypt.STATIC_BLOWFISH_KEY;
    	writeB(bfkey); // BlowFish key
        writeC(0x00); // null termination ;)
        
        
	}
}
