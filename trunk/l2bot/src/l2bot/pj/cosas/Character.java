
package l2bot.pj.cosas;

/**
 *
 * @author carl
 */



import l2bot.pj.*;
import java.util.List;
import javolution.util.FastList;


public class Character extends Cosa
{

	public List<Character> attackersList = new FastList<Character>();

        
	public boolean isAfraid                               = false; // Flee in a random direction
	public boolean isConfused                             = false; // Attack anyone randomly
	public boolean isFakeDeath                            = false; // Fake death
	public boolean isFlying                               = false; //Is flying Wyvern?
	public boolean isMuted                                = false; // Cannot use magic
	public boolean isPhysicalMuted                        = false; // Cannot use physical skills
	public boolean isPhysicalAttackMuted                  = false; // Cannot use attack
	public boolean isDead                                 = false;
	public boolean isImmobilized                          = false;
	public boolean isOverloaded                           = false; // the char is carrying too much
	public boolean isParalyzed                            = false;
        public boolean isDisarmed                             = false;
	public boolean isRidingFenrirWolf                     = false;
	public boolean isRidingWFenrirWolf                    = false;
	public boolean isRidingGreatSnowWolf                  = false;
	public boolean isRidingStrider                        = false;
	public boolean isPendingRevive                        = false;
	public boolean isRooted                               = false; // Cannot move until root timed out
	public boolean isRunning                              = false;
	public boolean isImmobileUntilAttacked                = false; // Is in immobile until attacked.
	public boolean isSleeping                             = false; // Cannot move/attack until sleep timed out or monster is attacked
	public boolean isStunned                              = false; // Cannot move/attack until stun timed out
	public boolean isBetrayed                             = false; // Betrayed by own summon
        public boolean isSit                                  = false;
        public boolean isAttacked;
	public String _title;	

        public Race raza;
        public ClassId clase;
        
        public int mAtkSpeed;
        public int pAtkSpeed;
        
        public int runSpeed;
        public int walkSpeed;
        public int swimRunSpeed;
        public int swimWalkSpeed;
        public int flyRunSpeed;
        public int flyWalkSpeed;
        public double movementSpeedMultiplier;
        public double attackSpeedMultiplier;
        
        public double radioColision;
        public double alturaColision;
      

        
        public int abnormalEffect;
        
        public byte circle;

	public Character(int objectId)
	{
		super(objectId);
	}
}
