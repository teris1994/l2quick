/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.data;

import java.io.File;
import java.util.ResourceBundle;

/**
 *
 * @author carl
 */
public abstract class AbstractItem {
    public enum cristales{none,a,b,c,d,s,s80}
    public enum type{etcItem,weapon,armor};
    public enum objType{etcItem,weapon,armor}
    
    public objType typo;
    
    public String name;
    public int id;
    public int peso;
    public int precio;
    public int duracion;
    public String material;
    
    public cristales cristalType;
    public int cristalCount;
    
    
    boolean crystallizable;
    boolean sellable;
    boolean dropable;
    boolean destroyable;
    boolean tradeable;
    

    public abstract String toString2();
    
    public String getPath(){
        return (new File("items/" + id + ".gif")).exists()?"items/" + id + ".gif":"items/unknown.gif";

    }
    @Override
    public String toString(){
        String r ="";
        r+=" " + name + "\n";
        r+=" " + ResourceBundle.getBundle("lang/main").getString("Peso") + ": " + peso + "\n";
        r+=" " + ResourceBundle.getBundle("lang/main").getString("Precio") + ": " + precio + "\n";
        r+=" " + ResourceBundle.getBundle("lang/main").getString("Duracion") + ": " + duracion;
        return r;
    }
    public String toHTMLString(){
        return "<html>" + toString().replace("\n", "<br>") + "</html>";
    }
    
}
