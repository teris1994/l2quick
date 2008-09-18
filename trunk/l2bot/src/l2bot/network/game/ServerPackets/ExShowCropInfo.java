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
//import net.sf.l2j.gameserver.instancemanager.CastleManorManager.CropProcure;
//import net.sf.l2j.gameserver.model.L2Manor;

/**
 * Format: ch cddd[ddddcdcdcd]
 * c - id (0xFE)
 * h - sub id (0x1D)
 *
 * c
 * d - manor id
 * d
 * d - size
 * [
 * d - crop id
 * d - residual buy
 * d - start buy
 * d - buy price
 * c - reward type
 * d - seed level
 * c - reward 1 items
 * d - reward 1 item id
 * c - reward 2 items
 * d - reward 2 item id
 * ]
 *
 * @author l3x
 */

public class ExShowCropInfo extends L2GameServerPacket
{
	//private static final String _S__FE_1C_EXSHOWSEEDINFO = "[S] FE:24 ExShowCropInfo";
	///private FastList<CropProcure> _crops;
	//private int _manorId;

    //public ExShowCropInfo(int manorId, FastList<CropProcure> crops)
    //{
		//_manorId = manorId;
		//_crops = crops;
		//if (_crops == null)
        //{
			//_crops = new FastList<CropProcure>();
		//}
    //}
//
	@Override
    public void readP()
    {
		//writeC(0xFE);     // Id
		readH();//writeH(0x24);     // SubId
		readC();//writeC(0);
		int id = readD();//writeD(_manorId); // Manor ID
		readD();//writeD(0);
		int s =readD();//writeD(_crops.size());
		//for (CropProcure crop : _crops)
                for (int i = 0; i < s; i++) 
                {
			int cid = readD();//writeD(crop.getId());          // Crop id
			int ammount = readD();//writeD(crop.getAmount());      // Buy residual
			int startAmmont = readD();//writeD(crop.getStartAmount()); // Buy
			int price = readD();//writeD(crop.getPrice());       // Buy price
			int reward = readC();//writeC(crop.getReward());      // Reward
			int lvl = readD();//writeD(L2Manor.getInstance().getSeedLevelByCrop(crop.getId())); // Seed Level
			readC();//writeC(1); // rewrad 1 Type
			int typeId = readD();//writeD(L2Manor.getInstance().getRewardItem(crop.getId(),1));    // Rewrad 1 Type Item Id
			//writeC(1); // rewrad 2 Type
			int typeId2 = readD();//writeD(L2Manor.getInstance().getRewardItem(crop.getId(),2));    // Rewrad 2 Type Item Id
		}
    }

	//@Override
    //public String getType()
    //{
		//return _S__FE_1C_EXSHOWSEEDINFO;
    //}


}
