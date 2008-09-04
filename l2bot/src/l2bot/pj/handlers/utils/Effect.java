/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers.utils;

/**
 *
 * @author carl
 */
public class Effect
{
        public int skillId;
        public int level;
        public int duration;

        public Effect(int pSkillId, int pLevel, int pDuration)
        {
                skillId = pSkillId;
                level = pLevel;
                duration = pDuration;
        }
}