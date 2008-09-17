ServerPacket

I have copied&pasted all files from L2J server source.
The files must be modified to work

1.-All Classes must extend L2GameServerPacket
2.-Empty canstructor
3.-dont delete the code inside writeImp method, simply comment it and rename the method
4.-it's recomendable to add a packet example for help other devs
5.-make sure that the packet is added in packeshandler.java whith the corect id

Example:



--------------------------------------
---------NOT MODIFIED CLASS-----------
--------------------------------------



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

import net.sf.l2j.gameserver.model.actor.instance.L2DoorInstance;

/**
 * 60
 * d6 6d c0 4b		door id
 * 8f 14 00 00 		x
 * b7 f1 00 00 		y
 * 60 f2 ff ff 		z
 * 00 00 00 00 		??
 *
 * format  dddd    rev 377  ID:%d X:%d Y:%d Z:%d
 *         ddddd   rev 419
 *
 * @version $Revision: 1.3.2.2.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public final class DoorInfo extends L2GameServerPacket
{
	private static final String _S__60_DOORINFO = "[S] 4c DoorInfo";
	private final L2DoorInstance _door;

	public DoorInfo(L2DoorInstance door)
	{
		_door = door;
	}

	@Override
	protected final void writeImpl()
	{
		writeC(0x4c);
		writeD(_door.getObjectId());
		writeD(_door.getDoorId());
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	@Override
	public String getType()
	{
		return _S__60_DOORINFO;
	}

}


----------------------------------
---------MODIFIED CLASS-----------
----------------------------------


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

//import net.sf.l2j.gameserver.model.actor.instance.L2DoorInstance;

/**
 * 60
 * d6 6d c0 4b		door id
 * 8f 14 00 00 		x
 * b7 f1 00 00 		y
 * 60 f2 ff ff 		z
 * 00 00 00 00 		??
 *
 * format  dddd    rev 377  ID:%d X:%d Y:%d Z:%d
 *         ddddd   rev 419
 *
 * @version $Revision: 1.3.2.2.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public class DoorInfo extends L2GameServerPacket
{
	//private static final String _S__60_DOORINFO = "[S] 4c DoorInfo";
	//private final L2DoorInstance _door;

	//public DoorInfo(L2DoorInstance door)
	//{
	//	_door = door;
	//}

	@Override
	public void readP()
	{
		//writeC(0x4c); (the first byte is the optcode, not read it)
		int objId = readD();//writeD(_door.getObjectId());
		int doorId= readD();//writeD(_door.getDoorId());
                
                getPj().doorHandler.add(objId, doorId);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
	//	return _S__60_DOORINFO;
	//}
}