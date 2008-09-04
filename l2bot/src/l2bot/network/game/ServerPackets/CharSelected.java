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

import l2bot.network.game.ClientPackets.RequestAll;
import l2bot.pj.ClassId;
import l2bot.pj.Pj;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import l2bot.pj.Race;

/**
 * This class ...
 *
 * @version $Revision: 1.4.2.5.2.6 $ $Date: 2005/03/27 15:29:39 $
 */
public class CharSelected extends L2GameServerPacket
{
	//   SdSddddddddddffddddddddddddddddddddddddddddddddddddddddd d
	/*private static final String _S__21_CHARSELECTED = "[S] 0b CharSelected";
	private L2PcInstance _activeChar;
	private int _sessionId;

	/**
	 * @param _characters
	 */
	/*public CharSelected(L2PcInstance cha, int sessionId)
	{
		_activeChar = cha;
		_sessionId = sessionId;
	}*/

	public void readP()
	{
		//writeC(0x0b);
                Pj pj = getPj();
		pj.nombre = readS();//writeS(_activeChar.getName());
		pj.id = readD();//writeD(_activeChar.getCharId()); // ??
		pj.title = readS();//writeS(_activeChar.getTitle());
		pj.sessionId = readD();//writeD(_sessionId);
		pj.clanId = readD();///writeD(_activeChar.getClanId());
		readD();//writeD(0x00);  //??
		pj.sexo = (byte)readD();//writeD(_activeChar.getAppearance().getSex()? 1 : 0);
		pj.raza = Race.values()[readD()];//writeD(_activeChar.getRace().ordinal());
		pj.clase = ClassId.values()[readD()];//writeD(_activeChar.getClassId().getId());
		readD();//writeD(0x01); // active ??
		pj.x = readD();//writeD(_activeChar.getX());
		pj.y = readD();//writeD(_activeChar.getY());
		pj.z = readD();//writeD(_activeChar.getZ());

		pj.hp = readF();//writeF(_activeChar.getCurrentHp());
		pj.mana = readF();//writeF(_activeChar.getCurrentMp());
		pj.sp = readD();//writeD(_activeChar.getSp());
		pj.exp = readQ();//writeQ(_activeChar.getExp());
		pj.lvl = readD();//writeD(_activeChar.getLevel());
		pj.karma = readD();//writeD(_activeChar.getKarma());	// thx evill33t
		readD();//writeD(0x0);	//?
		pj.INT = readD();//writeD(_activeChar.getINT());
		pj.STR = readD();//writeD(_activeChar.getSTR());
		pj.CON = readD();//writeD(_activeChar.getCON());
		pj.MEN = readD();//writeD(_activeChar.getMEN());
		pj.DEX = readD();//writeD(_activeChar.getDEX());
                pj.WIT = readD();//writeD(_activeChar.getWIT());
      
		//writeD(0x00);
		//writeD(0x00);

		//writeD(_activeChar.getClassId().getId());

		//writeD(0x00);
		//writeD(0x00);
		//writeD(0x00);
		//writeD(0x00); 
        
        //writeB(new byte[64]);
                
                
                getPj().gameSocket.sendPacketToGame((new RequestAll(RequestAll.request.RequestManorList)).getBytes());
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
/*	@Override
	public String getType()
	{
		return _S__21_CHARSELECTED;
	}*/

}
