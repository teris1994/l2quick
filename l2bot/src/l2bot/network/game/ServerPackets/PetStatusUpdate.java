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

//import net.sf.l2j.gameserver.model.L2Summon;
//import net.sf.l2j.gameserver.model.actor.instance.L2PetInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.5.2.3.2.5 $ $Date: 2005/03/29 23:15:10 $
 */
public class PetStatusUpdate extends L2GameServerPacket
{
	//private static final String _S__CE_PETSTATUSSHOW = "[S] b6 PetStatusUpdate";

	//private L2Summon _summon;
	//private int _maxHp, _maxMp;
	//private int _maxFed, _curFed;

	//public PetStatusUpdate(L2Summon summon)
	//{
        //_summon = summon;
        //_maxHp = _summon.getMaxHp();
		//_maxMp = _summon.getMaxMp();
		//if (_summon instanceof L2PetInstance)
		//{
			//L2PetInstance pet = (L2PetInstance)_summon;
			//_curFed = pet.getCurrentFed(); // how fed it is
			//_maxFed = pet.getMaxFed(); //max fed it can be
		//}
	//}

	@Override
	public void readP()
	{
		//writeC(0xb6);
		int type = readD();//writeD(_summon.getSummonType());
		int objid = readD();//writeD(_summon.getObjectId());
		int x = readD();//writeD(_summon.getX());
		int y = readD();//writeD(_summon.getY());
		int z = readD();//writeD(_summon.getZ());
		String title = readS();//writeS(_summon.getTitle());
		int food = readD();//writeD(_curFed);
		int maxFood = readD();//writeD(_maxFed);
		int hp = readD();//writeD((int)_summon.getCurrentHp());
		int maxHp = readD();//writeD(_maxHp);
		int mp = readD();//writeD((int)_summon.getCurrentMp());
		int maxMp = readD();//writeD(_maxMp);
		int lvl = readD();//writeD(_summon.getLevel());
		long exp = readQ();//writeQ(_summon.getStat().getExp());
		long exp4ThisLvl = readQ();//writeQ(_summon.getExpForThisLevel());// 0% absolute value
		long exp4NextLvl = readQ();//writeQ(_summon.getExpForNextLevel());// 100% absolute value
	}

	//@Override
	//public String getType()
	//{
		//return _S__CE_PETSTATUSSHOW;
	//}
}
