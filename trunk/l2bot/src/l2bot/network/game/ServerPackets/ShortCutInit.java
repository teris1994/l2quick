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

//import net.sf.l2j.gameserver.model.L2ShortCut;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 *
 * ShortCutInit
 * format   d *(1dddd)/(2ddddd)/(3dddd)
 *
 * @version $Revision: 1.3.2.1.2.4 $ $Date: 2005/03/27 15:29:39 $
 */
public final class ShortCutInit extends L2GameServerPacket
{
	//private static final String _S__57_SHORTCUTINIT = "[S] 45 ShortCutInit";

	//private L2ShortCut[] _shortCuts;
    //private L2PcInstance _activeChar;

	//public ShortCutInit(L2PcInstance activeChar)
	//{
        //_activeChar = activeChar;
//
        //if (_activeChar == null)
			//return;
//
		//_shortCuts = _activeChar.getAllShortCuts();
	//}
//
	@Override
	public void readP()
	{
		//writeC(0x45);
		int s = readD();//writeD(_shortCuts.length);
            for (int i = 0; i < s; i++)
            {
            //L2ShortCut sc = _shortCuts[i];
            int t = readD();//writeD(sc.getType());
            int slot = readD();//writeD(sc.getSlot() + sc.getPage() * 12);
            switch(t)
            {
            case 1://case L2ShortCut.TYPE_ITEM: //1
            	int id = readD();//writeD(sc.getId());
            	readD();//writeD(0x01);
            	readD();//writeD(-1);
            	readD();//writeD(0x00);
            	readD();//writeD(0x00);
            	readH();//writeH(0x00);
            	readH();//writeH(0x00);
            	break;
            case 2://case L2ShortCut.TYPE_SKILL: //2
            	int skill = readD();//writeD(sc.getId());
            	int lvl = readD();//writeD(sc.getLevel());
            	readD();//writeC(0x00); // C5
            	readD();//writeD(0x01); // C6
            	break;
            case 3://case L2ShortCut.TYPE_ACTION: //3
            	int sid = readD();//writeD(sc.getId());
            	readD();//writeD(0x01); // C6
            	break;
            case 4://case L2ShortCut.TYPE_MACRO: //4
            	int mid = readD();//writeD(sc.getId());
            	readD();//writeD(0x01); // C6
            	break;
            case 5://case L2ShortCut.TYPE_RECIPE: //5
            	int recipe = readD();//writeD(sc.getId());
            	readD();//writeD(0x01); // C6
            	break;
            default:
            	readD();//writeD(sc.getId());
        	readD();//writeD(0x01); // C6
            }
	}
    }

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__57_SHORTCUTINIT;
	//}
}
