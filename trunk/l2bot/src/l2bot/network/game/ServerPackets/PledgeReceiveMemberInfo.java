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

//import net.sf.l2j.gameserver.model.L2ClanMember;

/**
 *
 * @author  -Wooden-
 */
public class PledgeReceiveMemberInfo extends L2GameServerPacket
{
	//private static final String _S__FE_3D_PLEDGERECEIVEMEMBERINFO = "[S] FE:3e PledgeReceiveMemberInfo";
	//private L2ClanMember _member;

	/**
	 * @param member
	 */
	//public PledgeReceiveMemberInfo(L2ClanMember member)
	//{
		//_member = member;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x3e);
		int type = readD();//writeD(_member.getPledgeType());
		String name = readS();//writeS(_member.getName());
		String title = readS();//writeS(_member.getTitle()); // title
		int power = readD();//writeD(_member.getPowerGrade()); // power
		////clan or subpledge name
		//if(_member.getPledgeType() != 0)
		//{
			//writeS((_member.getClan().getSubPledge(_member.getPledgeType())).getName());
		//}
		String unk = readS(); //else writeS(_member.getClan().getName());
		String productor = readS();//writeS(_member.getApprenticeOrSponsorName()); // name of this member's apprentice/sponsor
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_3D_PLEDGERECEIVEMEMBERINFO;
	//}

}
