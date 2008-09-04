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
public class Armor extends AbstractItem{
    public enum BodyPart{chest,legs,feet,head,gloves,underwear,fullarmor,lrear,lrfinger,neck,wolf,hatchling,strider,face,hair,dhair,babypet,hairall,rbracelet,lbracelet,greatwolf,talisman}
    public enum ArmorType{light,heavy,none,magic,pet}
    
    public BodyPart bodyPart;
    public ArmorType armorType;
    
    public int pDef;
    public int mDef;
    public int mpBonus;
    public int avoidModify;
    public Armor(String data){
        // 0    1     2    3     4     5    6    7   8 9 10 11 12 13 14  15   16   17  18
        //21;Shirt;chest;false;light;4830;cloth;none;0;-1;36;0;0;147;0;true;true;true;true
        
        
        String[] k;
        k=new String[19];
        k = data.split(";");    
        id = Integer.parseInt(k[0].trim());
        name = k[1].trim();
        bodyPart = BodyPart.valueOf(k[2].trim());
        crystallizable = k[3].trim().startsWith("t");
        armorType =  ArmorType.valueOf(k[4].trim());
        peso = Integer.parseInt(k[5].trim());
        material = k[6].trim();
        cristalType = cristales.valueOf(k[7].trim());
        
        avoidModify = Integer.parseInt(k[8].trim());
        
        duracion = Integer.parseInt(k[9].trim());
        
        pDef = Integer.parseInt(k[10].trim());
        mDef = Integer.parseInt(k[11].trim());
        mpBonus = Integer.parseInt(k[12].trim());
        
        
        precio = Integer.parseInt(k[13].trim());
        cristalCount = Integer.parseInt(k[14].trim());

        sellable = k[15].trim().startsWith("t");
        dropable = k[16].trim().startsWith("t");
        destroyable= k[17].trim().startsWith("t");
        tradeable = k[18].trim().startsWith("t");        
    }
    
    
    public String toString2(){
    String r ="";
    r+=" " + name + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Id") + ": " + id + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Peso") + ": " + peso + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Precio") + ": " + precio + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Parte_del_cuerpo") + ": " + bodyPart.toString() + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Tipo_de_armadura") + ": " + armorType.toString() + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Material") + ": " + material + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Modif._evitar") + ": " + avoidModify + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("pDef") + ": " + pDef + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("mDef") + ": " + mDef + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("mpBonus") + ": " + mpBonus + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Peso") + ": " + peso + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Cristalizable") + ": " + (crystallizable?ResourceBundle.getBundle("lang/main").getString("si")+ " (" + cristalCount + ResourceBundle.getBundle("lang/main").getString("Cristales_Grado_") + cristalType.toString():ResourceBundle.getBundle("lang/main").getString("no")) + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Duracion") + ": " + duracion + "\n";
    r+=" " + (sellable?ResourceBundle.getBundle("lang/main").getString("Se_puede_vender"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_vender"))+ "\n";
    r+=" " + (tradeable?ResourceBundle.getBundle("lang/main").getString("Se_puede_tradear"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_tradear")) + "\n";
    r+=" " + (dropable?ResourceBundle.getBundle("lang/main").getString("Se_puede_dropear"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_dropear")) + "\n";
    r+=" " + (destroyable?ResourceBundle.getBundle("lang/main").getString("Se_puede_destruir"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_destruir")) + "\n";
    r+="";
    return r;
    }
    

}

