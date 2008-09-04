/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login.ClientPackets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 *
 * @author carl
 */
public abstract class ClientPacket {
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
    
    
    protected ClientPacket()
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
