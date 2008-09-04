/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import l2bot.data.AbstractItem;
import l2bot.data.DataHandler;

/**
 *
 * @author carl
 */
public class InventarioEquipados extends JPanel {
    public static final int SLOT_UNDERWEAR = 0x0001;
    public static final int SLOT_R_EAR = 0x0002;
    public static final int SLOT_L_EAR = 0x0004;
    public static final int SLOT_LR_EAR = 0x00006;              //
    public static final int SLOT_NECK = 0x0008;
    public static final int SLOT_R_FINGER = 0x0010;
    public static final int SLOT_L_FINGER = 0x0020;
    public static final int SLOT_LR_FINGER = 0x0030;          //
    public static final int SLOT_HEAD = 0x0040;
    public static final int SLOT_R_HAND = 0x0080;
    public static final int SLOT_L_HAND = 0x0100;
    public static final int SLOT_GLOVES = 0x0200;
    public static final int SLOT_CHEST = 0x0400;
    public static final int SLOT_LEGS = 0x0800;
    public static final int SLOT_FEET = 0x1000;
    public static final int SLOT_BACK = 0x2000;
    public static final int SLOT_LR_HAND = 0x4000;                 //
    public static final int SLOT_FULL_ARMOR = 0x8000;
    public static final int SLOT_HAIR = 0x010000;
    public static final int SLOT_ALLDRESS = 0x020000;
    public static final int SLOT_HAIR2 = 0x040000;
    public static final int SLOT_HAIRALL = 0x080000;              //
    public static final int SLOT_R_BRACELET = 0x100000;           //implementar
    public static final int SLOT_L_BRACELET = 0x200000;           //implementar
    public static final int SLOT_DECO = 0x400000;
    
    
    ImagePanel casco;
    ImagePanel pelo1,pelo2;
    boolean peloall;
    ImagePanel pecho;
    ImagePanel piernas;
    boolean fullarmor;
    ImagePanel guantes;
    ImagePanel ropaInterior;
    ImagePanel espalda;
    ImagePanel botas;
    boolean dress;
    
    ImagePanel manoI;
    ImagePanel manoD;
    boolean  manoID;
    
    ImagePanel orejaI;
    ImagePanel orejaD;
    boolean  orejaID;
    ImagePanel dedoI;
    ImagePanel dedoD;
    boolean  dedoID;
    ImagePanel cuello;
    ImagePanel talisman;   //aka deco?
    
    ImagePanel pulsera;
    
    GeneralImagePanel pulserai1;
    GeneralImagePanel pulserai2;
    GeneralImagePanel pulserai3;
    
    GeneralImagePanel pulserad1;
    GeneralImagePanel pulserad2;
    GeneralImagePanel pulserad3;
    
    GeneralImagePanel henna1;
    GeneralImagePanel henna2;
    GeneralImagePanel henna3;
    SpringLayout layout;
    public InventarioEquipados(){
        layout = new SpringLayout();
        
        GeneralImagePanel back = new GeneralImagePanel("img/InvEqq.gif", new Dimension(126,358));
        
        layout.putConstraint(SpringLayout.WEST, back, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 0, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.EAST, this, 5,SpringLayout.EAST, back);
        layout.putConstraint(SpringLayout.SOUTH, this, 5,SpringLayout.SOUTH, back);
        
        /*dibujarEquipado(1,SLOT_HAIR);
        dibujarEquipado(497,SLOT_HEAD);
        dibujarEquipado(5,SLOT_HAIR2);

        dibujarEquipado(107,SLOT_UNDERWEAR);
        dibujarEquipado(20,SLOT_CHEST);
        dibujarEquipado(800,SLOT_BACK);
        
        dibujarEquipado(158,SLOT_GLOVES);
        dibujarEquipado(15,SLOT_LEGS);
        dibujarEquipado(146,SLOT_FEET);       
        
        dibujarEquipado(9,SLOT_L_HAND);
        dibujarEquipado(10,SLOT_R_HAND);  
        
        dibujarEquipado(17,SLOT_L_EAR);
        dibujarEquipado(20,SLOT_NECK);
        dibujarEquipado(800,SLOT_R_EAR);
        
        dibujarEquipado(158,SLOT_L_FINGER);
        dibujarEquipado(15,SLOT_DECO);
        dibujarEquipado(146,SLOT_R_FINGER); */
        //dibujarEquipado(1,SLOT_LR_HAND);
        
        setLayout(layout);
        add(back);
    }
    
