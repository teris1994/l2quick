/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers;

import l2bot.pj.ClassId;
import l2bot.pj.Race;


import java.util.List;
import javolution.util.FastList;
import l2bot.Main;
import l2bot.interfaz.dialogs.CharSelectDialog;
import l2bot.network.game.ClientPackets.CharacterSelect;
import l2bot.pj.Pj;
        
/**
 *
 * @author carl
 */
public class CharSelectHandler {
    public boolean isSelectCharDialogOpen;
    Pj pj;
    
    public CharSelectHandler(Pj pj){
    this.pj = pj;
    }
    
    
    public class Char{
        public String nombre;
        public String LoginName;
        
        public int id;
        public int sessionId;
        
        public int clanId;
        public int sexo;
        public Race raza;
        public ClassId clase;
        public int sp;
        public long exp;
        public int lvl;
        public int karma;
        public int pkkils;
        
        public int hairAll,lEar,rEar,neck,rFinger,lFinger,head,lHand,rHand,gloves,chest,legs,feet,back,lrHand,hair,hair2,lBraz,rBraz;
        public int hairColor,hairStyle,face;
        
        
        public double hp, maxHp;
        public double mp, maxMp;
        
        public int deleteDays;
        
        public int weaponEnchantment;
        
        public int argumentationId;
        
        @Override
        public String toString(){
            String 
            r = "--------PJ INFO------------\n";
            r +="---       Nombre:" + nombre + "\n";
            r +="---    LoginName:" + LoginName + "\n";
            r +="---           id:" + id + "\n";
            r +="---    sessionId:" + sessionId + "\n";
            r +="---       clanId:" + clanId + "\n";
            r +="---         sexo:" + (sexo == 0?"Hombre":"Mujer") + "\n";
            r +="---         raza:" + raza.name() + "\n";
            r +="---        clase:" + clase.name() + "\n";
            r +="---           sp:" + sp + "\n";
            r +="---          exp:" + exp + "\n";
            r +="---          lvl:" + lvl + "\n";
            r +="---        karma:" + karma + "\n";
            r +="---     pk kills:" + pkkils + "\n";
            r +="---         pelo:" + hairAll + "\n";
            r +="---    Oreja izq:" + lEar + "\n";
            r +="---    Oreja der:" + rEar + "\n";
            r +="---       cuello:" + neck + "\n";
            r +="---     dedo izq:" + lFinger + "\n";
            r +="---     dedo der:" + rFinger + "\n";
            r +="---      guantes:" + gloves + "\n";
            r +="---      pechera:" + chest + "\n";
            r +="---      piernas:" + legs + "\n";
            r +="---         pies:" + feet + "\n";
            r +="---      espalda:" + back + "\n";
            r +="---        manos:" + lrHand + "\n";
            r +="---         pelo:" + hair + "\n";
            r +="---        pelo2:" + hair2 + "\n";
            r +="---    braz. izq:" + lBraz + "\n";
            r +="---    braz. der:" + rBraz + "\n";
            r +="---   color pelo:" + hairColor + "\n";
            r +="---  estilo pelo:" + hairStyle + "\n";
            r +="---         cara:" + face + "\n";
            r +="---   dias elim.:" + deleteDays + "\n";
            r +="---  encan. arma:" + weaponEnchantment + "\n";
            r +="---  argum. arma:" + argumentationId  + "\n";
            return r;
        }
        
    }
    
    public List<Char> chars = new FastList<Char>();
    public Char addChar(){
        Char c = new Char();
        chars.add(c);
        return c;
    }
    
    public void showDialog(){
        CharSelectDialog csd = new CharSelectDialog(Main.g,this){
            @Override
            public void onAceptar(byte cha){
                //System.out.println("Char Selected");
                pj.gameSocket.sendPacketToGame((new CharacterSelect(cha)).getBytes());
            }
        };
        csd.setVisible(true);
    }
    
    
    

    
}
