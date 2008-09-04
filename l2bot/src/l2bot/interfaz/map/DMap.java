/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz.map;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javolution.util.FastList;
import l2bot.util.Geometry;

/**
 *
 * @author carl
 */
public class DMap extends JLayeredPane{
    JPanel info;
    JPanel map;
    JPanel objs;
    
    List<Drawable> objetos = new FastList<Drawable>();

    Drawable over;
    
    public DMap(){
        info = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                paintInfo(g);
            }
        };
        map = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                paintMap(g);
            }
        };
        objs = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                paintObjs(g);
            }
        };
        objs.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {}
            public void mouseMoved(MouseEvent e) {
                showInfo(e.getPoint().x,e.getPoint().y);
            }
        });
        DrawableChar dc = new DrawableChar(100,100,100,20,2,Color.GREEN);
        dc.effects.add(4118);
        dc.effects.add(4119);
        dc.effects.add(4120);
        dc.effects.add(4121);
        dc.effects.add(4122);
        
        objetos.add(dc);
        this.setBackground(Color.BLUE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(500,500));
        this.setVisible(true);
        //this.setLayout(new BorderLayout());    
        this.setLayout(null);    
        

        map.setOpaque(true);
        
        map.setBounds(0,0,500,500);
        info.setBounds(0,0,500,500);
        objs.setBounds(0,0,500,500);
        objs.setOpaque(false);
        map.setOpaque(false);
        info.setOpaque(false);
        
        add(info);
        add(map);
        add(objs);

    }
    
    public void paintInfo(Graphics g){
        if(over == null)return;
        over.drawInfo(g);
    }
    public void paintMap(Graphics g){}
    public void paintObjs(Graphics g){
        for(int i=0;i<objetos.size();i++){
            Drawable dc = objetos.get(i);
            dc.draw(g);
        }
    }
    
    public void showInfo(int x,int y){

       for(int i=0;i<objetos.size();i++){
           Drawable dc = objetos.get(i);
            if(Geometry.isPointInCircle(x, y, dc.getX(), dc.getY(), dc.getRadio())){
                over = dc;
                info.repaint();
                return;
            }
        }
       over = null;
       info.repaint();
    }
    

}
