/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javolution.util.FastList;

/**
 *
 * @author carl
 */
    public class DrawableChar extends Drawable{
        
        private int agro;
        
        private String name = "asdf";
        private String title = "Lvl 80*";
        
        private Color nameColor = Color.WHITE;
        private Color titleColor = new Color(0,255,127);
        
        private Color color;
        
        public List<Integer> effects = new FastList<Integer>();
        
        public DrawableChar(int x, int y, int z, int agro, int radio,Color color){
        setX(x);
        setY(y);
        setZ(z);
        this.agro = agro;
        setRadio(radio);
        this.color = color;
        }

        public int getAgro() {
            return agro;
        }
        public void setAgro(int agro) {
            this.agro = agro;
        }
        public Color getColor() {
            return color;
        }
        public void setColor(Color color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void draw(Graphics g) {
            if(getAgro() > 0){
                g.setColor(Color.RED);
                g.fillOval(getX()-getAgro(), getY()-getAgro(), getAgro()*2, getAgro()*2);
            }
            g.setColor(getColor());
            g.drawOval(getX()-getRadio(), getY()-getRadio(),getRadio()*2, getRadio()*2);
        }

        @Override
        public void drawInfo(Graphics g) {
            g.setColor(getNameColor());
            g.drawString(getName(), getX() - (g.getFontMetrics().stringWidth(getName())/2), getY()-getRadio() - 3);
            g.setColor(getTitleColor());
            g.drawString(getTitle(), getX() - (g.getFontMetrics().stringWidth(getTitle())/2), getY()-getRadio() - 3 -12);
            
            int off = getX()-(effects.size()*8);
            int h = getY()-getRadio()-43;
            for(int i=0;i<effects.size();i++){
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("skills/s"+effects.get(i)+".gif"));
                } catch (IOException e) {
                }
                g.drawImage(img, off+(i*16),h,16,16,null);
            }
            
        }

    public Color getNameColor() {
        return nameColor;
    }

    public void setNameColor(Color nameColor) {
        this.nameColor = nameColor;
    }

    public Color getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    }