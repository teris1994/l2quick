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

//import net.sf.l2j.gameserver.model.TradeList;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;


/**
 * 3 section to this packet
 * 1)playerinfo which is always sent
 * dd
 *
 * 2)list of items which can be added to sell
 * d(hhddddhhhd)
 *
 * 3)list of items which have already been setup
 * for sell in previous sell private store sell manageent
 * d(hhddddhhhdd) *
 * @version $Revision: 1.3.2.1.2.3 $ $Date: 2005/03/27 15:29:39 $
 */
public class PrivateStoreManageListSell extends L2GameServerPacket
{
	//private static final String _S__B3_PRIVATESELLLISTSELL = "[S] a0 PrivateSellListSell";
	//private L2PcInstance _activeChar;
	//private int _playerAdena;
	//private boolean _packageSale;
	//private TradeList.TradeItem[] _itemList;
	//private TradeList.TradeItem[] _sellList;

	//public PrivateStoreManageListSell(L2PcInstance player, boolean isPackageSale)
	//{
		//_activeChar = player;
		//_playerAdena = _activeChar.getAdena();
		//_activeChar.getSellList().updateItems();
		//_packageSale = isPackageSale;
		//_itemList = _activeChar.getInventory().getAvailableItems(_activeChar.getSellList());
		//_sellList = _activeChar.getSellList().getItems();
	//}

	@Override
	public void readP()
	{
		//writeC(0xa0);
		////section 1
		int objId = readD();//writeD(_activeChar.getObjectId());
		int pack = readD();//writeD(_packageSale ? 1 : 0); // Package sell
		int adena = readD();//writeD(_playerAdena);

		////section2
		int s = readD();//writeD(_itemList.length); //for potential sells
		//for (TradeList.TradeItem item : _itemList)
                for (int i = 0; i < s; i++)
		{
			int type2 = readD();//writeD(item.getItem().getType2());
			int itemObjId = readD();//writeD(item.getObjectId());
			int itemid = readD();//writeD(item.getItem().getItemId());
			int count = readD();//writeD(item.getCount());
			readH();//writeH(0);
			int enchant = readH();//writeH(item.getEnchant());//enchant lvl
			readH();//writeH(0);
			int bodypart = readD();//writeD(item.getItem().getBodyPart());
			int price = readD();//writeD(item.getPrice()); //store price			
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
		////section 3
		s = readD();//writeD(_sellList.length); //count for any items already added for sell
		//for (TradeList.TradeItem item : _sellList)
                for (int i = 0; i < s; i++) 
		{
			int type2 = readD();//writeD(item.getItem().getType2());
			int itemObjId = readD();//writeD(item.getObjectId());
			int itemId = readD();//writeD(item.getItem().getItemId());
			int count = readD();//writeD(item.getCount());
			readH();//writeH(0);
			int enchant = readH();//writeH(item.getEnchant());//enchant lvl
			readH();//writeH(0x00);
			int part = readD();//writeD(item.getItem().getBodyPart());
			int price = readD();//writeD(item.getPrice());//your price
			int finalPrice = readD();//writeD(item.getItem().getReferencePrice()); //store price
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
		//return _S__B3_PRIVATESELLLISTSELL;
	//}
}
