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

//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.4.2.1.2.5 $ $Date: 2005/03/27 15:29:57 $
 */
public final class PartySmallWindowAdd extends L2GameServerPacket
{
	//private static final String _S__64_PARTYSMALLWINDOWADD = "[S] 4f PartySmallWindowAdd";

	//private L2PcInstance _member;

	//public PartySmallWindowAdd(L2PcInstance member)
	//{
		//_member = member;
	//}

	//@Override
	public void readP()
	{
		//writeC(0x4f);
		//L2PcInstance player =  getClient().getActiveChar();
		readD();//writeD(player.getObjectId()); // c3
		readD();//writeD(0);//writeD(0x04); ?? //c3
		int objid = readD();//writeD(_member.getObjectId());
		String nom = readS();//writeS(_member.getName());

		int cp = readD();//writeD((int) _member.getCurrentCp()); //c4
		int mcp = readD();//writeD(_member.getMaxCp()); //c4

		int hp = readD();//writeD((int) _member.getCurrentHp());
		int mhp = readD();//writeD(_member.getMaxHp());
		int mp = readD();//writeD((int) _member.getCurrentMp());
		int maxmp = readD();//writeD(_member.getMaxMp());
		int lvl = readD();//writeD(_member.getLevel());
		int cla = readD();//writeD(_member.getClassId().getId());
		//writeD(0);//writeD(0x01); ??
		//writeD(0);
                getPj().partyHandler.addPartyMember(objid, nom, cp, maxmp, hp, maxmp, mp, maxmp, lvl, cla);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__64_PARTYSMALLWINDOWADD;
	//}
}
