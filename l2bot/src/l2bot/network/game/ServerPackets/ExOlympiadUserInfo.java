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
 * @version $Revision: 1.4.2.1.2.3 $ $Date: 2005/03/27 15:29:57 $
 *
 * @author godson
 */
public class ExOlympiadUserInfo extends L2GameServerPacket
{
	// chcdSddddd
	//private static final String _S__FE_29_OLYMPIADUSERINFO = "[S] FE:7a OlympiadUserInfo";
	//@SuppressWarnings("unused")
	//private static L2PcInstance _activeChar;


	/**
	 * @param _player
	 * @param _side (1 = right, 2 = left)
	 */
	//public ExOlympiadUserInfo(L2PcInstance player)
	//{
		//_activeChar = player;
	//}


	@Override
	public void readP()
	{
		///*writeC(0xfe);
		readH();//writeH(0x2c);
		int objId = readD();//writeD(_activeChar.getObjectId());
		String name = readS();//writeS(_activeChar.getName());
		int classId = readD();//writeD(_activeChar.getClassId().getId());
		int hp = readD();//writeD((int)_activeChar.getCurrentHp());
		int maxHp = readD();//writeD(_activeChar.getMaxHp());
		int cp = readD();//writeD((int)_activeChar.getCurrentCp());
		int maxCp = readD();//writeD(_activeChar.getMaxCp());*/
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_29_OLYMPIADUSERINFO;
	//}
}
