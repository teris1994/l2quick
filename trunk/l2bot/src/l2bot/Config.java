/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;




/**
 *
 * @author carl
 */
public class Config {
    
    public static String lang;
    public static String country;
    
    public static void Init(){
        Properties r = new Properties();
        try {
                FileInputStream in = new FileInputStream("config.properties");
                r.load(in);
            } catch (FileNotFoundException ex) {
                return;
            } catch (IOException ex) {
               return;
            }
        lang = r.getProperty("lang");
        country = r.getProperty("country");
    
    }
    
    
    
    
    

}
