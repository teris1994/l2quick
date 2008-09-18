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

//import java.util.Collection;

//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance.TimeStamp;

/**
 *
 * @author  KenM
 */
public class SkillCoolTime extends L2GameServerPacket
{
    //public Collection<TimeStamp> _reuseTimeStamps;
    
    //public SkillCoolTime(/*L2PcInstance cha*/)
    //{
        //_reuseTimeStamps = cha.getReuseTimeStamps();
    //}
    
    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    /*@Override
    public String getType()
    {
        return "[S] C7 SkillCoolTime";
    }*/

    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    public void readP()
    {
        //writeC(0xc7);
        int s = readD();//writeD(_reuseTimeStamps.size()); // list size
        //for (TimeStamp ts : _reuseTimeStamps)
        for (int i = 0; i < s; i++) 
        {
            int skill = readD();//writeD(ts.getSkill());
            readD();//writeD(0x00);
            int reuse = readD();//writeD((int) ts.getReuse() / 1000);
            int remaining = readD();//writeD((int) ts.getRemaining() / 1000);
        }
    }
    
}
