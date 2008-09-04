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



//import java.util.logging.Logger;
import l2bot.pj.ClassId;
import l2bot.pj.cosas.ObjectPosition;

//import net.sf.l2j.Config;
import l2bot.pj.Race;
//import net.sf.l2j.gameserver.datatables.NpcTable;
import l2bot.pj.cosas.Player;
//import net.sf.l2j.gameserver.instancemanager.CursedWeaponsManager;
//import net.sf.l2j.gameserver.model.Inventory;
//import net.sf.l2j.gameserver.model.L2Character;
//import net.sf.l2j.gameserver.model.L2Summon;
//import net.sf.l2j.gameserver.model.L2Transformation;
//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
//import net.sf.l2j.gameserver.templates.L2NpcTemplate;

/**
 * 0000: 03 32 15 00 00 44 fe 00 00 80 f1 ff ff 00 00 00    .2...D..........<p>
 * 0010: 00 6b b4 c0 4a 45 00 6c 00 6c 00 61 00 6d 00 69    .k..JE.l.l.a.m.i<p>
 * 0020: 00 00 00 01 00 00 00 01 00 00 00 12 00 00 00 00    ................<p>
 * 0030: 00 00 00 2a 00 00 00 42 00 00 00 71 02 00 00 31    ...*...B...q...1<p>
 * 0040: 00 00 00 18 00 00 00 1f 00 00 00 25 00 00 00 00    ...........%....<p>
 * 0050: 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 f9    ................<p>
 * 0060: 00 00 00 b3 01 00 00 00 00 00 00 00 00 00 00 7d    ...............}<p>
 * 0070: 00 00 00 5a 00 00 00 32 00 00 00 32 00 00 00 00    ...Z...2...2....<p>
 * 0080: 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 67    ...............g<p>
 * 0090: 66 66 66 66 66 f2 3f 5f 63 97 a8 de 1a f9 3f 00    fffff.?_c.....?.<p>
 * 00a0: 00 00 00 00 00 1e 40 00 00 00 00 00 00 37 40 01    .............7..<p>
 * 00b0: 00 00 00 01 00 00 00 01 00 00 00 00 00 c1 0c 00    ................<p>
 * 00c0: 00 00 00 00 00 00 00 00 00 01 01 00 00 00 00 00    ................<p>
 * 00d0: 00 00<p>
 * <p>
 *  dddddSdddddddddddddddddddddddddddffffdddSdddccccccc (h)<p>
 *  dddddSdddddddddddddddddddddddddddffffdddSdddddccccccch
 *  dddddSddddddddddddddddddddddddddddffffdddSdddddccccccch (h) c (dchd) ddc dcc c cddd d
 *  dddddSdddddddddddddddhhhhhhhhhhhhhhhhhhhhhhhhddddddddddddddffffdddSdddddccccccch [h] c (ddhd) ddc c ddc cddd d d dd d d d

 * @version $Revision: 1.7.2.6.2.11 $ $Date: 2005/04/11 10:05:54 $
 */
public class CharInfo extends L2GameServerPacket
{
	//private static final Logger _log = Logger.getLogger(CharInfo.class.getName());

	//private static final String _S__03_CHARINFO = "[S] 31 CharInfo";
	//private L2PcInstance _activeChar;
	//private Inventory _inv;
	//private int _x, _y, _z, _heading;
	//private int _mAtkSpd, _pAtkSpd;
	//private int _runSpd, _walkSpd, _swimRunSpd, _swimWalkSpd, _flRunSpd, _flWalkSpd, _flyRunSpd, _flyWalkSpd;
    //private float _moveMultiplier, _attackSpeedMultiplier;

	/**
	 * @param _characters
	 */
    //public CharInfo(L2PcInstance cha)
    //{
    	//_activeChar = cha;
    	//_inv = cha.getInventory();
    	//_x = _activeChar.getX();
    	//_y = _activeChar.getY();
    	//_z = _activeChar.getZ();
    	//_heading = _activeChar.getHeading();
    	//_mAtkSpd = _activeChar.getMAtkSpd();
    	//_pAtkSpd = _activeChar.getPAtkSpd();
    	//_moveMultiplier  = _activeChar.getMovementSpeedMultiplier();
    	//_attackSpeedMultiplier = _activeChar.getAttackSpeedMultiplier();
    	//_runSpd         = (int)(_activeChar.getRunSpeed()/_moveMultiplier);
    	//_walkSpd        = (int)(_activeChar.getWalkSpeed()/_moveMultiplier);    
        //_swimRunSpd = _flRunSpd = _flyRunSpd = _runSpd;
        //_swimWalkSpd = _flWalkSpd = _flyWalkSpd = _walkSpd;
    //}

