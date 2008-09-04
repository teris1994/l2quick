/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
import javolution.util.FastList;

/**
 *
 * @author carl
 */
public class logger extends JPanel  {
    
    public enum type{
        botInfo (Color.ORANGE),
        botError (Color.RED),
        systemmensage (Color.YELLOW),
        friend (Color.MAGENTA),
        normal (Color.WHITE),
        comercio (Color.WHITE),
        party (Color.WHITE),
        clan (Color.WHITE),
        alianza (Color.WHITE),
        hero (Color.WHITE),
        
        shout (Color.MAGENTA);
        private final Color kolor;
        type(Color c){this.kolor = c;}
        
        public SimpleAttributeSet getAtributes(){
           SimpleAttributeSet h =  new SimpleAttributeSet();
           h.addAttribute(StyleConstants.Foreground, kolor);
           return h;
        }
    }
    List<mensaje> msgs = new FastList<mensaje>();
    
    public JTextPane tp;
    public JTextField tf;
    public JComboBox cb;
    public JButton send;
    JToggleButton bi = new JToggleButton(),be = new JToggleButton(),sm = new JToggleButton(),fr = new JToggleButton(),nr = new JToggleButton(),sh = new JToggleButton();
    JToggleButton cl = new JToggleButton("Clan",true),al = new JToggleButton("Alianza",true),co = new JToggleButton("Comercio",true),pt = new JToggleButton("Party",true),he = new JToggleButton("Hero",true);
    
