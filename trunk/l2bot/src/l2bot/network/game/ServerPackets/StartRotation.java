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

//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

public final class StartRotation extends L2GameServerPacket
{
	//private static final String _S__77_BEGINROTATION = "[S] 7a BeginRotation";
	//private int _charObjId;
	//private int _degree;
	//private int _side;

	//public StartRotation(L2PcInstance player, int degree, int side)
	//{
		//_charObjId = player.getObjectId();
		//_degree = degree;
		//_side = side;
	//}

	@Override
	public void readP()
	{
		//writeC(0x7a);
		int objId = readD();//writeD(_charObjId);
		int degree = readD();//writeD(_degree);
		int side = readD();//writeD(_side);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__77_BEGINROTATION;
	//}
}