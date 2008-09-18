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

//import java.util.Map;
//import java.util.Map.Entry;

/**
 * Format: (c) d[dS]
 * d: list size
 * [
 *   d: char ID
 *   S: char Name
 * ]
 *
 * @author  -Wooden-
 */
public class PackageToList extends L2GameServerPacket
{
	//private static final String _S__C2_PACKAGETOLIST = "[S] c8 PackageToList";
	//private Map<Integer,String> _players;
//
	//public PackageToList(Map<Integer,String> players)
	//{
		//_players = players;
	//}
//
        /*
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xc8);
		int s = readD();//writeD(_players.size());
		//for (Entry<Integer,String> entry : _players.entrySet())
                for (int i = 0; i < s; i++) 
		{
			int key = readD();//writeD(entry.getKey());
			String value = readS();//writeS(entry.getValue());
		}
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__C2_PACKAGETOLIST;
	//}

}