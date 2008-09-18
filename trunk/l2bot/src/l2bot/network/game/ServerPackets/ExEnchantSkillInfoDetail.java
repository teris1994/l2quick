/* This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l2bot.network.game.ServerPackets;

/**
 *
 * @author  KenM
 */
public class ExEnchantSkillInfoDetail extends L2GameServerPacket
{
    //private final int _itemId;
    //private final int _itemCount;
    
    //public ExEnchantSkillInfoDetail(int itemId, int itemCount)
    //{
        //_itemId = itemId;
        //_itemCount = itemCount;
    //}
    
    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    //@Override
    //public String getType()
    //{
        //return "[S] FE:5E ExEnchantSkillInfoDetail";
    //}

    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    public void readP()
    {
        //writeC(0xfe);
        readH();//writeH(0x5e);
        
        readD();//writeD(0);
        readD();//writeD(0);
        readD();//writeD(0);
        readD();//writeD(0);
        readQ();//writeQ(0);
        readD();//writeD(0);
        int count = readD();//writeD(_itemCount); // Count
        readD();//writeD(0);
        int id = readD();//writeD(_itemId); // ItemId Required
        //writeD(0);
    }
    
}
