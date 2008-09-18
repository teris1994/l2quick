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
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.4.2.1.2.3 $ $Date: 2005/03/27 15:29:39 $
 */
public final class TradeStart extends L2GameServerPacket
{
	//private static final String _S__2E_TRADESTART = "[S] 14 TradeStart";
	//private L2PcInstance _activeChar;
	//private L2ItemInstance[] _itemList;

	//public TradeStart (L2PcInstance player)
	//{
		//_activeChar = player;
        //_itemList = _activeChar.getInventory().getAvailableItems(true);
	//}

	@Override
	public void readP()
	{//0x2e TradeStart   d h (h dddhh dhhh)
		//if (_activeChar.getActiveTradeList() == null || _activeChar.getActiveTradeList().getPartner() == null)
			//return;

		//writeC(0x14);
		int objId = readD();//writeD(_activeChar.getActiveTradeList().getPartner().getObjectId());
		int resId = readD();//writeD((_activeChar != null || _activeChar.getTransactionRequester() != null)? _activeChar.getTransactionRequester().getObjectId() : 0);

		int s = readH();//writeH(_itemList.length);
		//for (L2ItemInstance item : _itemList)//int i = 0; i < count; i++)
                for (int i = 0; i < s; i++)
		{
			int type1 = readH();//writeH(item.getItem().getType1()); // item type1
			int itemObjId = readD();//writeD(item.getObjectId());
			int item = readD();//writeD(item.getItemId());
			int count = readD();//writeD(item.getCount());
			int type2 = readH();//writeH(item.getItem().getType2());	// item type2
			readH();//writeH(0x00);	// ?

			int part = readD();//writeD(item.getItem().getBodyPart());	// rev 415  slot    0006-lr.ear  0008-neck  0030-lr.finger  0040-head  0080-??  0100-l.hand  0200-gloves  0400-chest  0800-pants  1000-feet  2000-??  4000-r.hand  8000-r.hand
			int enchant = readH();//writeH(item.getEnchantLevel());	// enchant level
			readH();//writeH(0x00);	// ?
			readH();//writeH(0x00);
			
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
		//return _S__2E_TRADESTART;
	//}
}
