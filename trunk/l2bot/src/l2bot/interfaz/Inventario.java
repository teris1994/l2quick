/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import l2bot.Idioma;
import l2bot.data.DataHandler;
import l2bot.interfaz.dialogs.DialogosComunes;

/**
 *
 * @author carl
 */
public class Inventario extends JPanel{
    public ItemList items;
    public ItemList Qitems;
    SpringLayout layout;
    
    Button destruir;
    Button dropear;
    Button cristalizar;
    JLabel adena;
    JProgressBar load;
    public InventarioEquipados inve;
    
    
    public Inventario(){
        items = new ItemList(6,8);
        String[] labs = {Idioma.mostrar_info,Idioma.usar,Idioma.tirar,Idioma.destruir,Idioma.cristalizar};
        items.putPopup(labs, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals(Idioma.mostrar_info)){
                    DialogosComunes.mostrarTexto(DataHandler.getItem(items.getPopupPanel().id).toString2());
                }
            }
        });
        Qitems = new ItemList(6,8);
        Qitems.putPopup(labs, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals(Idioma.mostrar_info)){
                    DialogosComunes.mostrarTexto(DataHandler.getItem(Qitems.getPopupPanel().id).toString2());
                }
            }
        });       
        
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Items", items);
        tp.addTab("Quest Items", Qitems);
         inve = new InventarioEquipados();
        
        inve.setBackground(new Color(0xc8,0xdd,0xf2));
        inve.setOpaque(true);
        
        JPanel abajo = new JPanel();
        abajo.setLayout(new BoxLayout(abajo,BoxLayout.PAGE_AXIS));
        JPanel abajo1 = new JPanel();
        JPanel abajo2 = new JPanel();
        
        destruir = new Button("Destruir");
        dropear = new Button("Dropear");
        cristalizar = new Button("Cristalizar");
        adena = new JLabel("??",new ImageIcon("img/Adena_small.gif","Adena"),JLabel.LEFT);
        //adena.setForeground(Color.WHITE);
        
        load = new JProgressBar();
        load.setPreferredSize(new Dimension(50,14));
        abajo1.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
        abajo2.setLayout(new FlowLayout(FlowLayout.TRAILING,10,0));
        abajo1.add(cristalizar);
        abajo1.add(dropear);
        abajo1.add(destruir);

        
        JLabel peso = new JLabel(new ImageIcon("img/Peso_small.gif","Peso"),JLabel.LEFT);
        abajo2.add(adena);
        abajo2.add(peso);
        abajo2.add(load);
        
        
  

        
        abajo.add(abajo1);
        abajo.add(abajo2);
        
        abajo1.setBackground(new Color(0xc8,0xdd,0xf2));
        abajo1.setOpaque(true);
        abajo2.setBackground(new Color(0xc8,0xdd,0xf2));
        abajo2.setOpaque(true);
        
        
        
        
        layout = new SpringLayout();
        layout.putConstraint(SpringLayout.WEST, inve, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, inve, 0, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, tp, 0, SpringLayout.EAST, inve);
        layout.putConstraint(SpringLayout.NORTH, tp, 0, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, tp);
        layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, inve);
        
        layout.putConstraint(SpringLayout.WEST, abajo, 0, SpringLayout.EAST, inve);
        layout.putConstraint(SpringLayout.NORTH, abajo, 0, SpringLayout.SOUTH, tp);
        
        setLayout(layout);
        add(inve);
        add(tp);
        add(abajo);
        
        setBackground(new Color(0xc8,0xdd,0xf2));
        setOpaque(true);
        
 
    }
    
    
    
    
    

}
