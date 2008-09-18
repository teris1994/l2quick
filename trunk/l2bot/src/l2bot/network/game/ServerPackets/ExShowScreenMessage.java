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

/**
 * @author Kerberos
 *
 */
public class ExShowScreenMessage extends L2GameServerPacket
{
	//private String _text;
	//private int _time;

	//public ExShowScreenMessage (String text, int time)
	//{
		//_text = text;
		//_time = time;
	//}

	//@Override
	//public String getType()
	//{
		//return "ExShowScreenMessage";
	//}

	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x39);
//
		readD();//writeD(0x01);
		readD();//writeD(-1);
		readD();//writeD(0x02);
		readD();//writeD(0x00);
		readD();//writeD(0x00);
		readD();//writeD(0x00);
//
		readD();//writeD(0);
		readD();//writeD(0);
//
		int time = readD();//writeD(_time);
//
		readD();//writeD(1);

		
                String text = readS();//writeS(_text);
	}

}