/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javolution.util.FastMap;

/**
 *
 * @author carl
 */
public class DataHandler {
    public static Map<Integer,AbstractItem> itemsData = new FastMap<Integer,AbstractItem>();
    
    
    public static void Init(){  
        try {
            FileReader fr = new FileReader("data/etcitem.csv");
            BufferedReader bf = new BufferedReader(fr); 
            String sCadena;
            while ((sCadena = bf.readLine())!=null) {
                EtcItem item = new EtcItem(sCadena);
                itemsData.put(new Integer(item.id), item);          
            }     
        }  catch (FileNotFoundException ex) {
            System.out.println("Error leeyendo etcitem.csv");
            return;
        } catch (IOException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            FileReader fr = new FileReader("data/armor.csv");
            BufferedReader bf = new BufferedReader(fr); 
            String sCadena;
            while ((sCadena = bf.readLine())!=null) {
                Armor item = new Armor(sCadena);
                itemsData.put(new Integer(item.id), item);          
            }     
        }  catch (FileNotFoundException ex) {
            System.out.println("Error leeyendo armor.csv");
            return;
        } catch (IOException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         try {
            FileReader fr = new FileReader("data/weapon.csv");
            BufferedReader bf = new BufferedReader(fr); 
            String sCadena;
            while ((sCadena = bf.readLine())!=null) {
                Weapon item = new Weapon(sCadena);
                itemsData.put(new Integer(item.id), item);          
            }     
        }  catch (FileNotFoundException ex) {
            System.out.println("Error leeyendo weapon.csv");
            return;
        } catch (IOException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static AbstractItem getItem(int id){
        return itemsData.get(new Integer(id));
    }
    
    

}
