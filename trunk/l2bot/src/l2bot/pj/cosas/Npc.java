/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.cosas;

/**
 *
 * @author carl
 */
public class Npc extends Character{
    public int idTemplate;
    public boolean isAttackable;
    
    public int rhand;
    public int lhand;
   
    public boolean isSummoned;
    
    public Npc(int objid){super(objid);}
}
