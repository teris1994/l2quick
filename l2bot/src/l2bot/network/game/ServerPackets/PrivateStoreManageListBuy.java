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
//import net.sf.l2j.gameserver.model.TradeList;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.3.2.1.2.4 $ $Date: 2005/03/27 15:29:40 $
 */
public class PrivateStoreManageListBuy extends L2GameServerPacket
{
	//private static final String _S__D0_PRIVATESELLLISTBUY = "[S] bd PrivateStoreManageListBuy";
	//private L2PcInstance _activeChar;
	//private int _playerAdena;
	//private L2ItemInstance[] _itemList;
	//private TradeList.TradeItem[] _buyList;

	//public PrivateStoreManageListBuy(L2PcInstance player)
	//{
		//_activeChar = player;
		//_playerAdena = _activeChar.getAdena();
		//_itemList = _activeChar.getInventory().getUniqueItems(false,true);
		//_buyList = _activeChar.getBuyList().getItems();
	//}

	@Override
	public void readP()
	{
		//writeC(0xbd);
		////section 1
		int objId = readD();//writeD(_activeChar.getObjectId());
		int adena = readD();//writeD(_playerAdena);

		////section2
		int s = readD();//writeD(_itemList.length); // inventory items for potential buy
		//for (L2ItemInstance item : _itemList)
                for (int i = 0; i < s; i++) 
		{
			int id = readD();//writeD(item.getItemId());
			readH();//writeH(0); //show enchant lvl as 0, as you can't buy enchanted weapons
			int count = readD();//writeD(item.getCount());
			int price = readD();//writeD(item.getReferencePrice());
			readH();//writeH(0x00);
			int part = readD();//writeD(item.getItem().getBodyPart());
			int type2 = readD();//writeH(item.getItem().getType2());

			//// T1
			readD();//writeD(item.getAttackAttrElement());
			readD();//writeD(item.getAttackAttrElementVal());
			readD();//writeD(item.getDefAttrFire());
			readD();//writeD(item.getDefAttrWater());
			readD();//writeD(item.getDefAttrWind());
			readD();//writeD(item.getDefAttrEarth());
			readD();//writeD(item.getDefAttrHoly());
			readD();//writeD(item.getDefAttrUnholy());
		}

		//section 3
		s = readD();//writeD(_buyList.length); //count for all items already added for buy
		for (int i = 0; i < s; i++) 
		{
			readD();//writeD(item.getItem().getItemId());
			readD();//writeH(0);
			readD();//writeD(item.getCount());
			readD();//writeD(item.getItem().getReferencePrice());
			readD();//writeH(0x00);
			readD();//writeD(item.getItem().getBodyPart());
			readD();//writeH(item.getItem().getType2());
			readD();//writeD(item.getPrice());//your price
			readD();//writeD(item.getItem().getReferencePrice());//fixed store price
			
			// T1
                        readD();//writeD(item.getAttackAttrElement());
                        readD();//writeD(item.getAttackAttrElementVal());
                        readD();//writeD(item.getDefAttrFire());
                        readD();//writeD(item.getDefAttrWater());
                        readD();//writeD(item.getDefAttrWind());
                        readD();//writeD(item.getDefAttrEarth());
                        readD();//writeD(item.getDefAttrHoly());
                        readD();//writeD(item.getDefAttrUnholy());
		}
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__D0_PRIVATESELLLISTBUY;
	//}
}
