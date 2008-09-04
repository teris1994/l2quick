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
public class GeneralImagePanel extends JPanel {

  private Image img;
  private Dimension di;
  public GeneralImagePanel(String img, Dimension d) {
    this(new ImageIcon(img).getImage(),d);
  }

  public GeneralImagePanel(Image img,Dimension d) {
    this.img = img;
    this.di = d;
    Dimension size = di;
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

    @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}