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

/**
 * Format: ch Sd
 * @author  KenM
 */
public class ExDuelAskStart extends L2GameServerPacket
{
	//private static final String _S__FE_4B_EXDUELASKSTART = "[S] FE:4c ExDuelAskStart";

	//private String _requestorName;
	//private int _partyDuel;

	//public ExDuelAskStart(String requestor, int partyDuel)
	///{
		//_requestorName = requestor;
		//_partyDuel = partyDuel;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x4c);

		String reqname =readS();//writeS(_requestorName);
		int partyd = readD();//writeD(_partyDuel);
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_4B_EXDUELASKSTART;
	//}

}
