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
package l2bot.network.puppet.GameServerPackets;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.List;
//import java.util.logging.Logger;

//import javolution.util.FastList;
//import net.sf.l2j.L2DatabaseFactory;
//import net.sf.l2j.gameserver.datatables.ClanTable;
//import net.sf.l2j.gameserver.instancemanager.CursedWeaponsManager;
//import net.sf.l2j.gameserver.model.CharSelectInfoPackage;
//import net.sf.l2j.gameserver.model.Inventory;
//import net.sf.l2j.gameserver.model.L2Clan;
//import net.sf.l2j.gameserver.network.L2GameClient;

/**
 * This class ...
 *
 * @version $Revision: 1.8.2.4.2.6 $ $Date: 2005/04/06 16:13:46 $
 */
public class CharSelectionInfo extends l2bot.network.puppet.serverpackets.ServerBasePacket
{
    // d SdSddddddddddffddddddddddddddddddddddddddddddddddddddddddddddffd
    //private static final String _S__1F_CHARSELECTINFO = "[S] 09 CharSelectInfo";
    //private static Logger _log = Logger.getLogger(CharSelectionInfo.class.getName());
    //private String _loginName; 
    //private int _sessionId, _activeId;
    //private CharSelectInfoPackage[] _characterPackages;
    
    
    /**
     * @param _characters
     */
    //public CharSelectionInfo(String loginName, int sessionId)
    //{
        //_sessionId = sessionId;
        //_loginName = loginName;
        //_characterPackages = loadCharacterSelectInfo();
        //_activeId = -1;
    //}
    
    //public CharSelectionInfo(String loginName, int sessionId, int activeId)
    //{
        //_sessionId = sessionId;
        //_loginName = loginName;
        //_characterPackages = loadCharacterSelectInfo();
        //_activeId = activeId;
    //}
    
    //public CharSelectInfoPackage[] getCharInfo()
    //{
        //return _characterPackages;
    //}
    
    @Override
    public void write()
    {
        /*byte[] test = new byte[]{(byte)0x09,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x07,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x54,(byte)0x00,(byte)0x6F,(byte)0x00,(byte)0x6D,(byte)0x00,(byte)0x54,(byte)0x00,(byte)0x61,(byte)0x00,(byte)0x6B,(byte)0x00,(byte)0x65,(byte)0x00,(byte)0x72,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x7A,(byte)0x0B,(byte)0x03,(byte)0x00,(byte)0x64,(byte)0x00,(byte)0x61,(byte)0x00,(byte)0x6E,(byte)0x00,(byte)0x63,(byte)0x00,(byte)0x65,(byte)0x00,(byte)0x72,(byte)0x00,(byte)0x32,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x78,(byte)0x56,(byte)0x34,(byte)0x12,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
                                 (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x5F,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xEC,(byte)0x97,(byte)0x40,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x40,(byte)0x7E,(byte)0x40,(byte)0xC8,(byte)0x26,(byte)0x02,(byte)0x00,(byte)0x23,(byte)0x16,(byte)0x0D,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
                                 (byte)0x29,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
                                 (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x1E,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x3E,(byte)0x05,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x90,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0xA4,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x84,(byte)0x09,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x1E,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
                                 (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xEC,(byte)0x97,(byte)0x40,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x40,(byte)0x7E,(byte)0x40,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x09,
                                 (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
        writeB(test);
        if(true){
            return;
        }*/
        
        writeC(0x09);
        //int size = (_characterPackages.length);
        int size = 1;
        writeD(size);
        
        // Can prevent players from creating new characters (if 0); (if 1, the client will ask if chars may be created (0x13) Response: (0x0D) )
        writeD(0x07);
        writeC(0x00);
        
        //long lastAccess = 0L;
        
        //if (_activeId == -1)
        //{
            //for (int i = 0; i < size; i++)
            //{
                //if (lastAccess < _characterPackages[i].getLastAccess())
                //{
                    //lastAccess = _characterPackages[i].getLastAccess();
                    //_activeId = i;
                //}
            //}
        //}
        
        for (int i = 0; i < size; i++)
        {
            //CharSelectInfoPackage charInfoPackage = _characterPackages[i];
            
            writeS("TomTaker");  //nombre
            writeD(199546);   //id
            writeS("dancer2"); //loginName
            writeD(0x12345678); //sessionid
            writeD(0);    ///clan
            writeD(0x00); // ??
            
            writeD(0); //sexo
            writeD(0);   //raza
            
            /*if (charInfoPackage.getClassId() == charInfoPackage.getBaseClassId())
                writeD(charInfoPackage.getClassId());
            else
                writeD(charInfoPackage.getBaseClassId());
            */
            writeD(0x5F);
            
            writeD(0x01); // active ??
            
            writeD(0x00); // x
            writeD(0x00); // y
            writeD(0x00); // z
            
            writeF(500); // hp cur
            writeF(500); // mp cur
            
            writeD(141000);   //sp
            writeQ(17634851);   //exp
            writeD(41);     //lvl
            
            writeD(0); // karma
            writeD(1); //pkkils
            
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIRALL));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_REAR));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LEAR));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_NECK));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RFINGER));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LFINGER));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HEAD));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RHAND));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LHAND));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_GLOVES));
            writeD(400);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_CHEST));
            writeD(420);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LEGS));
            writeD(2436);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_FEET));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_BACK));
            writeD(286);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LRHAND));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIR));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIR2));
            
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RBRACELET));
            writeD(0);//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LBRACELET));
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(0x00);
            writeD(2);//writeD(charInfoPackage.getHairStyle());
            writeD(3);//writeD(charInfoPackage.getHairColor());
            writeD(2);//writeD(charInfoPackage.getFace());
            
            writeF(500); // hp max
            writeF(500); // mp max
            
            //long deleteTime = charInfoPackage.getDeleteTimer();
            //int deletedays = 0;
            //if (deleteTime > 0)
                //deletedays = (int)((deleteTime-System.currentTimeMillis())/1000);
            writeD(0); // days left before
            // delete .. if != 0
            // then char is inactive
            writeD(0x09);  //classid
            /*if (i == _activeId)
                writeD(0x01);
            else
                writeD(0x00); //c3 auto-select char*/
            writeD(1);
            
            writeC(0);//writeC(charInfoPackage.getEnchantEffect() > 127 ? 127 : charInfoPackage.getEnchantEffect());
            
            writeH(0);//writeH(charInfoPackage.getAugmentationId());
            writeH(0x00); // this is for augmentation too
            
            //////////////writeD(charInfoPackage.getTransformId()); // Used to display Transformations
            writeD(0x00); // Currently on retail when you are on character select you don't see your transformation.
        }
    }
    
    //private CharSelectInfoPackage[] loadCharacterSelectInfo()
    //{
        //CharSelectInfoPackage charInfopackage;
        //List<CharSelectInfoPackage> characterList = new FastList<CharSelectInfoPackage>();
