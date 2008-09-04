/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.util;

import java.awt.Point;

/**
 *
 * @author carl
 */
public class Geometry {
    public static boolean isPointInCircle(int x, int y, int x1, int y1, int rad){
        return isPointInCircle(new Point(x,y), new Point(x1,y1),rad);
    }
    public static boolean isPointInCircle(Point point, Point center, int rad){
        return distancia(point,center) <= rad;
    }
    
    public static double distancia(Point a, Point b){
        return Math.sqrt( Math.pow ((a.x-b.x),2) + Math.pow((a.y-b.y),2));
    }
}
