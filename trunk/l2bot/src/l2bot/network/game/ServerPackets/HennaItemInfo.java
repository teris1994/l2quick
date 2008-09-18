/*
 * $Header$
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

//import net.sf.l2j.gameserver.model.L2HennaInstance;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;


public class HennaItemInfo extends L2GameServerPacket
{
    //private static final String _S__E3_HennaItemInfo = "[S] e4 HennaItemInfo";

    //private L2PcInstance _activeChar;
    //private L2HennaInstance _henna;

    //public HennaItemInfo(L2HennaInstance henna, L2PcInstance player)
    //{
        //_henna = henna;
        //_activeChar = player;
    //}

    @Override
	public void readP()
    {

        //writeC(0xe4);
        int id = readD();//writeD(_henna.getSymbolId());          //symbol Id
        int item = readD();//writeD(_henna.getItemIdDye());     //item id of dye
        int count = readD();//writeD(_henna.getAmountDyeRequire());    // total amount of dye require
        int price = readD();//writeD(_henna.getPrice());  //total amount of aden require to draw symbol
        readD();//writeD(1);      //able to draw or not 0 is false and 1 is true
        int adena = readD();//writeD(_activeChar.getAdena());

        int INT = readD();//writeD(_activeChar.getINT());   //current INT
        int INT2 = readC();//writeC(_activeChar.getINT()+ _henna.getStatINT());    //equip INT
        int STR = readD();//writeD(_activeChar.getSTR());   //current STR
        int STR2 = readC();//writeC(_activeChar.getSTR()+ _henna.getStatSTR());   //equip STR
        int CON = readD();//writeD(_activeChar.getCON());   //current CON
        int CON2 = readC();//writeC(_activeChar.getCON()+ _henna.getStatCON());    //equip CON
        int MEN = readD();//writeD(_activeChar.getMEN());    //current MEM
        int MEN2 = readC();//writeC(_activeChar.getMEN()+ _henna.getStatMEM());		//equip MEM
        int DEX = readD();//writeD(_activeChar.getDEX());     //current DEX
        int DEX2 = readC();//writeC(_activeChar.getDEX()+ _henna.getStatDEX());		//equip DEX
        int WIT = readD();//writeD(_activeChar.getWIT());     //current WIT
        int WIT2 = readC();//writeC(_activeChar.getWIT()+ _henna.getStatWIT());		//equip WIT
    }

    /* (non-Javadoc)
     * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
     */
    //@Override
	//public String getType()
    //{
        //return _S__E3_HennaItemInfo;
    //}
}
