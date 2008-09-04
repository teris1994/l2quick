/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.cosas;

import java.util.List;
import javolution.util.FastList;

/**
 *
 * @author carl
 */
public class Player extends Character{
        public boolean isNoble;
        public boolean isHero;
        public boolean isFishing;
        
        public int hairAll;
        public int head;
        public int rhand;
        public int lhand;
        public int gloves;
        public int chest;
        public int legs;
        public int feet;
        public int back;
        public int lrhand;
        public int hair;
        public int hair2;
        
        public int hairColor;
        public int haitStyle;
        public int face;
        
        public int clanId;
        public int clanCrestId;
        public int allyId;
        public int allyCrestId;
        
        public int mountType;
        public int storeType;
        
        public byte recsLeft;
        public int recsColor;
        
        public int clanCrestLargeId;
        
        public int nameColor;
        
        public boolean sexo; //true = muejer
        
        public List<Integer> cubics = new FastList<Integer>();
        
        public int rArg;
        public int lrArg;
        
        public int pvpFlag;
        public int karma;
        
        public Player(int objId){
            super(objId);
        }
}
