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

//import java.util.List;

//import javolution.util.FastList;
import l2bot.pj.handlers.PartyHandler;
import l2bot.pj.handlers.PartyHandler.PartyDist;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 *
 *
 * sample
 * 63
 * 01 00 00 00  count
 *
 * c1 b2 e0 4a  object id
 * 54 00 75 00 65 00 73 00 64 00 61 00 79 00 00 00  name
 * 5a 01 00 00  hp
 * 5a 01 00 00  hp max
 * 89 00 00 00  mp
 * 89 00 00 00  mp max
 * 0e 00 00 00  level
 * 12 00 00 00  class
 * 00 00 00 00
 * 01 00 00 00
 *
 *
 * format   d (dSdddddddd)
 *
 *
 * @version $Revision: 1.6.2.1.2.5 $ $Date: 2005/03/27 15:29:57 $
 */
public final class PartySmallWindowAll extends L2GameServerPacket
{
	//private static final String _S__63_PARTYSMALLWINDOWALL = "[S] 4e PartySmallWindowAll";
	//private List<L2PcInstance> _partyMembers = new FastList<L2PcInstance>();
	//private L2PcInstance _exclude;

	//public PartySmallWindowAll(L2PcInstance exclude, List<L2PcInstance> party)
	//{
		//_exclude = exclude;
		//_partyMembers = party;
	//}

	//@Override
	public void readP()
	{
		
                PartyHandler ph = getPj().partyHandler;
                //writeC(0x4e);
		ph.leaderObjId = readD();//writeD(_partyMembers.get(0).getObjectId()); // c3 party leader id
		ph.partyDist = PartyDist.values()[readD()];//writeD(_partyMembers.get(0).getParty().getLootDistribution());//c3 party loot type (0,1,2,....)
		int size = readD();//writeD(_partyMembers.size()-1);

		for(int i = 0; i < size; i++)
		{
			//L2PcInstance member = _partyMembers.get(i);
			//if (member != _exclude)
			//{
				int objid = readD();//writeD(member.getObjectId());
				String nom = readS();//writeS(member.getName());

				int cp = readD();//writeD((int) member.getCurrentCp()); //c4
				int mcp = readD();//writeD(member.getMaxCp()); //c4

				int hp = readD();//writeD((int) member.getCurrentHp());
				int mhp = readD();//writeD(member.getMaxHp());
				int mp = readD();//writeD((int) member.getCurrentMp());
				int maxmp = readD();//writeD(member.getMaxMp());
				int lvl = readD();//writeD(member.getLevel());
				int cla = readD();//writeD(member.getClassId().getId());
				readD();//writeD(0);//writeD(0x01); ??
				readD();//writeD(member.getRace().ordinal());
				readD();//writeD(0);
                                ph.addPartyMember(objid, nom, cp, maxmp, hp, maxmp, mp, maxmp, lvl, cla);
			//}
		}
                ph.isInParty = true;
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__63_PARTYSMALLWINDOWALL;
	//}
}
