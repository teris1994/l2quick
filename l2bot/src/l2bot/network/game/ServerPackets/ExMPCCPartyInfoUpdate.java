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

//import net.sf.l2j.gameserver.model.L2Party;

/**
 *
 * @author  chris_00
 * 
 * ch Sddd
 */
public class ExMPCCPartyInfoUpdate extends L2GameServerPacket
{

	//private static final String _S__FE_5B_EXMPCCPARTYINFOUPDATE = "[S] FE:5B ExMPCCPartyInfoUpdate";
	//private L2Party _party;
	//private int _mode;
	
	/**
	 * 
	 * @param party
	 * @param mode 0 = Remove, 1 = Add
	 */
	//public ExMPCCPartyInfoUpdate(L2Party party, int mode)
	//{
		//_party = party;
		//_mode = mode;
	//}
	
	/**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    public void readP()
    {
	    //writeC(0xfe);
	    readH();//writeH(0x5b);	    
	    String leader = readS();//writeS(_party.getLeader().getName());
	    int leaderId = readD();//writeD(_party.getPartyLeaderOID());
	    int members = readD();//writeD(_party.getMemberCount());
	    int mode = readD();//writeD(_mode); //mode 0 = Remove Party, 1 = AddParty, maybe more...
    }
    
	/**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    //@Override
    //public String getType()
    //{
	    //return _S__FE_5B_EXMPCCPARTYINFOUPDATE;
    //}
	
}
