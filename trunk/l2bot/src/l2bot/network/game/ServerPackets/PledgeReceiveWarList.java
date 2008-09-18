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

//import net.sf.l2j.gameserver.datatables.ClanTable;
//import net.sf.l2j.gameserver.model.L2Clan;

/**
 *
 * @author  -Wooden-
 */
public class PledgeReceiveWarList extends L2GameServerPacket
{
	//private static final String _S__FE_3E_PLEDGERECEIVEWARELIST = "[S] FE:3F PledgeReceiveWarList";
	//private L2Clan _clan;
	//private int _tab;

	//public PledgeReceiveWarList(L2Clan clan, int tab)
	//{
		//_clan = clan;
		//_tab = tab;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readD();//writeH(0x3f);

		int type = readD();//writeD(_tab); // type : 0 = Declared, 1 = Under Attack
		readD();//writeD(0x00); // page
		int s  = readD();//writeD(_tab == 0 ? _clan.getWarList().size() : _clan.getAttackerList().size());
		//for(Integer i : _tab == 0 ? _clan.getWarList() : _clan.getAttackerList())
                for (int i = 0; i < s; i++) 
		{
			//L2Clan clan = ClanTable.getInstance().getClan(i);
			//if (clan == null) continue;
			String name = readS();//writeS(clan.getName());
			readD();//writeD(_tab); //??
			readD();//writeD(_tab); //??
		}
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_3E_PLEDGERECEIVEWARELIST;
	//}

}
