/*
 * $Header: MultiSellList.java, 2/08/2005 14:21:01 luisantonioa Exp $
 *
 * $Author: luisantonioa $
 * $Date: 2/08/2005 14:21:01 $
 * $Revision: 1 $
 * $Log: MultiSellList.java,v $
 * Revision 1  2/08/2005 14:21:01  luisantonioa
 * Added copyright notice
 *
 *
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

//import net.sf.l2j.gameserver.datatables.ItemTable;
//import net.sf.l2j.gameserver.model.L2Multisell.MultiSellEntry;
//import net.sf.l2j.gameserver.model.L2Multisell.MultiSellIngredient;
//import net.sf.l2j.gameserver.model.L2Multisell.MultiSellListContainer;


/**
 * This class ...
 *
 * @version $Revision: 1.2 $ $Date: 2004/06/27 08:12:59 $
 */
public final class MultiSellList extends L2GameServerPacket
{
    //private static final String _S__D0_MULTISELLLIST = "[S] d0 MultiSellList";

    //protected int _listId, _page, _finished;
    //protected MultiSellListContainer _list;

    //public MultiSellList(MultiSellListContainer list, int page, int finished)
    //{
    	//_list = list;
    	//_listId = list.getListId();
    	//_page = page;
    	//_finished = finished;
    //}

    @Override
	public void readP()
    {
    	// [ddddd] [dchh] [hdhdh] [hhdh]

        //writeC(0xd0);
        int id = readD();//writeD(_listId);    // list id
        int page = readD();//writeD(_page);		// page
        int fin = readD();//writeD(_finished);	// finished
        int sz = readD();//writeD(0x28);	// size of pages
        int s = readD();//writeD(_list == null ? 0 : _list.getEntries().size()); //list length

        //if(_list != null)
        //{
            //for(MultiSellEntry ent : _list.getEntries())
            for (int i = 0; i < s; i++) 
            {
            	int enid = readD();//writeD(ent.getEntryId());
            	readC();//writeC(1);
                readH();//writeH(0x00); // C6
                readD();//writeD(0x00); // C6
                readD();//writeD(-2); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
                readD();//writeD(0x00); // T1
            	int s2 = readD();//writeH(ent.getProducts().size());
            	int s3 = readD();//writeH(ent.getIngredients().size());
            	//for(MultiSellIngredient i: ent.getProducts())
                for (int j = 0; j < s2; j++) 
            	{
	            int item = readD();//writeD(i.getItemId());
	            readD();//writeD(0);
	            int type2 = readH();//writeH(ItemTable.getInstance().getTemplate(i.getItemId()).getType2());
	            int count = readD();//writeD(i.getItemCount());
	            int enchant = readH();//writeH(i.getEnchantmentLevel()); //enchtant lvl
	            readD();//writeD(0x00); // C6
	            readD();//writeD(0x00); // C6
                    readD();//writeD(-2); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
            	}
//
                //for(MultiSellIngredient i : ent.getIngredients())
                for (int j = 0; j < s3; j++) 
                {
                    //int items = i.getItemId();
                    //int typeE = 65535;
                    //if (items != -200)
                    //typeE = ItemTable.getInstance().getTemplate(i.getItemId()).getType2();
                    int item = readD();//writeD(items);      //ID
                    int type2 = readH();//writeH(typeE);
                    int count = readD();//writeD(i.getItemCount());	//Count
                    int enchant = readH();//writeH(i.getEnchantmentLevel()); //Enchant Level
                    readD();//writeD(0x00); // C6
                    readD();//writeD(0x00); // C6
                    readD();//writeD(-2); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                    readD();//writeD(0x00); // T1
                }
            }
        //}
    }

    //@Override
    //public String getType()
    //{
        //return _S__D0_MULTISELLLIST;
    //}

}
