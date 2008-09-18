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
//import net.sf.l2j.gameserver.model.actor.instance.L2MerchantInstance;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.2.2.3.2.6 $ $Date: 2005/03/27 15:29:57 $
 */
public class PrivateStoreListSell extends L2GameServerPacket
{
	//private static final String _S__B4_PRIVATESTORELISTSELL = "[S] a1 PrivateStoreListSell";
	//private L2PcInstance _storePlayer;
	//private L2PcInstance _activeChar;
	//private int _playerAdena;
	//private boolean _packageSale;
	//private TradeList.TradeItem[] _items;

	// player's private shop
	//public PrivateStoreListSell(L2PcInstance player, L2PcInstance storePlayer)
	//{
		//_activeChar = player;
		//_storePlayer = storePlayer;
		//_playerAdena = _activeChar.getAdena();
		//_items = _storePlayer.getSellList().getItems();
		//_packageSale = _storePlayer.getSellList().isPackaged();
	//}

	// lease shop
	//@Deprecated public PrivateStoreListSell(L2PcInstance player, L2MerchantInstance storeMerchant)
	//{
		//_activeChar = player;
		//_playerAdena = _activeChar.getAdena();
		//_items = _storePlayer.getSellList().getItems();
		//_packageSale = _storePlayer.getSellList().isPackaged();
	//}

	//@Override
	public void readP()
	{
		//writeC(0xa1);
		int objId = readD();//writeD(_storePlayer.getObjectId());
		boolean pack = readD() != 0;//writeD(_packageSale ? 1 : 0);
		int adena = readD();//writeD(_playerAdena);

		int s = readD();//writeD(_items.length);
		//for (TradeList.TradeItem item : _items)
                for (int i = 0; i < s; i++) 
		{
			int type2 = readD();//writeD(item.getItem().getType2());
			int objid = readD();//writeD(item.getObjectId());
			int itemId = readD();//writeD(item.getItem().getItemId());
                        int count = readD();//writeD(item.getCount());
			readH();//writeH(0x00);
			int enchant = readH();//writeH(item.getEnchant());
			readH();//writeH(0x00);
			int part = readD();//writeD(item.getItem().getBodyPart());
			int price = readD();//writeD(item.getPrice()); //your price
			int storeprice = readD();//writeD(item.getItem().getReferencePrice()); //store price			
			readD();//// T1
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
		//return _S__B4_PRIVATESTORELISTSELL;
	//}
}
