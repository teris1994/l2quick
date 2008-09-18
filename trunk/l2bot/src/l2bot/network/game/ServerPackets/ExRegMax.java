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

public class ExRegMax extends L2GameServerPacket
{

	//private static final String _S__FE_01_EXREGMAX = "[S] FE:01 ExRegenMax";
	//private double _max;
	//private int _count;
	//private int _time;

	//public ExRegMax(double max, int count, int time)
	//{
		//_max = max;
		//_count = count;
		//_time = time;
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x01);
		readD();//writeD(1);
		int count = readD();//writeD(_count);
		int time = readD();//writeD(_time);
		double max = readF();//writeF(_max);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_01_EXREGMAX;
	//}
	
}
