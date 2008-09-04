/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers;

import java.util.List;
import javolution.util.FastList;
import l2bot.pj.handlers.utils.Effect;


/**
 *
 * @author carl
 */
public class AbnormalStatusHandler {
    List<Effect> effects;
    
    public AbnormalStatusHandler(){
        effects = new FastList<Effect>();
    }
    
    public void addEffect(Effect efecto){
        effects.add(efecto);
    }
    public void addEffect(int skillId, int sklvl, int duracion){
        addEffect(new Effect(skillId,sklvl, duracion));
    }
    
    

    

}
