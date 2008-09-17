/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers;

import java.util.List;
import javolution.util.FastList;
import l2bot.pj.ClassId;
import l2bot.pj.handlers.utils.Effect;

/**
 *
 * @author carl
 */
public class PartyHandler extends AbstractHandler {
    
    public enum PartyDist{
        LOOTER(0),
        RANDOM(1),
        RANDOM_SPOIL(2),
        ORDER(3),
        ORDER_SPOIL(4);
        public int tipo;
        PartyDist(int ty){
            tipo = ty;
        }
    }
    public PartyDist partyDist;
    
    public boolean isInParty;
    public boolean isAskPartyDialogOpen;
    
    public List<PartyMember> partyMembers = new FastList<PartyMember>();
    
    public int leaderObjId;
    
    public void openAskEnterPartyDialog(String player, int dist){
        if(!isInParty){
            isAskPartyDialogOpen = true;
        }
    }
    
    
    public class PartyMember{
        public boolean isLeader;
        public boolean havePet;
        
        public int objectId;
        public String name;
        public int cp;
        public int maxCp;
        public int hp;
        public int maxHp;
        public int mp;
        public int maxMp;
        public int lvl;
        public ClassId classid;
        
        public int x,y,z;
        
        public int summonObjectId;
        public int summonTemplate;
        public int summonType;
        
        public String summonName;
        public int summonHp;
        public int summonMaxHp;
        public int summonMp;
        public int summonMaxMp;
        public int summonlvl;
        
        public List<Effect> effects= new FastList<Effect>();
        public List<Effect> petEffects= new FastList<Effect>();
 
    }
    
    public void addPartyMember(int objectId,String name,int cp,int maxCp,int hp,int maxHp,int mp,int maxMp,int lvl,int classid){
        PartyMember pm = new PartyMember();
        pm.isLeader = leaderObjId == objectId;
        pm.objectId = objectId;
        pm.name = name;
        pm.cp = cp;
        pm.maxCp = maxCp;
        pm.hp = hp;
        pm.maxHp = maxHp;
        pm.mp = mp;
        pm.maxMp = maxMp;
        pm.lvl = lvl;
        pm.classid = ClassId.values()[classid];
    }
    
    public void disolver(){
        partyMembers.clear();
        isInParty = false;
    }
    
    public void seVa(int objId, String name){
         int i = getIndexByObjId(objId);
         if(i >= 0){partyMembers.remove(i);}
         if(partyMembers.size() == 0){disolver();}
    }
    public void actualizar(int objectId,String name,int cp,int maxCp,int hp,int maxHp,int mp,int maxMp,int lvl,int classid){
        PartyMember pm = getPMByObjId(objectId);
        if(pm == null){return;}
        pm.name = name;
        pm.cp = cp;
        pm.maxCp = maxCp;
        pm.hp = hp;
        pm.maxHp = maxHp;
        pm.mp = mp;
        pm.maxMp = maxMp;
        pm.lvl = lvl;
        pm.classid = ClassId.values()[classid];                 
    }
    
    public PartyMember getPMByObjId(int objId){
        for(int i=0;i<partyMembers.size();i++){
             if(partyMembers.get(i).objectId == objId){
                 return partyMembers.get(i);
             }
         }
        return null; //error
    }
    public int getIndexByObjId(int objId){
        for(int i=0;i<partyMembers.size();i++){
             if(partyMembers.get(i).objectId == objId){
                 return i;
             }
         }
        return -1; //error
    }
}
