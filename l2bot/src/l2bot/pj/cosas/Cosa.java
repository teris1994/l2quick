/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.cosas;

import l2bot.pj.*;

/**
 *
 * @author carl
 */
public class Cosa {
    public String _name;
    public int _objectId; 
    public ObjectPosition _position;
    
    public Cosa(int objectId)
    {
        _objectId = objectId;
    }
    public final String getName()
    {
        return _name;
    }
    public final void setName(String value)
    {
        _name = value;
    }

    public final int getObjectId()
    {
        return _objectId;
    }
    public final ObjectPosition getPosition(){
        return _position;
    }
    public final void setPosition(ObjectPosition pos){
        _position = pos;
    }  
}
