/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;


import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author carl
 */
public class PjInfo {
    public String server;
    
    public String user;
    public String pass;
    
    public String host;
    public int port;
    public String gss;
    
    
    
    public PjInfo(String nombre){
        DOMParser parser = new DOMParser();
        try {
            parser.parse("xml/accounts.xml");
        } catch (SAXException ex) {
           
        } catch (IOException ex) {
           
        }
        Document doc = parser.getDocument();
        NodeList f = doc.getElementsByTagName("account");
        
        for(int i=0;i<f.getLength();i++){
            if(((Element)f.item(i)).getAttribute("user").equals(nombre)){
                user = ((Element)f.item(i)).getAttribute("user");
                pass = xord(((Element)f.item(i)).getAttribute("pass"));
                server = ((Element)f.item(i)).getAttribute("server");
                try {
                    parser.parse("xml/servers.xml");
                } catch (SAXException ex) {

                } catch (IOException ex) {

                }
                doc = parser.getDocument();
                f = doc.getElementsByTagName("server");
                for(i=0;i<f.getLength();i++){
                    if(((Element)f.item(i)).getAttribute("name").equals(server)){
                        host = ((Element)f.item(i)).getAttribute("host");
                        port = Integer.parseInt(((Element)f.item(i)).getAttribute("port"));
                        gss = ((Element)f.item(i)).getAttribute("gameservers");
                        return;
                    }
                }
                //error
            }
        }
        //error
        
    }
    
    String xord(String s){
         s = s.replace(" ","");
        byte[] bts = new byte[s.length() / 2];
        for (int i = 0; i < bts.length; i++) {
           bts[i] = (byte) Integer.parseInt(s.substring(2*i, 2*i+2), 16);
           bts[i] ^= 0x0f;
        }
        return new String(bts);
    }   
}
    