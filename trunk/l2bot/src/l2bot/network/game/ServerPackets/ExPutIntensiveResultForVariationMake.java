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

/**
 * Format: (ch)ddddd
 *
 */
public class ExPutIntensiveResultForVariationMake extends L2GameServerPacket
{
	//private static final String _S__FE_53_EXCONFIRMVARIATIONREFINER = "[S] FE:54 ExPutIntensiveResultForVariationMake";

	//private int _refinerItemObjId;
	//private int _lifestoneItemId;
	//private int _gemstoneItemId;
	//private int _gemstoneCount;
	//private int _unk2;

	//public ExPutIntensiveResultForVariationMake(int refinerItemObjId, int lifeStoneId, int gemstoneItemId, int gemstoneCount)
	//{
		//_refinerItemObjId = refinerItemObjId;
		//_lifestoneItemId = lifeStoneId;
		//_gemstoneItemId = gemstoneItemId;
		//_gemstoneCount = gemstoneCount;
		//_unk2 = 1;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x54);
		int objId = readD();//writeD(_refinerItemObjId);
		int lifestone = readD();//writeD(_lifestoneItemId);
		int gemstone = readD();//writeD(_gemstoneItemId);
		int gemstoneC = readD();//writeD(_gemstoneCount);
		readD();//writeD(_unk2);
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_53_EXCONFIRMVARIATIONREFINER;
	//}

}
