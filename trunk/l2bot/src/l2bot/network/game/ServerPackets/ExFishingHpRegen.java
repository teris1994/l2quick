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
 * Format (ch)dddcccd
 * d: cahacter oid
 * d: time left
 * d: fish hp
 * c:
 * c:
 * c: 00 if fish gets damage 02 if fish regens
 * d:
 * @author -Wooden-
 *
 */
public class ExFishingHpRegen extends L2GameServerPacket
{
	//private static final String _S__FE_16_EXFISHINGHPREGEN = "[S] FE:28 ExFishingHPRegen";
	//private L2Character _activeChar;
	//private int _time, _fishHP, _hpMode, _anim, _goodUse, _penalty, _hpBarColor;

	//public ExFishingHpRegen(L2Character character, int time, int fishHP, int HPmode, int GoodUse, int anim, int penalty, int hpBarColor)
	//{
		////_activeChar = character;
		//_time = time;
		//_fishHP = fishHP;
		//_hpMode = HPmode;
		//_goodUse = GoodUse;
		//_anim = anim;
		//_penalty = penalty;
		//_hpBarColor = hpBarColor;
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x28);

		int objId = readD();//writeD(_activeChar.getObjectId());
		int time = readD();//writeD(_time);
		int hp = readD();//writeD(_fishHP);
		int hpMode = readC();//writeC(_hpMode); // 0 = HP stop, 1 = HP raise
		int good = readC();//writeC(_goodUse); // 0 = none, 1 = success, 2 = failed
		int anim = readC();//writeC(_anim); // Anim: 0 = none, 1 = reeling, 2 = pumping
		int pen = readD();//writeD(_penalty); // Penalty
		int barc = readC();//writeC(_hpBarColor); // 0 = normal hp bar, 1 = purple hp bar

	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_16_EXFISHINGHPREGEN;
	//}

}