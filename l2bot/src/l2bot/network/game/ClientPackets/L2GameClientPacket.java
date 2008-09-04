/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2bot.network.game.ClientPackets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * Packets received by the game server from clients
 * @author  KenM
 */
public abstract class L2GameClientPacket
{
    ByteArrayOutputStream _bao;
    
    public enum Rellenar{NO,PADDING,SI}

    private int largo;
    public Rellenar rellenar;
    
    public int largo(){
    return largo;
    }
    
    public Rellenar rellenar(){
        return rellenar;
    }
    
    
    protected L2GameClientPacket()
    {
        _bao = new ByteArrayOutputStream();
    }

    protected void writeD(int value)
    {
        _bao.write(value &0xff);
        _bao.write(value >> 8 &0xff);
        _bao.write(value >> 16 &0xff);
        _bao.write(value >> 24 &0xff);
    }

    protected void writeH(int value)
    {
        _bao.write(value &0xff);
        _bao.write(value >> 8 &0xff);
    }

    protected void writeC(int value)
    {
        _bao.write(value &0xff);
    }

    protected void writeF(double org)
    {
        long value = Double.doubleToRawLongBits(org);
        _bao.write((int)(value &0xff));
        _bao.write((int)(value >> 8 &0xff));
        _bao.write((int)(value >> 16 &0xff));
        _bao.write((int)(value >> 24 &0xff));
        _bao.write((int)(value >> 32 &0xff));
        _bao.write((int)(value >> 40 &0xff));
        _bao.write((int)(value >> 48 &0xff));
        _bao.write((int)(value >> 56 &0xff));
    }

    protected void writeS(String text)
    {
        try
        {
            if (text != null)
            {
                _bao.write(text.getBytes("UTF-16LE"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        _bao.write(0);
        _bao.write(0);
    }

    protected void writeB(byte[] array)
    {
        try
        {
            _bao.write(array);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public int getLength()
    {
        return _bao.size();
    }

    public byte[] getBytes()
    {
        return _bao.toByteArray();
    }
    
    
}