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

//import net.sf.l2j.gameserver.model.L2CharPosition;
//import net.sf.l2j.gameserver.model.L2Character;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author Maktakien
 *
 */
public class MoveToLocationInVehicle extends L2GameServerPacket
{
	//private int _charObjId;
	//private int _boatId;
	//private L2CharPosition _destination;
	//private L2CharPosition _origin;
	/**
	 * @param actor
	 * @param destination
	 * @param origin
	 */
	//public MoveToLocationInVehicle(L2Character actor, L2CharPosition destination, L2CharPosition origin)
	//{
		//if (!(actor instanceof L2PcInstance)) return;
//
		//L2PcInstance player = (L2PcInstance)actor;
//
		//if (player.getBoat() == null) return;
//
		//_charObjId = player.getObjectId();
		//_boatId = player.getBoat().getObjectId();
		//_destination = destination;
		//_origin = origin;
	///*	_pci.sendMessage("_destination : x " + x +" y " + y + " z " + z);
		//_pci.sendMessage("_boat : x " + _pci.getBoat().getX() +" y " + _pci.getBoat().getY() + " z " + _pci.getBoat().getZ());
		//_pci.sendMessage("-----------");*/
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0x7e);
                int objId = readD();//writeD(_charObjId);
                int boat = readD();//writeD(_boatId);
		int x1 = readD();//writeD(_destination.x);
		int y1 = readD();//writeD(_destination.y);
		int z1 = readD();//writeD(_destination.z);
		int x0 = readD();//writeD(_origin.x);
		int y0 = readD();//writeD(_origin.y);
		int z0 = readD();//writeD(_origin.z);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return "[S] 7e MoveToLocationInVehicle";
	//}

}
