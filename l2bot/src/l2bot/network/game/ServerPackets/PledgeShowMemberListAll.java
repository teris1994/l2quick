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
//import net.sf.l2j.gameserver.model.L2ClanMember;
//import net.sf.l2j.gameserver.model.L2Clan.SubPledge;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
//import java.util.logging.Logger;
/**
 *
 *
 * sample
 * 0000: 68
 * b1010000
 * 48 00 61 00 6d 00 62 00 75 00 72 00 67 00 00 00   H.a.m.b.u.r.g...
 * 43 00 61 00 6c 00 61 00 64 00 6f 00 6e 00 00 00   C.a.l.a.d.o.n...
 * 00000000  crestid | not used (nuocnam)
 * 00000000 00000000 00000000 00000000
 * 22000000 00000000 00000000
 * 00000000 ally id
 * 00 00	ally name
 * 00000000 ally crrest id
 *
 * 02000000
 *
 * 6c 00 69 00 74 00 68 00 69 00 75 00 6d 00 31 00 00 00  l.i.t.h.i.u.m...
 * 0d000000		level
 * 12000000 	class id
 * 00000000
 * 01000000 	offline 1=true
 * 00000000
 *
 * 45 00 6c 00 61 00 6e 00 61 00 00 00   E.l.a.n.a...
 * 08000000
 * 19000000
 * 01000000
 * 01000000
 * 00000000
 *
 *
 * format   dSS dddddddddSdd d (Sddddd)
 *          dddSS dddddddddSdd d (Sdddddd)
 *
 * @version $Revision: 1.6.2.2.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public class PledgeShowMemberListAll extends L2GameServerPacket
{
	//private static final String _S__68_PLEDGESHOWMEMBERLISTALL = "[S] 5a PledgeShowMemberListAll";
	//private L2Clan _clan;
	//private L2PcInstance _activeChar;
	//private L2ClanMember[] _members;
	//private int _pledgeType;
	//private static Logger _log = Logger.getLogger(PledgeShowMemberListAll.class.getName());

	//public PledgeShowMemberListAll(L2Clan clan, L2PcInstance activeChar)
	//{
		//_clan = clan;
		//_activeChar = activeChar;
		//_members = _clan.getMembers();
	//}

	//@Override
	//public void readP()
	//{

		//_pledgeType = 0;
		//writePledge(0);
//
		//SubPledge[] subPledge = _clan.getAllSubPledges();
		//for (int i = 0; i<subPledge.length; i++)
		//{
			//_activeChar.sendPacket(new PledgeReceiveSubPledgeCreated(subPledge[i], _clan));
		//}
//
		//for (L2ClanMember m : _members)
		//{
            //if (m.getPledgeType() == 0) continue;
			//_activeChar.sendPacket(new PledgeShowMemberListAdd(m));
		//}
//
		//// unless this is sent sometimes, the client doesn't recognise the player as the leader
		//_activeChar.sendPacket(new UserInfo(_activeChar));
//
	//}

        @Override
	public void readP()
	{
		//writeC(0x5a);

		readD();//writeD(mainOrSubpledge);
		int id = readD();//writeD(_clan.getClanId());
		int type = readD();//writeD(_pledgeType);
		String name = readS();//writeS(_clan.getName());
		String leader = readS();//writeS(_clan.getLeaderName());

		int crestId = readD();//writeD(_clan.getCrestId()); // crest id .. is used again
		int lvl = readD();//writeD(_clan.getLevel());
                boolean hasCastle = readD() != 0; //writeD(_clan.getHasCastle());
		boolean hasHileout = readD() != 0;//writeD(_clan.getHasHideout());
		boolean hasFort = readD() != 0;///writeD(_clan.getHasFort());
		int rank = readD();//writeD(_clan.getRank());
		int score = readD();//writeD(_clan.getReputationScore());
		readD();//writeD(0); //0
		readD();//writeD(0); //0
		int ally = readD();//writeD(_clan.getAllyId());
		String allyName = readS();//writeS(_clan.getAllyName());
		int allyCrest = readD();//writeD(_clan.getAllyCrestId());
                boolean isAtWar = readD() !=0;//writeD(_clan.isAtWar()? 1 : 0);// new c3
		int s = readD();//writeD(_clan.getSubPledgeMembersCount(_pledgeType));

		//for (L2ClanMember m : _members)
                for (int i = 0; i < s; i++) 
		{
                    //if(m.getPledgeType() != _pledgeType) continue;
                    String memberName = readS();//writeS(m.getName());
                    int memberLvl = readD();//writeD(m.getLevel());
                    int classId = readD();//writeD(m.getClassId());
                    //L2PcInstance player;
                    //if ((player = m.getPlayerInstance()) != null)
                    //{
                        int sexo = readD();//writeD(player.getAppearance().getSex() ? 1 : 0); // no visible effect
                        int raza = readD();//writeD(player.getRace().ordinal());//writeD(1);
                    //}
                    //else
                    //{
                        //writeD(1); // no visible effect
                        //writeD(1); //writeD(1);
                    //}
			boolean isOnline = readD() != 0;//writeD(m.isOnline() ? m.getObjectId() : 0);  // objectId=online 0=offline
			boolean haveSponsor = readD() !=0;//writeD(m.getSponsor() != 0 ? 1 : 0);
		}
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__68_PLEDGESHOWMEMBERLISTALL;
	//}

}
