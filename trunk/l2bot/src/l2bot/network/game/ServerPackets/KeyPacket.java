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
package l2bot.network.game.ServerPackets;

import l2bot.network.game.ClientPackets.AuthLogin;

/**
 * This class ...
 *
 * @version $Revision: 1.3.2.1.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public final class KeyPacket extends L2GameServerPacket
{
	//private static final String _S__01_KEYPACKET = "[S] 2e KeyPacket";

	//private byte[] _key;

	//public KeyPacket(byte[] key)
	//{
		//_key = key;
	//}

	//@Override
	public void readP()
	{
		//writeC(0x2e);
		readC();//writeC(0x01);
		byte[] key = new byte[16];
                for (int i = 0; i < 8; i++)
		{
			key[i] = (byte) readC();//writeC(_key[i]);
		}
                key[8] = (byte) 0xc8;
                key[9] = (byte) 0x27;
                key[10] = (byte) 0x93;
                key[11] = (byte) 0x01;
                key[12] = (byte) 0xa1;
                key[13] = (byte) 0x6c;
                key[14] = (byte) 0x31;
                key[15] = (byte) 0x97;
		//writeD(0x01);
		//writeD(0x01);
		//writeC(0x00);
		//writeD(0x00);
                
                getPj().gameSocket.setKey(key);
                getPj().inter.l.logError("Key recivida, enviando AuthLogin");
                getPj().gameSocket.sendPacketToGame(new AuthLogin(getPj().connectionInfo.user,getPj().playkey).getBytes());
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.L2GameServerPacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__01_KEYPACKET;
	//}

}
