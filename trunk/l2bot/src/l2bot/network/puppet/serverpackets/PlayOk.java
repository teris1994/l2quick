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

//import net.sf.l2j.loginserver.SessionKey;

/**
 *
 */
public final class PlayOk extends ServerBasePacket
{
	//private int _playOk1, _playOk2;

	//public PlayOk(SessionKey sessionKey)
	//{
		//_playOk1 = sessionKey.playOkID1;
		//_playOk2 = sessionKey.playOkID2;
	//}

	/**
	 * @see com.l2jserver.mmocore.network.SendablePacket#write()
	 */
	@Override
	public  void write()
	{
                writeC(12);
                writeC(0);
            
		writeC(0x07);
		writeD(0x12345678);
		writeD(0x51530335);
	}
}
