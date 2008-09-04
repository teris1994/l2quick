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
 * @version $Revision: 1.4.2.1.2.5 $ $Date: 2005/03/27 15:29:39 $
 */
public final class PartySmallWindowUpdate extends L2GameServerPacket
{
	//private static final String _S__67_PARTYSMALLWINDOWUPDATE = "[S] 52 PartySmallWindowUpdate";
	//private L2PcInstance _member;

	//public PartySmallWindowUpdate(L2PcInstance member)
	//{
		//_member = member;
	//}

	//@Override
	public void readP()
	{
		//writeC(0x52);
		int objid = readD();//writeD(_member.getObjectId());
		String nom = readS();//writeS(_member.getName());

		int cp = readD();//writeD((int) _member.getCurrentCp()); //c4
		int mcp = readD();//writeD(_member.getMaxCp()); //c4

                int hp = readD();//writeD((int) member.getCurrentHp());
                int mhp = readD();//writeD(member.getMaxHp());
                int mp = readD();//writeD((int) member.getCurrentMp());
                int maxmp = readD();//writeD(member.getMaxMp());
                int lvl = readD();//writeD(member.getLevel());
                int cla = readD();//writeD(member.getClassId().getId());

                getPj().partyHandler.actualizar(objid, nom, cp, maxmp, hp, maxmp, mp, maxmp, lvl, cla);

	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__67_PARTYSMALLWINDOWUPDATE;
	//}
}
