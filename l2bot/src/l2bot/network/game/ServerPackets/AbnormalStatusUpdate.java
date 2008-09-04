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

//import java.util.List;

//import javolution.util.FastList;

/**
 *
 * MagicEffectIcons
 * format   h (dhd)
 *
 * @version $Revision: 1.3.2.1.2.6 $ $Date: 2005/04/05 19:41:08 $
 */
public class AbnormalStatusUpdate extends L2GameServerPacket
{
	//private static final String _S__97_ABNORMALSTATUSUPDATE = "[S] 85 AbnormalStatusUpdate";
	//private List<Effect> _effects;


/*
	public AbnormalStatusUpdate()
	{
		_effects = new FastList<Effect>();
	}

	public void addEffect(int skillId, int level, int duration)
	{
		if (skillId == 2031 ||skillId == 2032 ||skillId == 2037)
			return;
		_effects.add(new Effect(skillId, level, duration));
	}
*/
	//@Override
        
	public void readP()
	{
		//writeC(0x85);

		int n = readH();//writeH(_effects.size());
                
                for(int i=0;i<n;i++){
                    getPj().abnormalStatusHandler.addEffect(readD(),readH(),readD()*1000);
                    
                }
		//for (Effect temp : _effects)
		//{
		//	writeD(temp._skillId);
		//	writeH(temp._level);

                //if (temp._duration == -1)
                //writeD(-1);
                //else
		//	    writeD(temp._duration / 1000);
		//}
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__97_ABNORMALSTATUSUPDATE;
	
}
