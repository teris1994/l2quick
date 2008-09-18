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


//import net.sf.l2j.gameserver.model.L2RecipeList;


/**
 *
 *
 *
 * format   d d(dd)
 *
 * @version $Revision: 1.1.2.1.2.3 $ $Date: 2005/03/27 15:29:39 $
 */
public class RecipeBookItemList extends L2GameServerPacket
{
	//private static final String _S__D6_RECIPEBOOKITEMLIST = "[S] dc RecipeBookItemList";
	//private L2RecipeList[] _recipes;
	//private boolean _isDwarvenCraft;
 	//private int _maxMp;

	//public RecipeBookItemList(boolean isDwarvenCraft, int maxMp)
	//{
		//_isDwarvenCraft = isDwarvenCraft;
	 	//_maxMp = maxMp;
	//}

	//public void addRecipes(L2RecipeList[] recipeBook)
	//{
		//_recipes = recipeBook;
	//}

	@Override
	public void readP()
	{
		//writeC(0xdc);

		boolean enano = readD() == 0; //writeD(_isDwarvenCraft ? 0x00 : 0x01); //0 = Dwarven - 1 = Common
	 	int mp = readD();//writeD(_maxMp);

		//if (_recipes == null)
		//{
			//writeD(0);
		//}
		//else
		//{
			int s = readD();//writeD(_recipes.length);//number of items in recipe book

			for (int i = 0; i <s; i++)
			{
				//L2RecipeList temp = _recipes[i];
				int id = readD();//writeD(temp.getId());
				readD();//writeD(i+1);
			}
		//}
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__D6_RECIPEBOOKITEMLIST;
	//}
}
