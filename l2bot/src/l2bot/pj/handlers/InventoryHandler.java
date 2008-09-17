/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers;

import java.util.Map;
import javolution.util.FastMap;
import l2bot.interfaz.Inventario;
import l2bot.pj.handlers.utils.ItemInfo;
/**
 *
 * @author carl
 */
public class InventoryHandler extends AbstractHandler {
    Inventario inter;
    
    public Map<Integer,ItemInfo> inventario = new FastMap<Integer,ItemInfo>();
    public int underwear;
    public int r_ear;
    public int l_ear;
    public int lr_ear;
    public int neck;
    public int r_finger;
    public int l_finger;
    public int lr_finger;
    public int head;
    public int r_hand;
    public int l_hand;
    public int gloves;
    public int chest;
    public int legs;
    public int feet;
    public int back;
    public int lr_hand;
    public int full_armor;
    public int hair;
    public int alldress;
    public int hair2;
    public int hairall;
    public int r_bracelet;
    public int l_bracelet;
    
    public InventoryHandler(){
        inter = getPj().inter.inv;
    }
    
    public void addItem(ItemInfo info)
    {
        inventario.put(info.objectId, info);
        if(info.equipped){
            inter.inve.dibujarEquipado(info.itemId, info.slot);
        }else{
            if(info.type2 == 0x03){
                inter.Qitems.addElement(info.itemId, " (" + info.count + ")");
            }else{
                inter.items.addElement(info.itemId, " (" + info.count + ")");
            }
        }
    }
    public void removeItem(ItemInfo info)
    {
        inventario.remove(info.objectId);
    }
    public void updateItem(ItemInfo info)
    {
        inventario.put(info.objectId, info);
    }
    
    public void actualizarDisplay(){
        inter.inve.elimAll();
        inter.Qitems.borrar();
        inter.items.borrar();
        for(ItemInfo info: inventario.values()){
            if(info.equipped){
                inter.inve.dibujarEquipado(info.itemId, info.slot);
            }else{
                if(info.type2 == 0x03){
                    inter.Qitems.addElement(info.itemId, " (" + info.count + ")");
                }else{
                    inter.items.addElement(info.itemId, " (" + info.count + ")");
                }
            }
        }
    }
}
