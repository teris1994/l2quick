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
//import net.sf.l2j.gameserver.model.L2Skill;

/**
 * Format: (ch) d [dd]
 *
 * @author  -Wooden-
 */
public class PledgeSkillList extends L2GameServerPacket
{
	//private static final String _S__FE_39_PLEDGESKILLLIST = "[S] FE:3a PledgeSkillList";
	//private L2Skill[] _skills;

	//public PledgeSkillList(L2Clan clan)
	//{
        //_skills = clan.getAllSkills();
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x3a);
		int s = readD();//writeD(_skills.length);
                readD();//writeD(0x00);
		//for(L2Skill sk : _skills)
                for (int i = 0; i < s; i++) 
		{
			int id = readD();//writeD(sk.getId());
			int lvl = readD();//writeD(sk.getLevel());
		}
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		////return _S__FE_39_PLEDGESKILLLIST;
	//}
}