//        
        //java.sql.Connection con = null;
//        
        //try
        //{
            //con = L2DatabaseFactory.getInstance().getConnection();
            //PreparedStatement statement = con.prepareStatement("SELECT account_name, charId, char_name, level, maxHp, curHp, maxMp, curMp, face, hairStyle, hairColor, sex, heading, x, y, z, exp, sp, karma, pvpkills, pkkills, clanid, race, classid, deletetime, cancraft, title, rec_have, rec_left, accesslevel, online, char_slot, lastAccess, base_class, transform_id FROM characters WHERE account_name=?");
            //statement.setString(1, _loginName);
            //ResultSet charList = statement.executeQuery();
//            
            //while (charList.next())// fills the package
            //{
                //charInfopackage = restoreChar(charList);
                //if ( charInfopackage != null )
                    //characterList.add(charInfopackage);
            //}
//            
            //charList.close();
            //statement.close();
//            
            //return characterList.toArray(new CharSelectInfoPackage[characterList.size()]);
        //}
        //catch (Exception e)
        //{
            //_log.warning("Could not restore char info: " + e);
        //}
        //finally
        //{
            //try { con.close(); } catch (Exception e) {}
        //}
//        
        //return new CharSelectInfoPackage[0];
    //}
//    
    //private void loadCharacterSubclassInfo(CharSelectInfoPackage charInfopackage, int ObjectId, int activeClassId)
    //{
        //java.sql.Connection con = null;
//        
        //try
        //{
            //con = L2DatabaseFactory.getInstance().getConnection();
            //PreparedStatement statement = con.prepareStatement("SELECT exp, sp, level FROM character_subclasses WHERE charId=? && class_id=? ORDER BY charId");
            //statement.setInt(1, ObjectId);
            //statement.setInt(2, activeClassId);
            //ResultSet charList = statement.executeQuery();
//            
            //if (charList.next())
            //{
                //charInfopackage.setExp(charList.getLong("exp"));
                //charInfopackage.setSp(charList.getInt("sp"));
                //charInfopackage.setLevel(charList.getInt("level"));
            //}
//            
            //charList.close();
            //statement.close();
//            
        //}
        //catch (Exception e)
        //{
            //_log.warning("Could not restore char subclass info: " + e);
        //}
        //finally
        //{
            //try { con.close(); } catch (Exception e) {}
        //}
//        
    //}
