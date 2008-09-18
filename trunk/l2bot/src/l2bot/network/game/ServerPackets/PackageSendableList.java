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

//import net.sf.l2j.gameserver.model.L2ItemInstance;

/**
 *
 *
 * @author  -Wooden-
 */
public class PackageSendableList extends L2GameServerPacket
{
	//private static final String _S__C3_PACKAGESENDABLELIST = "[S] d2 PackageSendableList";
	//private L2ItemInstance[] _items;
	//private int _playerObjId;

	//public PackageSendableList(L2ItemInstance[] items, int playerObjId)
	//{
		//_items = items;
		//_playerObjId = playerObjId;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xd2);
//
		int objid = readD();//writeD(_playerObjId);
		int adena = readD();//writeD(getClient().getActiveChar().getAdena());
		int s = readD();//writeD(_items.length);
                for (int i = 0; i < s; i++) 
		//for(L2ItemInstance item : _items) // format inside the for taken from SellList part use should be about the same
		{
			readH();//writeH(item.getItem().getType1());
			readD();//writeD(item.getObjectId());
			readD();//writeD(item.getItemId());
			readD();//writeD(item.getCount());
			readH();//writeH(item.getItem().getType2());
			readH();//writeH(item.getCustomType1());
			readD();//writeD(item.getItem().getBodyPart());
			readH();//writeH(item.getEnchantLevel());
			readH();//writeH(item.getCustomType2());
			readH();//writeH(0x00);
			readD();//writeD(item.getObjectId()); // some item identifier later used by client to answer (see RequestPackageSend) not item id nor object id maybe some freight system id??
			////T1
			readD();//writeD(item.getAttackAttrElement()); //element type 
			readD();//writeD(item.getAttackAttrElementVal()); //element val 
			readD();//writeD(item.getDefAttrFire()); //fire element
			readD();//writeD(item.getDefAttrWater()); //water element
			readD();//writeD(item.getDefAttrWind()); //wind element
			readD();//writeD(item.getDefAttrEarth()); //earth element
			readD();//writeD(item.getDefAttrHoly()); //holy element
			readD();//writeD(item.getDefAttrUnholy()); //unholy element
		}

	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	///@Override
	//public String getType()
	//{
		//return _S__C3_PACKAGESENDABLELIST;
	//}

}