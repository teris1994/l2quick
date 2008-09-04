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

import java.util.logging.Level;
import java.util.logging.Logger;


//import javolution.util.FastList;
import l2bot.network.game.ClientPackets.EnterWorld;

/**
 * Format : (h) d [dS]
 * h  sub id
 *
 * d: number of manors
 * [
 * d: id
 * S: manor name
 * ]
 * @author l3x
 *
 */
public class ExSendManorList extends L2GameServerPacket
{
	//private static final String _S__FE_1B_EXSENDMANORLIST = "[S] FE:22 ExSendManorList";

	//private List<String> _manors;

	//public ExSendManorList(FastList<String> manors)
	//{
		//_manors = manors;
	//}

	@Override
	public void readP()
	{
        try {
            //writeC(0xFE);
            //writeH(0x22);
            //writeD(_manors.size());
            //int i = 1;
            //{
            //{
            //writeD(i++);
            //writeS(manor);
            //}
            //}
            //@Override
            //public String getType()
            //{
            ////return _S__FE_1B_EXSENDMANORLIST;
            ///// Ahora esperar el enter world timeout
            getPj().inter.l.logInfo("Enter World in progress");
            Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        
        getPj().gameSocket.sendPacketToGame((new EnterWorld()).getBytes());
        getPj().inter.l.logInfo("Enter World");
	}
}