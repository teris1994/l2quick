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

//import java.util.List;

//import javolution.util.FastList;
//import net.sf.l2j.gameserver.model.L2Object;

/**
 *
 * @author  KenM
 */
public final class ExShowTrace extends L2GameServerPacket
{
    //private final List<Trace> _traces = new FastList<Trace>();
    
    //public void addTrace(int x, int y, int z, int time)
    //{
        //_traces.add(new Trace(x, y, z, time));
    //}
    
    //public void addTrace(L2Object obj, int time)
    //{
        //this.addTrace(obj.getX(), obj.getY(), obj.getZ(), time);
    //}
    
    //static final class Trace
    //{
        //public final int _x;
        //public final int _y;
        //public final int _z;
        //public final int _time;
        
        //public Trace(int x, int y, int z, int time)
        //{
            ///_x = x;
            //_y = y;
            //_z = z;
            //_time = time;
        //}
    //}
    
    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    //@Override
    //public String getType()
    //{
        //return "[S] FE:67 ExShowTrace";
    //}

    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    public void readP()
    {
        //writeC(0xfe);
        readH();//writeH(0x67);      
        int s = readH();//writeH(_traces.size());
        //for (Trace t : _traces)
        for (int i = 0; i < s; i++) 
        {
            int x = readD();//writeD(t._x);
            int y = readD();//writeD(t._y);
            int z = readD();//writeD(t._z);
            int time = readH();//writeH(t._time);
        }
    }
    
}
