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

/**
 * Format (ch)ddddd
 * @author -Wooden-
 *
 */
public class ExFishingStart extends L2GameServerPacket
{
	//private static final String _S__FE_13_EXFISHINGSTART = "[S] FE:1e ExFishingStart";
	//private L2Character _activeChar;
	//private int _x,_y,_z, _fishType;
	//@SuppressWarnings("unused")
	//private boolean _isNightLure;

	//public ExFishingStart(L2Character character, int fishType, int x, int y,int z, boolean isNightLure)
	//{
		//_activeChar = character;
		//_fishType = fishType;
		//_x = x;
		//_y = y;
		//_z = z;
		//_isNightLure = isNightLure;
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x1e);
		int objId = readD();//writeD(_activeChar.getObjectId());
		int fish = readD();//writeD(_fishType); // fish type
		int x = readD();//writeD(_x); // x poisson
		int y = readD();//writeD(_y); // y poisson
		int z = readD();//writeD(_z); // z poisson
		readC();//writeC(0x00); // night lure
		readC();//writeC(0x00); //??
		int type = readC();//writeC((_fishType >= 7 && _fishType <= 9) ? 0x01 : 0x00); // 0 = day lure  1 = night lure
		//writeC(0x00);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_13_EXFISHINGSTART;
	//}

}