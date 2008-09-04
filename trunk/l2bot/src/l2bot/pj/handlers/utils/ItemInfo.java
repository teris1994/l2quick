/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers.utils;

/**
 *
 * @author carl
 */
    public class ItemInfo
    {
        public int objectId;
        public int itemId;
        public int enchant;
        public int argumentation;
        public int count;
        public int price;
        public int slot;
        public int type1;
        public int type2;
        public int customType1;
        public int customType2;
        public boolean  equipped;
        public int mana;
        public int location;
        public int element;
        public int val;
        public int fire;
        public int water;
        public int earth;
        public int wind;
        public int holy;
        public int unholy;

        public ItemInfo(int type,int objectId,int ItemId,int location,int count,int type2,int customType,boolean equiped,int slot,int enchant,int custonType2,int argument,int mana,int element,int val,int fire,int water,int wind,int earth,int holy,int unHoly)
        {
            this.type1 = type;
            this.objectId = objectId;
            this.itemId = ItemId;
            this.location = location;
            this.count =count;
            this.type2 = type2;
            this.customType1 = customType;
            this.equipped = equiped;
            this.slot = slot;
            this.enchant = enchant;
            this.customType2 = custonType2;
            this.argumentation = argument;
            this.mana = mana;
            this.element = element;
            this.val = val;
            this.fire = fire;
            this.water = water;
            this.wind = wind;
            this.earth = earth;
            this.holy = holy;
            this.unholy = unHoly;
        }
    
    }