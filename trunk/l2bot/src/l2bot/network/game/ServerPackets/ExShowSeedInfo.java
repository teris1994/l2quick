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

//import javolution.util.FastList;
//import net.sf.l2j.gameserver.instancemanager.CastleManorManager.SeedProduction;
//import net.sf.l2j.gameserver.model.L2Manor;

/**
 * format(packet 0xFE)
 * ch ddd [dddddcdcd]
 * c  - id
 * h  - sub id
 *
 * d  - manor id
 * d
 * d  - size
 *
 * [
 * d  - seed id
 * d  - left to buy
 * d  - started amount
 * d  - sell price
 * d  - seed level
 * c
 * d  - reward 1 id
 * c
 * d  - reward 2 id
 * ]
 *
 * @author l3x
 */
public class ExShowSeedInfo extends L2GameServerPacket {
	//private static final String _S__FE_1C_EXSHOWSEEDINFO = "[S] FE:23 ExShowSeedInfo";
    //private FastList<SeedProduction> _seeds;
    //private int _manorId;

    //public ExShowSeedInfo(int manorId, FastList<SeedProduction> seeds)
    //{
        //_manorId = manorId;
        //_seeds = seeds;
        //if (_seeds == null)
        //{
            //_seeds = new FastList<SeedProduction>();
        //}
    //}

    @Override
    public void readP()
    {
        //writeC(0xFE); // Id
        readH();//writeH(0x23); // SubId
        readC();//writeC(0);
        int mid = readD();//writeD(_manorId); // Manor ID
        readD();//writeD(0);
        int s = readD();//writeD(_seeds.size());
        //for (SeedProduction seed : _seeds)
        for (int i = 0; i < s; i++)
        {
            int id =  readD();//writeD(seed.getId()); // Seed id
            int ledt = readD();//writeD(seed.getCanProduce()); // Left to buy
            int ammount = readD();//writeD(seed.getStartProduce()); // Started amount
            int price = readD();//writeD(seed.getPrice());        // Sell Price
            int lvl = readD();//writeD(L2Manor.getInstance().getSeedLevel(seed.getId())); // Seed Level
            int raward1 = readC();//writeC(1); // reward 1 Type
            int raward1id =readD();//writeD(L2Manor.getInstance().getRewardItemBySeed(seed.getId(),1)); // Reward 1 Type Item Id
            int reward2 = readC();//writeC(1); // reward 2 Type
            int reward2id =readD();//writeD(L2Manor.getInstance().getRewardItemBySeed(seed.getId(),2)); // Reward 2 Type Item Id
        }
    }

    //@Override
    //public String getType()
    //{
        //return _S__FE_1C_EXSHOWSEEDINFO;
    //}
}
