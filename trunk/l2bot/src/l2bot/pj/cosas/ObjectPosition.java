/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.cosas;

import l2bot.util.Point3D;

/**
 *
 * @author carl
 */


public class ObjectPosition
{
    private int _heading    = 0;
    private Point3D _worldPosition;

    // =========================================================
    // Constructor
    public ObjectPosition(int x, int y, int z)
    {
        setXYZ(x,y,z);
    }

    public final void setXYZ(int x, int y, int z)
    {
        setWorldPosition(x, y ,z);
    }

    public final int getHeading() { return _heading; }
    public final void setHeading(int value) { _heading = value; }

    public final int getX() { return getWorldPosition().getX(); }
    public final void setX(int value) { getWorldPosition().setX(value); }

    public final int getY() { return getWorldPosition().getY(); }
    public final void setY(int value) { getWorldPosition().setY(value); }

    public final int getZ() { return getWorldPosition().getZ(); }
    public final void setZ(int value) { getWorldPosition().setZ(value); }

    public final Point3D getWorldPosition()
    {
        if (_worldPosition == null)
        {
            _worldPosition = new Point3D(0, 0, 0);
        }
        return _worldPosition;
    }
    public final void setWorldPosition(int x, int y, int z)
    {
        getWorldPosition().setXYZ(x,y,z);
    }
    public final void setWorldPosition(Point3D newPosition) { setWorldPosition(newPosition.getX(), newPosition.getY(), newPosition.getZ()); }
}