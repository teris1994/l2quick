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
 * Format: ch Sddddddddd
 * @author  KenM
 */
public class ExDuelUpdateUserInfo extends L2GameServerPacket
{
	//private static final String _S__FE_4F_EXDUELUPDATEUSERINFO = "[S] FE:50 ExDuelUpdateUserInfo";
	//private L2PcInstance _activeChar;

	//public ExDuelUpdateUserInfo(L2PcInstance cha)
	//{
		//_activeChar = cha;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x50);
		String name = readS();//writeS(_activeChar.getName());
		int objId = readD();//writeD(_activeChar.getObjectId());
		int classId = readD();//writeD(_activeChar.getClassId().getId());
		int lvl = readD();//writeD(_activeChar.getLevel());
		int hp = readD();//writeD((int)_activeChar.getCurrentHp());
		int maxHp = readD();//writeD(_activeChar.getMaxHp());
		int mp = readD();//writeD((int)_activeChar.getCurrentMp());
		int maxMp = readD();//writeD(_activeChar.getMaxMp());
		int cp = readD();//writeD((int)_activeChar.getCurrentCp());
		int maxCp = readD();//writeD(_activeChar.getMaxCp());
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_4F_EXDUELUPDATEUSERINFO;
	//}

}
