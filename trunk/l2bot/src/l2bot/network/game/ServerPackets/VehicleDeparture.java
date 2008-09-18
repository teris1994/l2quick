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

//import net.sf.l2j.gameserver.model.actor.instance.L2BoatInstance;

/**
 * @author Maktakien
 *
 */
public class VehicleDeparture extends L2GameServerPacket
{

	//private L2BoatInstance _boat;
	//private int _speed1;
	//private int _speed2;//rotation
	//private int _x;
	//private int _y;
	//private int _z;
	/**
	 * @param _boat
	 * @param speed1
	 * @param speed2
	 * @param x
	 * @param y
	 * @param z
	 */
	//public VehicleDeparture(L2BoatInstance boat, int speed1, int speed2, int x, int y, int z)
	//{
		//_boat = boat;
		//_speed1 = speed1;
		//_speed2 = speed2;
		//_x = x;
		//_y = y;
		//_z = z;
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0x6c);
		int objId = readD();//writeD(_boat.getObjectId());
		int speed = readD();//writeD(_speed1);
		int speed2 = readD();//writeD(_speed2);
		int x = readD();//writeD(_x);
		int y = readD();//writeD(_y);
		int z = readD();//writeD(_z);

	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//// TODO Auto-generated method stub
		//return "[S] 5A VehicleDeparture";
	//}

}
