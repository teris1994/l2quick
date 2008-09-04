/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author carl
 */
public class ImagePanel extends JPanel {
    private Image img;
    public int id;

    public ImagePanel(int _id,String path, String _info1) {
        
        this(new ImageIcon(path).getImage(),_info1, _id);
        
    }

    public ImagePanel(Image img, String _info1, int _id) {   
        id = _id;
        this.img = img;
        setToolTipText(_info1);
        Dimension size = new Dimension(32,32);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img,0,0,null);
    }
 }