    public logger(){
        
        bi.setText("Bot Info");
        be.setText("Errores");
        sm.setText("Mensajes del sistema");
        fr.setText("Amigos");
        nr.setText("Normal");
        sh.setText("Shout");
        
        Font f = new Font(Font.SERIF,Font.PLAIN,10);
        bi.setFont(f);
        be.setFont(f);
        sm.setFont(f);
        fr.setFont(f);
        nr.setFont(f);
        sh.setFont(f);
        cl.setFont(f);
        al.setFont(f);
        co.setFont(f);
        pt.setFont(f);
        he.setFont(f);
        
        Insets i = new Insets(-2,-2,-3,-1);
        
        bi.setMargin(i);
        be.setMargin(i);
        sm.setMargin(i);
        fr.setMargin(i);
        nr.setMargin(i);
        cl.setMargin(i);
        al.setMargin(i);
        co.setMargin(i);
        sh.setMargin(i);
        pt.setMargin(i);
        he.setMargin(i);
        
        bi.setSelected(true);
        be.setSelected(true);
        sm.setSelected(true);
        fr.setSelected(true);
        nr.setSelected(true);
        sh.setSelected(true);
        ActionListener acl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Actualizar();
            }
        };
        
        bi.addActionListener(acl);
        be.addActionListener(acl);
        sm.addActionListener(acl);
        fr.addActionListener(acl);
        nr.addActionListener(acl);
        cl.addActionListener(acl);
        al.addActionListener(acl);
        co.addActionListener(acl);
        sh.addActionListener(acl);
        pt.addActionListener(acl);
        he.addActionListener(acl);

        //bi.setPreferredSize(new Dimension(50,20));
        
     
        
        SpringLayout layout = new SpringLayout();
        
        setPreferredSize(new Dimension(400,200));
        this.setBackground(Color.ORANGE);
        this.setOpaque(true);
        
        layout.putConstraint(SpringLayout.WEST, bi, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, be, 0, SpringLayout.EAST, bi);
        layout.putConstraint(SpringLayout.WEST, sm, 0, SpringLayout.EAST, be);
        layout.putConstraint(SpringLayout.WEST, fr, 0, SpringLayout.EAST, sm);
        layout.putConstraint(SpringLayout.WEST, nr, 0, SpringLayout.EAST, fr);
        layout.putConstraint(SpringLayout.WEST, sh, 0, SpringLayout.EAST, nr);
        layout.putConstraint(SpringLayout.WEST, cl, 0, SpringLayout.EAST, sh);
        layout.putConstraint(SpringLayout.WEST, al, 0, SpringLayout.EAST, cl);
        layout.putConstraint(SpringLayout.WEST, co, 0, SpringLayout.EAST, al);
        layout.putConstraint(SpringLayout.WEST, pt, 0, SpringLayout.EAST, co);
        layout.putConstraint(SpringLayout.WEST, he, 0, SpringLayout.EAST, pt);
        layout.putConstraint(SpringLayout.EAST, he, 0, SpringLayout.EAST, this);
        String[] chans = {"Normal","Comercio","Party","Clan","Alianza" };
        
        JScrollPane jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        
        tp = new JTextPane();
        tp.setEditable(false);
        tf = new JTextField();
        cb = new JComboBox(chans);
        
        jsp.setViewportView(tp);
        
        cb.addActionListener(new ActionListener() {     
           public void actionPerformed(ActionEvent e) {
               if(true){}
               if(tf.getText().startsWith("!")||
                   tf.getText().startsWith("#")||
                   tf.getText().startsWith("$")||
                   tf.getText().startsWith("+")||
                   tf.getText().startsWith("@")||
                   tf.getText().startsWith("%")||
                   tf.getText().startsWith("!")
                ){
                    tf.setText(tf.getText().substring(1));
               }
                    switch(cb.getSelectedIndex()){
                        case 0:
                            return;
                        case 1:
                            tf.setText("+"+tf.getText());
                            return;
                        case 2:
                            tf.setText("#"+tf.getText());
                            return;
                        case 3:
                            tf.setText("@"+tf.getText());
                            return;
                        case 4:
                            tf.setText("$"+tf.getText());
                            return;
                    }
                }
        });

                
        
        send = new JButton("Enviar");
        send.setMaximumSize(new Dimension(40,20));
        
        
        layout.putConstraint(SpringLayout.SOUTH, tf, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.SOUTH, cb, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.SOUTH, send, 0, SpringLayout.SOUTH, this);
        
        layout.putConstraint(SpringLayout.WEST, cb, 0, SpringLayout.WEST, this);
         layout.putConstraint(SpringLayout.EAST, send, 0, SpringLayout.EAST, this);
                
        layout.putConstraint(SpringLayout.WEST, tf, 0, SpringLayout.EAST, cb);
        layout.putConstraint(SpringLayout.EAST, tf, 0, SpringLayout.WEST, send);

        
        layout.putConstraint(SpringLayout.NORTH, cb, 0, SpringLayout.NORTH, tf);
        layout.putConstraint(SpringLayout.NORTH, send, 0, SpringLayout.NORTH, tf);
                
        layout.putConstraint(SpringLayout.WEST, jsp, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, jsp, 0, SpringLayout.SOUTH, bi);
        layout.putConstraint(SpringLayout.WIDTH, jsp, 0, SpringLayout.WIDTH, this);
        layout.putConstraint(SpringLayout.SOUTH, jsp, 0, SpringLayout.NORTH, cb);
        
        layout.putConstraint(SpringLayout.NORTH, bi, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, be, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, sm, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, fr, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, nr, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, sh, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, cl, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, al, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, co, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, pt, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.NORTH, he, 0, SpringLayout.NORTH, this);
        setLayout(layout);
        
        add(bi);
        add(be);
        add(sm);
        add(fr);
        add(nr);
        add(sh);
        add(cl);
        add(al);
        add(co);
        add(pt);
        add(he);
        
        add(cb);
        add(tf);
        add(send);
        add(jsp);       
        

    }
    
    public void Actualizar() {
        Document g = tp.getDocument();
        try {
            g.remove(0, g.getLength());

        
            for (int i = 0; i < msgs.size(); i++) {
                mensaje m = msgs.get(i);
                switch(m.tipo){
                    case botInfo:
                        if(!bi.isSelected()){continue;}
                        break;
                    case botError:
                        if(!be.isSelected()){continue;}
                        break;
                    case systemmensage:
                        if(!sm.isSelected()){continue;}
                        break;
                    case friend:
                        if(!fr.isSelected()){continue;}
                        break;
                    case shout:
                        if(!sh.isSelected()){continue;}
                        break;
                    case normal:
                        if(!nr.isSelected()){continue;}
                        break;
                    case clan:
                        if(!cl.isSelected()){continue;}
                        break;
                    case alianza:
                        if(!al.isSelected()){continue;}
                        break;
                    case comercio:
                        if(!co.isSelected()){continue;}
                        break;
                    case party:
                        if(!pt.isSelected()){continue;}
                        break;
                    case hero:
                        if(!he.isSelected()){continue;}
                        break;
                }
                
                g.insertString(g.getLength(), m.msg + "\n", m.tipo.getAtributes());
            }
         } catch (BadLocationException ex) {
            Logger.getLogger(logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void logError(String str){
        msgs.add(new mensaje(str,type.botError));
        Actualizar();
    }
    public void logInfo(String str){
        msgs.add(new mensaje(str,type.botInfo));
        Actualizar();
    }
    public void logSysMsg(String str){
        msgs.add(new mensaje(str,type.systemmensage));
        Actualizar();
    }
    public void logFriendSay(String str){
        msgs.add(new mensaje(str,type.friend));
        Actualizar();
    }        
    public void logNormal(String str){
        msgs.add(new mensaje(str,type.normal));
        Actualizar();
    }
    public void logShout(String str){
        msgs.add(new mensaje(str,type.shout));
        Actualizar();
    }    
    public void logClan(String str){
        msgs.add(new mensaje(str,type.clan));
        Actualizar();
    }   
    public void logAli(String str){
        msgs.add(new mensaje(str,type.alianza));
        Actualizar();
    }       
    public void logComercio(String str){
        msgs.add(new mensaje(str,type.comercio));
        Actualizar();
    }   
    public void logParty(String str){
        msgs.add(new mensaje(str,type.party));
        Actualizar();
    }
    public void logHero(String str){
        msgs.add(new mensaje(str,type.hero));
        Actualizar();
    }    
    class mensaje{
        String msg;
        type tipo;
        public mensaje(String _msg, type _tipo){
            msg = _msg;
            tipo = _tipo;
        }
    }

}
