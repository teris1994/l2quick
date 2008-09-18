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

import java.util.List;

//import net.sf.l2j.util.Point3D;
import l2bot.util.Point3D;

/**
 * Format: (ch) d[ddddd]
 *
 * @author  -Wooden-
 */
public class ExCursedWeaponLocation extends L2GameServerPacket
{
	//private static final String _S__FE_46_EXCURSEDWEAPONLOCATION = "[S] FE:47 ExCursedWeaponLocation";
	//private List<CursedWeaponInfo> _cursedWeaponInfo;

	//public ExCursedWeaponLocation(List<CursedWeaponInfo> cursedWeaponInfo)
	//{
		//_cursedWeaponInfo = cursedWeaponInfo;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x47);

		//if(!_cursedWeaponInfo.isEmpty())
		//{
			int s = readD();//writeD(_cursedWeaponInfo.size());
			//for(CursedWeaponInfo w : _cursedWeaponInfo)
			//{
                                for(int i=0;i<s;i++){
                                    int id = readD();//writeD(w.id);
                                    int act = readD();//writeD(w.activated);
                                    int x = readD();//writeD(w.pos.getX());
                                    int y = readD();//writeD(w.pos.getY());
                                    int z = readD();//writeD(w.pos.getZ());
                                    
                                    new CursedWeaponInfo(new Point3D(x,y,z),id,act);
                                }
			//}
		}
		//else
		//{
			//writeD(0);
			//writeD(0);
		//}
	

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_46_EXCURSEDWEAPONLOCATION;
	//}

	public static class CursedWeaponInfo
	{
		public Point3D pos;
		public int id;
		public int activated; //0 - not activated ? 1 - activated

		public CursedWeaponInfo(Point3D p, int ID, int status)
		{
			pos = p;
			id = ID;
			activated = status;
		}

	}
}