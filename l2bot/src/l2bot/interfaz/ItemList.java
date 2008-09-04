/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import l2bot.data.*;

/**
 *
 * @author carl
 */
public class ItemList extends JPanel implements MouseListener{
    public int margin =3;
    
    ImagePanel seli;
    ImagePanel popi;
    
    public int count=0;
    public int cols;
    public int rows;
    
    JScrollPane f;
    
    
    JLayeredPane lp;
    //Panel lp;
    JPopupMenu popup;
    SpringLayout l;
    
    public ItemList( int columnas,int filas){
        cols = columnas;
        rows = filas;
        
        f = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        f.setPreferredSize(new Dimension(margin*2 + columnas*(32+margin)+16,margin*2 + filas*(32+margin) ));
        
        lp = new JLayeredPane();
        //lp = new Panel();
        l= new SpringLayout();
        lp.setLayout(l);
        lp.setBackground(new Color(0xc8,0xdd,0xf2));
        lp.setOpaque(true);
        
        JTextArea asd = new JTextArea();
        asd.setSize(100,100);
        lp.add(asd);
        //lp.setMinimumSize(new Dimension(100,100));
        lp.setPreferredSize(new Dimension(2*margin + cols * (32 + margin),margin*2 + filas*(32+margin)));
        

            
         for (int i = 1; i < 50; i++) {
            addElement(i,"(muchos)");
        }
          
        
        
        f.setViewportView(lp);

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        add(f);
    }
    
   public void addElement(int id,String info){
       
        AbstractItem lpl = DataHandler.getItem(id);
        ImagePanel ip = new ImagePanel(id,lpl.getPath(), "<html>"+lpl.name+info+"</html>");
        count ++;
        int fila = fila(count);
        int colu = columna(count);
        int x1 = margin + (colu-1)*(32+margin);
        int y1 = margin + (fila-1)*(32+margin);
        //ip.setBounds(x1, y1,32,32);
        
        ip.addMouseListener(this);
        
        
        lp.add(ip);
        
        
        l.putConstraint(SpringLayout.WEST, ip, x1, SpringLayout.WEST, lp);
        l.putConstraint(SpringLayout.NORTH, ip,y1, SpringLayout.NORTH,lp);
        
        lp.setPreferredSize(new Dimension(2*margin + cols * (32 + margin),margin + Math.max(fila,rows)*(32+margin)));
        
        
        //lp.setSize(margin*2 + cols*(32+margin),y1+32);

    }
     public int fila(int xx){
       return (xx + (cols-1))/cols;
     }
        
     public int columna(int xx){
        return ((xx-1)%cols)+1;
     }
     
     public void borrar(){
         lp.removeAll();
         count=0;
     }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if (seli != null){
            seli.setBorder(null);
            }
            seli = ((ImagePanel)e.getSource());
            seli.setBorder(new LineBorder(Color.cyan));
        }else if(e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3){
            if(popup != null){
                popi = ((ImagePanel)e.getSource());
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putPopup(String[] s,ActionListener al){   
        popup = new JPopupMenu();
        for (int i = 0; i < s.length; i++) {
            JMenuItem sa = new JMenuItem(s[i]);
            sa.addActionListener(al);
            popup.add(sa);
        }
    }
    public ImagePanel getPopupPanel(){
        return popi;
    } 
    public ImagePanel getSelectedPanel(){
        return seli;
    } 
    

}
