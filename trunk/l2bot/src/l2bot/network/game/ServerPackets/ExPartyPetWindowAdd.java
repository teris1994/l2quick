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

import l2bot.pj.handlers.PartyHandler.PartyMember;


/**
 *
 * @author  KenM
 */
public final class ExPartyPetWindowAdd extends L2GameServerPacket
{
    //private final L2Summon _summon;
    
    //public ExPartyPetWindowAdd(L2Summon summon)
    //{
        //_summon = summon;
    //}
    
    
    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#getType()
     */
    //@Override
    //public String getType()
    //{
        //return "[S] FE:18 ExPartyPetWindowAdd";
    //}

    /**
     * @see net.sf.l2j.gameserver.network.serverpackets.L2GameServerPacket#writeImpl()
     */
    //@Override
    public void readP()
    {
        //writeC(0xfe);
        
        
        readH();//writeH(0x18);
        int sumObjId = readD();//writeD(_summon.getObjectId());
        int idTmp = readD();//writeD(_summon.getTemplate().idTemplate + 1000000);
        int type = readD();//writeD(_summon.getSummonType());
        int objId = readD();//writeD(_summon.getOwner().getObjectId());
        String name = readS();//writeS(_summon.getName());
        int hp = readD();//writeD((int) _summon.getCurrentHp());
        int maxHp = readD();//writeD(_summon.getMaxHp());
        int mp = readD();//writeD((int) _summon.getCurrentMp());
        int maxMp = readD();//writeD(_summon.getMaxMp());
        int lvl =readD();//writeD(_summon.getLevel());
        
        PartyMember pm = getPj().partyHandler.getPMByObjId(objId);
        if(pm == null){return;}
        pm.summonObjectId = sumObjId;
        pm.summonTemplate = idTmp;
        pm.summonType = type;
        pm.summonName = name;
        pm.summonHp = hp;
        pm.summonMaxHp = maxHp;
        pm.summonMp = mp;
        pm.summonMaxMp = maxMp;
        pm.summonlvl = lvl;
        pm.havePet = true;
    }
    
}
