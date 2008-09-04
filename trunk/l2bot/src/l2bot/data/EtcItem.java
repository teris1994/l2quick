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
public class EtcItem extends AbstractItem{
    public enum tipos{arrow,none,potion,quest,scroll,spellbook,shot,recipe,material,pet_collar,castle_guard,lotto,race_ticket,dye,seed,harvest,ticket_of_lord,lure,herb,bolt}
    public enum ctipos{stackable,asset,normal}
   
    public tipos tipo;
    public ctipos modoConsumo;

    public EtcItem(String data){
        // 0      1         2     3   4     5      6     7  8 9 10  11   12   13   14
        //17;Wooden Arrow;false;arrow;6;stackable;wood;none;-1;1;0;true;true;true;true
        
        
        String[] k;
        k=new String[15];
        k = data.split(";");
        id = Integer.parseInt(k[0].trim());
        name = k[1].trim();
        crystallizable = k[2].trim().startsWith("t");
        tipo = tipos.valueOf(k[3].trim());
        peso = Integer.parseInt(k[4].trim());
        modoConsumo = ctipos.valueOf(k[5].trim());
        material = k[6].trim();
        cristalType = cristales.valueOf(k[7].trim());
        duracion = Integer.parseInt(k[8].trim());
        precio = Integer.parseInt(k[9].trim());
        cristalCount = Integer.parseInt(k[10].trim());

        sellable = k[11].trim().startsWith("t");
        dropable = k[12].trim().startsWith("t");
        destroyable= k[13].trim().startsWith("t");
        tradeable = k[14].trim().startsWith("t");        
    }
    
    @Override
    public String toString2(){
    String r ="";
    r+=" " + name + "\n";
r+=" " + name + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Peso") + ": " + peso + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Precio") + ": " + precio + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Cristalizable") + ": " + (crystallizable?ResourceBundle.getBundle("lang/main").getString("si") + " (" + cristalCount + ResourceBundle.getBundle("lang/main").getString("Cristales_Grado_") + cristalType.toString():ResourceBundle.getBundle("lang/main").getString("no")) + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Duracion") + ": " + duracion + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Material") + ": " + material + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Tipo") + ": " + tipo.toString() + "\n";
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Modo_consumo") + ": " + material.toString() + "\n";

    
    r+=" " + ResourceBundle.getBundle("lang/main").getString("Duracion") + ": " + duracion + "\n";
    r+=" " + (sellable?ResourceBundle.getBundle("lang/main").getString("Se_puede_vender"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_vender"))+ "\n";
    r+=" " + (tradeable?ResourceBundle.getBundle("lang/main").getString("Se_puede_tradear"):"No se puede tradear") + "\n";
    r+=" " + (dropable?ResourceBundle.getBundle("lang/main").getString("Se_puede_dropear"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_dropear")) + "\n";
    r+=" " + (destroyable?ResourceBundle.getBundle("lang/main").getString("Se_puede_destruir"):ResourceBundle.getBundle("lang/main").getString("No_se_puede_destruir")) + "\n";
    return r;
    }
}
