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

import java.util.Map;

/**
 * Format: ch ddd [ddd]
 * @author  KenM
 */
public class ExGetBossRecord extends L2GameServerPacket
{
	//private static final String _S__FE_33_EXGETBOSSRECORD = "[S] FE:34 ExGetBossRecord";
	//private Map<Integer, Integer> _bossRecordInfo;
	//private int _ranking;
	///private int _totalPoints;

	//public ExGetBossRecord(int ranking, int totalScore, Map<Integer, Integer> list)
	//{
		//_ranking = ranking;
		//_totalPoints = totalScore;
		//_bossRecordInfo = list;
	//}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x34);
		int rank = readD();//writeD(_ranking);
		int points = readD();//writeD(_totalPoints);
		//if (_bossRecordInfo == null)
		//{
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);			
		//}
		//else
		//{
			int s = readD();//writeD(_bossRecordInfo.size()); //list size
			//for (int bossId : _bossRecordInfo.keySet())
                        for (int i = 0; i < s; i++) {
                            int bossId = readD();
                            int record = readD();
                            readD();
                        }
			//{
				//writeD(bossId);
				//writeD(_bossRecordInfo.get(bossId));
				//writeD(0x00); //??
			//}
		//}
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_33_EXGETBOSSRECORD;
	//}
}
