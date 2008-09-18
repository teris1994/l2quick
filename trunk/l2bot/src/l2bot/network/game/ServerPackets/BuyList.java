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

//import java.util.Collection;
//import java.util.List;

//import net.sf.l2j.Config;
//import net.sf.l2j.gameserver.model.L2TradeList;
//import net.sf.l2j.gameserver.model.L2TradeList.L2TradeItem;
//import net.sf.l2j.gameserver.templates.L2Item;

/**
 * sample
 *
 * 1d
 * 1e 00 00 00 			// ??
 * 5c 4a a0 7c 			// buy list id
 * 02 00				// item count
 *
 * 04 00 				// itemType1  0-weapon/ring/earring/necklace  1-armor/shield  4-item/questitem/adena
 * 00 00 00 00 			// objectid
 * 32 04 00 00 			// itemid
 * 00 00 00 00 			// count
 * 05 00 				// itemType2  0-weapon  1-shield/armor  2-ring/earring/necklace  3-questitem  4-adena  5-item
 * 00 00
 * 60 09 00 00			// price
 *
 * 00 00
 * 00 00 00 00
 * b6 00 00 00
 * 00 00 00 00
 * 00 00
 * 00 00
 * 80 00 				//	body slot 	 these 4 values are only used if itemtype1 = 0 or 1
 * 00 00 				//
 * 00 00 				//
 * 00 00 				//
 * 50 c6 0c 00
 *

 * format   dd h (h dddhh hhhh d)	revision 377
 * format   dd h (h dddhh dhhh d)	revision 377
 *
 * @version $Revision: 1.4.2.1.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public final class BuyList extends L2GameServerPacket
{
	//private static final String _S__1D_BUYLIST = "[S] 07 BuyList";
	//private int _listId;
	//private Collection<L2TradeItem> _list;
	//private int _money;
	//private double _taxRate = 0;

	//public BuyList(L2TradeList list, int currentMoney)
	//{
		//_listId = list.getListId();
		//_list = list.getItems();
		//_money = currentMoney;
	//}

	//public BuyList()
	//{
		//_listId = list.getListId();
        //_list = list.getItems();
		//_money = currentMoney;
		//_taxRate = taxRate;
	//}

	//public BuyList(List<L2TradeItem> lst, int listId, int currentMoney)
	//{
		//_listId = listId;
		//_list = lst;
		//_money = currentMoney;
	//}

	@Override
	public void readP()
	{
		//writeC(0x07);
		int adena = readD();//writeD(_money);		// current money
		int id = readD();//writeD(_listId);

		int s = readH();//writeH(_list.size());

                for (int i = 0; i <s; i++) {
                
		//for (L2TradeItem item : _list)
		//{
			//if (item.getCurrentCount() > 0 || !item.hasLimitedStock())
            //{
				int type = readH();//writeH(item.getTemplate().getType1()); // item type1
				readD();//writeD(0x00); //objectId
				int itid = readD();//writeD(item.getItemId());
				int count = readD();//writeD(item.getCurrentCount() <0 ? 0 : item.getCurrentCount());
				int type2 = readH();//writeH(item.getTemplate().getType2());	// item type2
				readH();//writeH(0x00);	// ?
//
				//if (item.getTemplate().getType1() != L2Item.TYPE1_ITEM_QUESTITEM_ADENA)
				//{
				int bodypart = readD();	//writeD(item.getTemplate().getBodyPart());
				int enchant = readD();	//writeH(0x00); // item enchant level
				readH();	//writeH(0x00); // ?
				readH();	//writeH(0x00);
				//}
				//else
				//{
					//writeD(0x00);
					//writeH(0x00);
					//writeH(0x00);
					//writeH(0x00);
				//}
//
	            //if (item.getItemId() >= 3960 && item.getItemId() <= 4026)//Config.RATE_SIEGE_GUARDS_PRICE-//'
	                int precio = readD();//writeD((int)(item.getPrice() * Config.RATE_SIEGE_GUARDS_PRICE * (1 + _taxRate)));
	            //else
	                //writeD((int)(item.getPrice() * (1 + _taxRate)));
                
                // T1
                readD();//writeD(-2);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
                readD();//writeD(0x00);
			//}
		}
	}
    
	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__1D_BUYLIST;
	//}
}