//    
//    
    //private CharSelectInfoPackage restoreChar(ResultSet chardata) throws Exception
    //{
        //int objectId = chardata.getInt("charId");
        //String name = chardata.getString("char_name");
//
        //// See if the char must be deleted
        //long deletetime = chardata.getLong("deletetime");
        //if (deletetime > 0)
        //{
            //if (System.currentTimeMillis() > deletetime)
            //{
                //L2Clan clan = ClanTable.getInstance().getClan(chardata.getInt("clanid"));
                //if(clan != null)
                    //clan.removeClanMember(objectId, 0);
//                
                //L2GameClient.deleteCharByObjId(objectId);
                //return null;
            //}
        //}
//        
        //CharSelectInfoPackage charInfopackage = new CharSelectInfoPackage(objectId, name);
        //charInfopackage.setLevel(chardata.getInt("level"));
        //charInfopackage.setMaxHp(chardata.getInt("maxhp"));
        //charInfopackage.setCurrentHp(chardata.getDouble("curhp"));
        //charInfopackage.setMaxMp(chardata.getInt("maxmp"));
        //charInfopackage.setCurrentMp(chardata.getDouble("curmp"));
        //charInfopackage.setKarma(chardata.getInt("karma"));
        //charInfopackage.setPkKills(chardata.getInt("pkkills"));
        //charInfopackage.setFace(chardata.getInt("face"));
        //charInfopackage.setHairStyle(chardata.getInt("hairstyle"));
        //charInfopackage.setHairColor(chardata.getInt("haircolor"));
        //charInfopackage.setSex(chardata.getInt("sex"));
//        
        //charInfopackage.setExp(chardata.getLong("exp"));
        //charInfopackage.setSp(chardata.getInt("sp"));
        //charInfopackage.setClanId(chardata.getInt("clanid"));
//        
        //charInfopackage.setRace(chardata.getInt("race"));
//        
        //final int baseClassId = chardata.getInt("base_class");
        //final int activeClassId = chardata.getInt("classid");
//        
        //// if is in subclass, load subclass exp, sp, lvl info
        //if(baseClassId != activeClassId)
            //loadCharacterSubclassInfo(charInfopackage, objectId, activeClassId);
//        
        //charInfopackage.setClassId(activeClassId);
//        
        //// Get the augmentation id for equipped weapon
        //int weaponObjId = charInfopackage.getPaperdollObjectId(Inventory.PAPERDOLL_LRHAND);
        //if (weaponObjId < 1)
            //weaponObjId = charInfopackage.getPaperdollObjectId(Inventory.PAPERDOLL_RHAND);
//        
        //// Check Transformation
        //int cursedWeaponId = CursedWeaponsManager.getInstance().checkOwnsWeaponId(objectId);
        //if (cursedWeaponId > 0)
        //{
            //// cursed weapon transformations
            //if(cursedWeaponId == 8190)
                //charInfopackage.setTransformId(301);
            //else if(cursedWeaponId == 8689)
                //charInfopackage.setTransformId(302);
            //else
                //charInfopackage.setTransformId(0);
        //}
        //else if (chardata.getInt("transform_id") > 0)
        //{
            //charInfopackage.setTransformId(chardata.getInt("transform_id"));
        //}
        //else
            //charInfopackage.setTransformId(0);
//        
        //if (weaponObjId > 0)
        //{
            //java.sql.Connection con = null;
            //try
            //{
                //con = L2DatabaseFactory.getInstance().getConnection();
                //PreparedStatement statement = con.prepareStatement("SELECT attributes FROM augmentations WHERE item_id=?");
                //statement.setInt(1, weaponObjId);
                //ResultSet result = statement.executeQuery();
//                
                //if (result.next())
                //{
                    //charInfopackage.setAugmentationId(result.getInt("attributes"));
                //}
//                
                //result.close();
                //statement.close();
            //}
            //catch (Exception e)
            //{
                //_log.warning("Could not restore augmentation info: " + e);
            //}
            //finally { try { con.close(); } catch (Exception e) {} }
        //}
        
        /*
         * Check if the base class is set to zero and alse doesn't match
         * with the current active class, otherwise send the base class ID.
         *
         * This prevents chars created before base class was introduced
         * from being displayed incorrectly.
         */
        //if (baseClassId == 0 && activeClassId > 0)
            //charInfopackage.setBaseClassId(activeClassId);
        //else
            //charInfopackage.setBaseClassId(baseClassId);
//        
        //charInfopackage.setDeleteTimer(deletetime);
        //charInfopackage.setLastAccess(chardata.getLong("lastAccess"));
        //return charInfopackage;
    //}
//    
    //@Override
    //public String getType()
    //{
        //return _S__1F_CHARSELECTINFO;
    //}
}