    public void dibujarEquipado(int id, int lugar){
        AbstractItem lpl = DataHandler.getItem(id);
        switch(lugar){
            case SLOT_HAIR:
                if(peloall){elim(SLOT_HAIRALL);}
                if(pelo1 != null){remove(pelo1);}
                pelo1 = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, pelo1, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, pelo1, 8, SpringLayout.NORTH, this);
                add(pelo1);
                break;
            case SLOT_HEAD:
                if(casco != null){remove(casco);}
                casco = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, casco, 47, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, casco, 8, SpringLayout.NORTH, this);
                add(casco);
                break;
            case SLOT_HAIR2:
                if(peloall){elim(SLOT_HAIRALL);}
                if(pelo2 != null){remove(pelo2);}
                pelo2 = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, pelo2, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, pelo2, 8, SpringLayout.NORTH, this);
                add(pelo2);
                break;
            case SLOT_UNDERWEAR:
                if(ropaInterior != null){remove(ropaInterior);}
                ropaInterior = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, ropaInterior, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, ropaInterior, 46, SpringLayout.NORTH, this);
                add(ropaInterior);
                break;
            case SLOT_CHEST:
                if(pecho != null){remove(pecho);}
                pecho = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, pecho, 47, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, pecho, 46, SpringLayout.NORTH, this);
                add(pecho);
                break;
            case SLOT_BACK:
                if(espalda != null){remove(espalda);}
                espalda = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, espalda, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, espalda, 46, SpringLayout.NORTH, this);
                add(espalda);
                break;
            case SLOT_GLOVES:
                if(guantes != null){remove(guantes);}
                guantes = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, guantes, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, guantes, 84, SpringLayout.NORTH, this);
                add(guantes);
                break;
            case SLOT_LEGS:
                if(piernas != null){remove(piernas);}
                piernas = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, piernas, 47, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, piernas, 84, SpringLayout.NORTH, this);
                add(piernas);
                break;
            case SLOT_FEET:
                if(botas != null){remove(botas);}
                botas = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, botas, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, botas, 84, SpringLayout.NORTH, this);
                add(botas);
                break;
            case SLOT_L_HAND:
                if(manoID){elim(SLOT_LR_HAND);}
                if(manoI != null){remove(manoI);}
                manoI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, manoI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, manoI, 133, SpringLayout.NORTH, this);
                add(manoI);
                break;
            case SLOT_R_HAND:
                if(manoID){elim(SLOT_LR_HAND);}
                if(manoD != null){remove(manoD);}
                manoD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, manoD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, manoD, 133, SpringLayout.NORTH, this);
                add(manoD);
                break;
            case SLOT_L_EAR:
                if(orejaID){elim(SLOT_LR_EAR);}
                if(orejaI != null){remove(orejaI);}
                orejaI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, orejaI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, orejaI, 182, SpringLayout.NORTH, this);
                add(orejaI);
                break;
            case SLOT_NECK:
                if(cuello != null){remove(cuello);}
                cuello = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, cuello, 47, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, cuello, 182, SpringLayout.NORTH, this);
                add(cuello);
                break;
            case SLOT_R_EAR:
                if(orejaID){elim(SLOT_LR_EAR);}
                if(orejaD != null){remove(orejaD);}
                orejaD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, orejaD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, orejaD, 182, SpringLayout.NORTH, this);
                add(orejaD);
                break;
            case SLOT_L_FINGER:
                if(dedoID){elim(SLOT_LR_FINGER);}
                if(dedoI != null){remove(dedoI);}
                dedoI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, dedoI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, dedoI, 220, SpringLayout.NORTH, this);
                add(dedoI);
                break;
            case SLOT_DECO:
                if(talisman != null){remove(talisman);}
                talisman = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, talisman, 47, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, talisman, 220, SpringLayout.NORTH, this);
                add(talisman);
                break;
            case SLOT_R_FINGER:
                if(dedoID){elim(SLOT_LR_FINGER);}
                if(dedoD != null){remove(dedoD);}
                dedoD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, dedoD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, dedoD, 220, SpringLayout.NORTH, this);
                add(dedoD);
                break;
            case SLOT_LR_FINGER:
                if(dedoD != null){remove(dedoD);}
                if(dedoI != null){remove(dedoI);}
                dedoID = true;
                dedoD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, dedoD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, dedoD, 220, SpringLayout.NORTH, this);
                add(dedoD);
                dedoI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, dedoI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, dedoI, 220, SpringLayout.NORTH, this);
                add(dedoI);
                break;
            case SLOT_LR_EAR:
                if(orejaD != null){remove(orejaD);}
                if(orejaI != null){remove(orejaI);}
                orejaID = true;
                orejaD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, orejaD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, orejaD, 182, SpringLayout.NORTH, this);
                add(orejaD);
                orejaI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, orejaI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, orejaI, 182, SpringLayout.NORTH, this);
                add(orejaI);
            case SLOT_LR_HAND:
                if(manoI != null){remove(manoI);}
                if(manoD != null){remove(manoD);}
                manoID =true;
                manoI = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, manoI, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, manoI, 133, SpringLayout.NORTH, this);
                add(manoI);
                manoD = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, manoD, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, manoD, 133, SpringLayout.NORTH, this);
                add(manoD);
                break;
            case SLOT_HAIRALL:
                if(pelo2 != null){remove(pelo2);}
                if(pelo1 != null){remove(pelo1);}
                peloall = true;
                pelo2 = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, pelo2, 86, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, pelo2, 8, SpringLayout.NORTH, this);
                add(pelo2);
                pelo1 = new ImagePanel(id,lpl.getPath(),lpl.name);
                layout.putConstraint(SpringLayout.WEST, pelo1, 8, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, pelo1, 8, SpringLayout.NORTH, this);
                add(pelo1);
                break;
            case SLOT_FULL_ARMOR:
                
        }
    }
    
    public void elim(int slot){
        switch(slot){
            case SLOT_UNDERWEAR:
                if(ropaInterior != null){remove(ropaInterior);ropaInterior=null;}
            case SLOT_R_EAR:
                if(orejaD != null){remove(orejaD);orejaD=null;}
            case SLOT_L_EAR:
                if(orejaI != null){remove(orejaI);orejaI=null;}
            case SLOT_LR_EAR:
                if(orejaI != null){remove(orejaI);orejaI=null;}
                if(orejaD != null){remove(orejaD);orejaD=null;}
                orejaID = false;
            case SLOT_NECK:
                if(cuello != null){remove(cuello);cuello=null;}
            case SLOT_R_FINGER:
                if(dedoD != null){remove(dedoD);dedoD=null;}
            case SLOT_L_FINGER:
                if(dedoI != null){remove(dedoI);dedoI=null;}
            case SLOT_LR_FINGER:
                if(dedoD != null){remove(dedoD);dedoD=null;}
                if(dedoI != null){remove(dedoI);dedoI=null;}
                dedoID = false;
            case SLOT_HEAD:
                if(casco != null){remove(casco);casco=null;}
            case SLOT_R_HAND:
                if(manoD != null){remove(manoD);manoD=null;}
            case SLOT_L_HAND:
                if(manoI != null){remove(manoI);manoI=null;}
            case SLOT_GLOVES:
                if(guantes != null){remove(guantes);guantes=null;}
            case SLOT_CHEST:
                if(pecho != null){remove(pecho);pecho=null;}
            case SLOT_LEGS:
                if(piernas != null){remove(piernas);piernas=null;}
            case SLOT_FEET:
                if(botas != null){remove(botas);botas=null;}
            case SLOT_BACK:
                if(espalda!= null){remove(espalda);espalda=null;}
            case SLOT_LR_HAND:
                if(manoD != null){remove(manoD);manoD=null;}
                if(manoI != null){remove(manoI);manoI=null;}
                manoID = false;
            case SLOT_FULL_ARMOR:
                if(pecho != null){remove(pecho);pecho=null;}
                if(piernas != null){remove(piernas);piernas=null;}
                fullarmor = false;
            case SLOT_HAIR:
                if(pelo1 != null){remove(pelo1);pelo1=null;}
            case SLOT_ALLDRESS:
                                      //??
            case SLOT_HAIR2:
                if(pelo2 != null){remove(pelo2);pelo2=null;}
            case SLOT_HAIRALL:
                if(pelo2 != null){remove(pelo2);pelo2=null;}
                if(pelo1 != null){remove(pelo1);pelo1=null;}
                peloall = false;
            case SLOT_DECO:
                if(talisman != null){remove(talisman);talisman=null;}
        }
    }
    
    public void elimAll(){
        elim(SLOT_HAIRALL);
        elim(SLOT_LR_FINGER);
        elim(SLOT_LR_HAND);
        elim(SLOT_LR_EAR);
        elim(SLOT_FULL_ARMOR);
        elim(SLOT_UNDERWEAR);
        elim(SLOT_NECK);
        elim(SLOT_HEAD);
        elim(SLOT_GLOVES);
        elim(SLOT_FEET);
        elim(SLOT_BACK);
        elim(SLOT_DECO);
        
    }
    
 
}
