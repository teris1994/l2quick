/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;
import l2bot.interfaz.map.DMap;
import javax.swing.*;

/**
 *
 * @author carl
 */
public class PjInter extends JPanel{
    String nombre;
    String login;
    public Inventario inv;
    public DMap map;       
    public logger l = new logger();
    
    public PjInter(String name){
        nombre = name;

        add(l);
        JTabbedPane cosas = new JTabbedPane();
        
        map = new DMap();
        
        inv = new Inventario();
        
        cosas.add("Inventario", inv);
        cosas.add("Acciones",new Acciones());
        add(cosas);
        
        SpringLayout layout = new SpringLayout();
        
        layout.putConstraint(SpringLayout.SOUTH, l, -5, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, l, 5, SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.WEST, cosas, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, cosas, 5, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.EAST, map, -5, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, map, 5, SpringLayout.NORTH, this);        
        
        setLayout(layout);
        
        
        add(map);
        
    }
    
    @Override
    public String toString(){
    return nombre;
    }
    
}
