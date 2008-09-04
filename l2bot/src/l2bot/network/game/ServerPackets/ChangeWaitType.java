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

//import net.sf.l2j.gameserver.model.L2Character;

import l2bot.pj.cosas.Character;




/**
 *
 * sample
 *
 * 0000: 3f 2a 89 00 4c 01 00 00 00 0a 15 00 00 66 fe 00    ?*..L........f..
 * 0010: 00 7c f1 ff ff                                     .|...
 *
 * format   dd ddd
 *
 * @version $Revision: 1.3.2.1.2.4 $ $Date: 2005/03/27 15:29:57 $
 */
public class ChangeWaitType extends L2GameServerPacket
{
	//private static final String _S__3F_CHANGEWAITTYPE = "[S] 29 ChangeWaitType";
	//private int _charObjId;
	//private int _moveType;
	//private int _x, _y, _z;

    //public static final int WT_SITTING = 0;
    //public static final int WT_STANDING = 1;
    //public static final int WT_START_FAKEDEATH = 2;
    //public static final int WT_STOP_FAKEDEATH = 3;

	//public ChangeWaitType(L2Character character, int newMoveType)
	//{
		//_charObjId = character.getObjectId();
		//_moveType = newMoveType;

		//_x = character.getX();
		//_y = character.getY();
		//_z = character.getZ();
	//}

	@Override
	public void readP()
	{
		//writeC(0x29);
		int obj = readD();//writeD(_charObjId);
                Character chr = getPj().chars.get(obj);
                int mde = readD();//writeD(_moveType);
		chr.isSit =  mde== 0;
                chr.isFakeDeath = mde == 2;
		chr.getPosition().setXYZ(readD(), readD(), readD());//writeD(_x);
		//writeD(_y);
		//writeD(_z);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__3F_CHANGEWAITTYPE;
	//}
}
