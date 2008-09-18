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

//import net.sf.l2j.gameserver.model.L2Clan;
//import net.sf.l2j.gameserver.model.L2Clan.SubPledge;

/**
 *
 * @author  -Wooden-
 */
public class PledgeReceiveSubPledgeCreated extends L2GameServerPacket
{
	//private static final String _S__FE_3F_PLEDGERECEIVESUBPLEDGECREATED = "[S] FE:40 PledgeReceiveSubPledgeCreated";
	//private SubPledge _subPledge;
	//private L2Clan _clan;

	/**
	 * @param member
	 */
	//public PledgeReceiveSubPledgeCreated(SubPledge subPledge, L2Clan clan)
	//{
		//_subPledge = subPledge;
		//_clan = clan;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x40);

		readD();//writeD(0x01);
                int id = readD();//writeD(_subPledge.getId());
                String name = readS();//writeS(_subPledge.getName());
                String leader = readS();//writeS(getLeaderName());
	}
	
	//private String getLeaderName()
	//{
		//if (_subPledge.getId() == L2Clan.SUBUNIT_ACADEMY || _subPledge.getLeaderId() == 0)
			//return "";
		//else
			//return _clan.getClanMember(_subPledge.getLeaderId()).getName(); 
	//}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_3F_PLEDGERECEIVESUBPLEDGECREATED;
	//}

}