	@Override
	public void readP()
	{
                
		//boolean gmSeeInvis = false;

		//if (_activeChar.getAppearance().getInvisible())
		//{
			//L2PcInstance tmp = getClient().getActiveChar();
			//if (tmp != null && tmp.isGM())
				//gmSeeInvis = true;
			//else
				//return;
		//}

		//if (_activeChar.getPoly().isMorphed())
		//{
			//L2NpcTemplate template = NpcTable.getInstance().getTemplate(_activeChar.getPoly().getPolyId());

			//if (template != null)
			//{
				//writeC(0x0c);
				//writeD(_activeChar.getObjectId());
				//writeD(_activeChar.getPoly().getPolyId()+1000000);  // npctype id
				//writeD(_activeChar.getKarma() > 0 ? 1 : 0);
				//writeD(_x);
				//writeD(_y);
				//writeD(_z);
				//writeD(_heading);
				//writeD(0x00);
				//writeD(_mAtkSpd);
				//writeD(_pAtkSpd);
				//writeD(_runSpd); // TODO: the order of the speeds should be confirmed
				//writeD(_walkSpd);
				//writeD(_swimRunSpd); // swim speed
	                        //writeD(_swimWalkSpd); // swim speed
				//writeD(_flRunSpd);
				//writeD(_flWalkSpd);
				//writeD(_flyRunSpd);
				//writeD(_flyWalkSpd);
				//writeF(_moveMultiplier);
				//writeF(_attackSpeedMultiplier);
				//writeF(template.collisionRadius);
				//writeF(template.collisionHeight);
				//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_RHAND)); // right hand weapon
				//writeD(0);
				//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_LHAND)); // left hand weapon
				//writeC(1);	// name above char 1=true ... ??
				//writeC(_activeChar.isRunning() ? 1 : 0);
				//writeC(_activeChar.isInCombat() ? 1 : 0);
				//writeC(_activeChar.isAlikeDead() ? 1 : 0);

				//if (gmSeeInvis)
				//{
					//writeC(0);
				//}
				//else
				//{
					//writeC(_activeChar.getAppearance().getInvisible()? 1 : 0); // invisible ?? 0=false  1=true   2=summoned (only works if model has a summon animation)
				//}

				//writeS(_activeChar.getAppearance().getVisibleName());

				//if (gmSeeInvis)
				//{
					//writeS("Invisible");
				//}
				//else
				//{
					//writeS(_activeChar.getAppearance().getVisibleTitle());
				//}

				//writeD(0);
				//writeD(0);
				//writeD(0000);  // hmm karma ??

				//if (gmSeeInvis)
				//{
					//writeD( (_activeChar.getAbnormalEffect() | L2Character.ABNORMAL_EFFECT_STEALTH) );
				//}
				//else
				//{
					//writeD(_activeChar.getAbnormalEffect());  // C2
				//}

				//writeD(0);  // C2
				//writeD(0);  // C2
				//writeD(0);  // C2
				//writeD(0);  // C2
				//writeC(0);  // C2
                //writeC(0x00);  // C3  team circle 1-blue, 2-red
                //writeF(template.collisionRadius);
                //writeF(template.collisionHeight);
                //writeD(0x00);  // C4
                //writeD(0x00);  // C6
                //writeD(0x00);
                //writeD(0x00);
			//}
            //else
			//{
				//_log.warning("Character "+_activeChar.getName()+" ("+_activeChar.getObjectId()+") morphed in a Npc ("+_activeChar.getPoly().getPolyId()+") w/o template.");
			//}
		//}
		//else
		//{
			//writeC(0x31);
			int x = readD();//writeD(_x);
			int y = readD();//writeD(_y);
			int z = readD();//writeD(_z);
			readD();//writeD(0x00);
			Player chr = new Player(readD());//writeD(_activeChar.getObjectId());
                        chr.setPosition(new ObjectPosition(x,y,z));
                        
			chr.setName(readS());//writeS(_activeChar.getAppearance().getVisibleName());
			chr.raza = Race.values()[readD()];//writeD(_activeChar.getRace().ordinal());
			chr.sexo = readD() == 1;//writeD(_activeChar.getAppearance().getSex()? 1 : 0);
			//if (_activeChar.getClassIndex() == 0)
			chr.clase = ClassId.values()[readD()];	//writeD(_activeChar.getClassId().getId());
			//else
				//writeD(_activeChar.getBaseClass());

			chr.hairAll = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HAIRALL));
			chr.head = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HEAD));
			chr.rhand = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_RHAND));
			chr.lhand = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_LHAND));
			chr.gloves = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_GLOVES));
			chr.chest = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_CHEST));
			chr.legs = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_LEGS));
			chr.feet = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_FEET));
			chr.back = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_BACK));
			chr.lrhand = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_LRHAND));
			chr.hair = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HAIR));
			chr.hair2 = readD();//writeD(_inv.getPaperdollItemId(Inventory.PAPERDOLL_HAIR2));
			//// T1 new d's
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			readD();//writeD(0x00);
			//// end of t1 new d's
			
			//// c6 new h's
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			chr.rArg =readD();//writeD(_inv.getPaperdollAugmentationId(Inventory.PAPERDOLL_RHAND));
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			chr.lrhand = readD();//writeD(_inv.getPaperdollAugmentationId(Inventory.PAPERDOLL_LRHAND));
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			//// T1 new h's
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			readH();//writeH(0x00);
			//// end of t1 new h's
			
			chr.pvpFlag = readD();//writeD(_activeChar.getPvpFlag());
			chr.karma = readD();//writeD(_activeChar.getKarma());
	
			chr.mAtkSpeed = readD();//writeD(_mAtkSpd);
			chr.pAtkSpeed = readD();//writeD(_pAtkSpd);
			
			readD();//writeD(_activeChar.getPvpFlag());
			readD();//writeD(_activeChar.getKarma());
	
			chr.runSpeed = readD();//writeD(_runSpd); // TODO: the order of the speeds should be confirmed
			chr.walkSpeed = readD();//writeD(_walkSpd);
                        chr.swimRunSpeed = readD();//writeD(_swimRunSpd); // swim speed
                        chr.swimWalkSpeed = readD();//writeD(_swimWalkSpd); // swim speed
			chr.flyRunSpeed = readD();//writeD(_flRunSpd);
			chr.flyWalkSpeed = readD();//writeD(_flWalkSpd);
			readD();//writeD(_flyRunSpd);
			readD();//writeD(_flyWalkSpd);
			chr.movementSpeedMultiplier = readF();//writeF(_activeChar.getMovementSpeedMultiplier()); // _activeChar.getProperMultiplier()
			chr.attackSpeedMultiplier = readF();//writeF(_activeChar.getAttackSpeedMultiplier()); // _activeChar.getAttackSpeedMultiplier()
            
            //L2Summon pet = _activeChar.getPet();
            //L2Transformation trans;
            //if (_activeChar.getMountType() != 0 && pet != null)
            //{
              chr.radioColision = readF();  //writeF(pet.getTemplate().collisionRadius);
              chr.alturaColision = readF(); //writeF(pet.getTemplate().collisionHeight);
            //}
            //else if ((trans = _activeChar.getTransformation()) != null)
            //{
                //writeF(trans.getCollisionRadius());
                //writeF(trans.getCollisionHeight());
            //}
            //else
            //{
                //writeF(_activeChar.getBaseTemplate().collisionRadius);
                //writeF(_activeChar.getBaseTemplate().collisionHeight);
            //}

			chr.haitStyle = readD();//writeD(_activeChar.getAppearance().getHairStyle());
			chr.hairColor = readD();//writeD(_activeChar.getAppearance().getHairColor());
			chr.face = readD();//writeD(_activeChar.getAppearance().getFace());

			//if (gmSeeInvis)
			//{
				//writeS("Invisible");
			//}
			//else
			//{
				chr._title = readS();//writeS(_activeChar.getAppearance().getVisibleTitle());
			//}

			chr.clanId = readD();//writeD(_activeChar.getClanId());
			chr.clanCrestId = readD();//writeD(_activeChar.getClanCrestId());
			chr.allyId = readD();//writeD(_activeChar.getAllyId());
			chr.allyCrestId = readD();//writeD(_activeChar.getAllyCrestId());
	        //// In UserInfo leader rights and siege flags, but here found nothing??
	        //// Therefore RelationChanged packet with that info is required
	        readD();//writeD(0);

			chr.isSit = readC() == 0;//writeC(_activeChar.isSitting() ? 0 : 1);	// standing = 1  sitting = 0
			chr.isRunning = readC() == 1;//writeC(_activeChar.isRunning() ? 1 : 0);	// running = 1   walking = 0
			chr.isAttacked = readC() == 1;//writeC(_activeChar.isInCombat() ? 1 : 0);
			chr.isDead = readC() == 1;//writeC(_activeChar.isAlikeDead() ? 1 : 0);

			//if (gmSeeInvis)
			//{
				//writeC(0);
			//}
			//else
			//{
				readC();//writeC(_activeChar.getAppearance().getInvisible() ? 1 : 0);	// invisible = 1  visible =0
			//}

			chr.mountType = readC();//writeC(_activeChar.getMountType());	// 1-on Strider, 2-on Wyvern, 3-on Great Wolf, 0-no mount
			chr.storeType = readC();//writeC(_activeChar.getPrivateStoreType());   //  1 - sellshop

			int sz = readH();//writeH(_activeChar.getCubics().size());
			for(int i=0;i<sz;i++){//for (int id : _activeChar.getCubics().keySet())
				chr.cubics.add(readH());//writeH(id);
                        }

 		        readC();//writeC(0x00);	// find party members

			//if (gmSeeInvis)
			//{
			chr.abnormalEffect = readD();	//writeD( (_activeChar.getAbnormalEffect() | L2Character.ABNORMAL_EFFECT_STEALTH) );
			//}
			//else
			//{
				//writeD(_activeChar.getAbnormalEffect());
			//}

			chr.recsLeft = (byte)readC();//writeC(_activeChar.getRecomLeft());                       //Changed by Thorgrim
			chr.recsColor = readH();//writeH(_activeChar.getRecomHave()); //Blue value for name (0 = white, 255 = pure blue)
			readD();//writeD(_activeChar.getMountNpcId() + 1000000);

			readD();//writeD(_activeChar.getClassId().getId());
			readD();//writeD(0x00); //?
	        readC();//writeC(_activeChar.isMounted() ? 0 : _activeChar.getEnchantEffect());

	        //if(_activeChar.getTeam()==1)
	        	//writeC(0x01); //team circle around feet 1= Blue, 2 = red
	        //else if(_activeChar.getTeam()==2)
	        	//writeC(0x02); //team circle around feet 1= Blue, 2 = red
	        //else
	        	chr.circle = (byte)readC();//writeC(0x00); //team circle around feet 1= Blue, 2 = red

			chr.clanCrestLargeId = readD();//writeD(_activeChar.getClanCrestLargeId());
			chr.isNoble = readC()==1;//writeC(_activeChar.isNoble() ? 1 : 0); // Symbol on char menu ctrl+I
			chr.isHero = readC() == 1;//writeC(_activeChar.isHero() || (_activeChar.isGM() && Config.GM_HERO_AURA) ? 1 : 0); // Hero Aura

			chr.isFishing = readC() == 1;//writeC(_activeChar.isFishing() ? 1 : 0); //0x01: Fishing Mode (Cant be undone by setting back to 0)
			readD();//writeD(_activeChar.getFishx());
			readD();//writeD(_activeChar.getFishy());
			readD();//writeD(_activeChar.getFishz());

	        chr.nameColor = readD();//writeD(_activeChar.getAppearance().getNameColor());

	        chr.getPosition().setHeading(readD());
                //writeD(_heading);

	        //writeD(_activeChar.getPledgeClass());
	        //writeD(_activeChar.getPledgeType());

	        //writeD(_activeChar.getAppearance().getTitleColor());

	        //if (_activeChar.isCursedWeaponEquipped())
	        	//writeD(CursedWeaponsManager.getInstance().getLevel(_activeChar.getCursedWeaponEquippedId()));
	        //else
	        	//writeD(0x00);

	        //if (_activeChar.getClanId() > 0)
	        	//writeD(_activeChar.getClan().getReputationScore());
	        //else
	        	//writeD(0x00); 

	        //// T1
	        //writeD(_activeChar.getTranformationId());
	        //writeD(_activeChar.getAgathionId());
	        
	        //// T2
	        //writeD(0x01);
		//}
                
                getPj().players.put(chr._objectId, chr);
                getPj().chars.put(chr._objectId, chr);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__03_CHARINFO;
	//}
}
