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

//import net.sf.l2j.gameserver.model.L2Character;
//import net.sf.l2j.gameserver.model.L2Object;

/**
 *
 * @author  KenM
 */
public final class FlyToLocation extends L2GameServerPacket
{
    //private final L2Character _cha;
    //private final int _destX, _destY, _destZ;
    //private final FlyType _type;
    
    public enum FlyType
    {
        THROW_UP,
        THROW_HORIZONTAL,
        DUMMY, // no effect
        CHARGE;
    }
    
    //public FlyToLocation(L2Character cha, int destX, int destY, int destZ, FlyType type)
    //{
        //_cha = cha;
        //_destX = destX;
        //_destY = destY;
        //_destZ = destZ;
        //_type = type;
    //}
    
    //public FlyToLocation(L2Character cha, L2Object dest, FlyType type)
    //{
        //this(cha, dest.getX(), dest.getY(), dest.getZ(), type);
    //}
    
    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    //@Override
    //public String getType()
    //{
        //return "[S] 0xd4 FlyToLocation";
    //}

    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    public void readP()
    {
        //writeC(0xd4);
        int objId = readD();//writeD(_cha.getObjectId());
        int x = readD();//writeD(_destX);
        int y = readD();//writeD(_destY);
        int z = readD();//writeD(_destZ);
        int x0 = readD();//writeD(_cha.getX());
        int y0 = readD();//writeD(_cha.getY());
        int z0 = readD();//writeD(_cha.getZ());
        FlyType type = FlyType.values()[readD()];//writeD(_type.ordinal());
    }
    
}
