/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.data;

import java.util.ResourceBundle;

/**
 *
 * @author carl
 */
public class Weapon extends AbstractItem{
    public enum BodyPart{rhand,lrhand,lhand,wolf,hatchling,strider,greatwolf}
    public enum WeaponType{sword,blunt,bigblunt,dagger,bow,pole,none,bigsword,etc,fist,dualfist,dual,pet,rod,rapier,ancient,crossbow}
    
    public WeaponType weaponType;
    
    public BodyPart bodyPart;
    public byte shoulShots;
    public byte spiritShots;
    
    public int pDmg;
    public int rndDmg;
    public int critical;
    public float hitModify;
    public int avoidModify;
    public int shieldDef;
    public int shieldDefRate;
    public int atkSpeed;
    public int mpConsume;
    public int mDmg;
    
    
    
    public Weapon(String data){
        // 0      1        2     3   4   5 6   7    8   9 10  11  12   13   141516 17 18 19 20 21 22 23  24   25    26
        //1;Short Sword;rhand;false;1600;1;1;steel;none;8;10;sword;8;0.00000;0;0;0;379;0;6;-1;768;0;true;true;true;true
        
        
        String[] k;
        k=new String[27];
        k = data.split(";");
        id = Integer.parseInt(k[0].trim());
        name = k[1].trim();
        bodyPart = BodyPart.valueOf(k[2].trim());
        crystallizable = k[3].trim().startsWith("t");
        peso = Integer.parseInt(k[4].trim());
        shoulShots = Byte.parseByte(k[5].trim());
        spiritShots = Byte.parseByte(k[6].trim());
        material = k[7].trim();
        cristalType = cristales.valueOf(k[8].trim());
        
        pDmg = Integer.parseInt(k[9].trim());
        rndDmg = Integer.parseInt(k[10].trim());
        
        weaponType = WeaponType.valueOf(k[11].trim());
        
        critical = Integer.parseInt(k[12].trim());
        hitModify = Float.parseFloat(k[13].trim());
        avoidModify = Integer.parseInt(k[14].trim());
        
        shieldDef = Integer.parseInt(k[15].trim());
        shieldDefRate = Integer.parseInt(k[16].trim());
        
        atkSpeed = Integer.parseInt(k[17].trim());
        
        mpConsume = Integer.parseInt(k[18].trim());
        mDmg = Integer.parseInt(k[19].trim());
        
        duracion = Integer.parseInt(k[20].trim());
        precio = Integer.parseInt(k[21].trim());
        cristalCount = Integer.parseInt(k[22].trim());

        sellable = k[23].trim().startsWith("t");
        dropable = k[24].trim().startsWith("t");
        destroyable= k[25].trim().startsWith("t");
        tradeable = k[26].trim().startsWith("t");        
    }
    
    @Override
    public String toString2(){
    String r ="";
    r+=" " + name + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Peso") + ": " + peso + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Precio") + ": " + precio + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Cristalizable") + ": " + (crystallizable?ResourceBundle.getBundle("lang/main").getString("si") + " (" + cristalCount + ResourceBundle.getBundle("lang/main").getString("Cristales_Grado_") + cristalType.toString():ResourceBundle.getBundle("lang/main").getString("no")) + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Duracion") + ": " + duracion + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Material") + ": " + material + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Tipo_de_arma") + ": " + weaponType.toString() + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Parte_del_cuerpo") + ": " + bodyPart.toString() + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("ShoulShots") + ": " + shoulShots + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("SpiritShots") + ": " + spiritShots + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("pDmg") + ": " + pDmg + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("rndDmg") + ": " + rndDmg + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Critical") + ": " + critical + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Modif._hit") + ": " + hitModify + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Modif._evitar") + ": " + avoidModify + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Defensa_de_escudo") + ": " + shieldDef + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Rate_def._escudo") + ": " + shieldDefRate + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("atkSpeed") + ": " + atkSpeed + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Consumo_mp") + ": " + mpConsume + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("mDmg") + ": " + mDmg + "\n";
    r+=" " + (sellable?ResourceBundle.getBundle("lang/main").getString("Se_puede_vender"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_vender"))+ "\n";
    r+=" " + (tradeable?ResourceBundle.getBundle("lang/main").getString("Se_puede_tradear"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_tradear")) + "\n";
    r+=" " + (dropable?ResourceBundle.getBundle("lang/main").getString("Se_puede_dropear"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_dropear")) + "\n";
    r+=" " + (destroyable?ResourceBundle.getBundle("lang/main").getString("Se_puede_destruir"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_destruir")) + "\n";
    
    
    return r;
    }
    public String toHTMLString(){
    return "<html>" + toString().replace("\n", "<br>") + "</html>";
    }
}
