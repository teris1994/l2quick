/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login;

/**
 *
 * @author carl
 */
import java.io.IOException;
import l2bot.interfaz.Sniffer;
import l2bot.pj.Pj;
        
public class LoginCrypt {
    
    public byte[] blowfishkey;
    public byte[] RSApublickey;
    public byte[] SessionID;
    
    private BlowfishEngine _decrypt;
    private BlowfishEngine _crypt;
    
    Pj pj;
    
    public LoginCrypt(byte[] init, Pj pj) throws IOException{
        this.pj = pj;
        byte[] initd = DecodeInit(init);
        
        if(initd[0] != 0x00){
            pj.getLogger().logError("id del paquete init incorrecto");
        }
        
        byte[] initSn = new byte[initd.length +2];
        System.arraycopy(initd, 0, initSn, 2, initd.length);
        
        Sniffer.getInstance().addPacket(initSn, Sniffer.LOGIN_SERVER, pj.connectionInfo.user);
        
        
        RSApublickey = new byte[128];         
        System.arraycopy(initd,9,RSApublickey,0,128);
        
        blowfishkey = new byte[16];
        System.arraycopy(initd,153,blowfishkey,0,16);
        
        SessionID = new byte[4];
        System.arraycopy(initd,1,SessionID,0,4);
        
        
        _crypt = new BlowfishEngine();
        _crypt.init(true, blowfishkey);
        _decrypt = new BlowfishEngine();
        _decrypt.init(false, blowfishkey);
        
        //System.out.println(byteArrayToHexString(initd));
        //System.out.println(byteArrayToHexString(RSApublickey));
        //System.out.println(byteArrayToHexString(blowfishkey));
    }
    
    public byte[] Desencriptar(byte[] buf,int size)throws IOException{
        //System.out.println(byteArrayToHexString(buf));
        decrypt(buf,2,size-2);
        //System.out.println(byteArrayToHexString(buf));
        if(!verifyChecksum(buf,2,size-2)){
            pj.getLogger().logError("Worng checksum");
            return null;
        }
        Sniffer.getInstance().addPacket(buf, Sniffer.LOGIN_SERVER, pj.connectionInfo.user);
        return buf;
    }
    public byte[] Encriptar(byte[] buf, int size) throws IOException{
        crypt(buf,2,size-2);
        //System.out.println(byteArrayToHexString(buf));
        return buf;
    }
    
    public static byte[] DecodeInit(byte[] raw) throws IOException
    {
            decrypts(raw,2,184);
            return Decode(raw,2,180);
    }    
    public static byte[] Decode(byte[] raw, final int offset, final int size)
    {
            int key = ByteIntR(raw, offset+size-4);
            //System.out.println("" + Integer.toHexString(key) + "        int="+key);
            int Bloques = (size/4)-1;
            int[] r = new int[Bloques];
            for(int t=Bloques-1; t>0; t--){
                    int p = ByteIntR(raw, offset+(4*t))^key;
                    r[Bloques-t-1] = p;
                    key = vuelta(vuelta(key)-vuelta(p));
            }
            r[Bloques-1] = ByteIntR(raw, offset);
            return IntByte(r);
            //16740556	
    }
    public static void decrypts(byte[] raw, final int offset, final int size) throws IOException
    {
        BlowfishEngine _decrypts;
        byte[] BLOWFISH_KEY ={(byte) 0x6b, (byte) 0x60, (byte) 0xcb, (byte) 0x5b,(byte) 0x82, (byte) 0xce, (byte) 0x90, (byte) 0xb1,(byte) 0xcc, (byte) 0x2b, (byte) 0x6c, (byte) 0x55,(byte) 0x6c, (byte) 0x6c, (byte) 0x6c, (byte) 0x6c};
        _decrypts = new BlowfishEngine();
        _decrypts.init(false, BLOWFISH_KEY);
        byte[] result = new byte[size];
        int count = size /8;

        for (int i=0; i<count;i++)
        {
                        _decrypts.processBlock(raw,offset + i*8,result,i*8);
        }
        System.arraycopy(result, 0, raw, offset, size);
    }
    static int ByteInt(byte[] ko, int off)
    {			
        int edx = (ko[off] &0xFF);
        edx |= (ko[1+off] & 0xFF) << 8;
        edx |= (ko[2+off] & 0xFF) << 16;
        edx |=  (ko[3+off] & 0xFF) << 24;
        return edx;
    }
    static int ByteIntR(byte[] ko, int off)
    {			
        int edx = (ko[off+3] &0xFF);
        edx |= (ko[off+2] & 0xFF) << 8;
        edx |= (ko[off+1] & 0xFF) << 16;
        edx |=  (ko[off] & 0xFF) << 24;
        return edx;		
    }
    static int vuelta(int edx)
    {
        byte[] uy = new byte[4];
        uy[0] = (byte) (edx & 0xFF);
        uy[1] = (byte) (edx >> 8 & 0xFF);
        uy[2] = (byte) (edx >> 16 & 0xFF);
        uy[3] = (byte) (edx >> 24 & 0xFF);
        return ByteIntR(uy,0);
    }
    static byte[] IntByte(int[] ji)
    {
        byte[] jo = new byte[ji.length * 4];
        for(int g=0; g<ji.length; g++){
            jo[(g*4)]   = (byte) (ji[g] & 0xFF);
            jo[(g*4)+1] = (byte) (ji[g] >> 8 & 0xFF);
            jo[(g*4)+2] = (byte) (ji[g] >> 16 & 0xFF);
            jo[(g*4)+3] = (byte) (ji[g] >> 24 & 0xFF);
        }
        byte[] ja = new byte[jo.length];
        for(int g=0;g<jo.length;g++){
        ja[g] = jo[jo.length-g-1];
        }
        return ja;
    }
    public static void appendChecksum(byte[] raw, final int offset, final int size)
    {
        long chksum = 0;
        int count = size-4;
        long ecx;
        int i;

        for (i = offset; i<count; i+=4)
        {
            ecx = raw[i] &0xff;
            ecx |= raw[i+1] << 8 &0xff00;
            ecx |= raw[i+2] << 0x10 &0xff0000;
            ecx |= raw[i+3] << 0x18 &0xff000000;

            chksum ^= ecx;
        }

        ecx = raw[i] &0xff;
        ecx |= raw[i+1] << 8 &0xff00;
        ecx |= raw[i+2] << 0x10 &0xff0000;
        ecx |= raw[i+3] << 0x18 &0xff000000;

        raw[i] = (byte) (chksum &0xff);
        raw[i+1] = (byte) (chksum >>0x08 &0xff);
        raw[i+2] = (byte) (chksum >>0x10 &0xff);
        raw[i+3] = (byte) (chksum >>0x18 &0xff);
    }
    public static boolean verifyChecksum(byte[] raw, final int offset, final int size)
    {
            // check if size is multiple of 4 and if there is more then only the checksum
            if ((size & 3) != 0 || size <= 4)
            {
                    return false;
            }

            long chksum = 0;
            int count = size-4;
            long check = -1;
            int i;

            for (i = offset; i<count; i+=4)
            {
                    check = raw[i] &0xff;
                    check |= raw[i+1] << 8 &0xff00;
                    check |= raw[i+2] << 0x10 &0xff0000;
                    check |= raw[i+3] << 0x18 &0xff000000;

                    chksum ^= check;
            }

            check = raw[i] &0xff;
            check |= raw[i+1] << 8 &0xff00;
            check |= raw[i+2] << 0x10 &0xff0000;
            check |= raw[i+3] << 0x18 &0xff000000;

            return check == chksum;
    }
    public byte[] decrypt(byte[] raw) throws IOException
    {
            byte[] result = new byte[raw.length];
            int count = raw.length /8;

            for (int i=0; i<count;i++)
            {
                    _decrypt.processBlock(raw,i*8,result,i*8);
            }

            return result;
    }
    public void decrypt(byte[] raw, final int offset, final int size) throws IOException
    {
            byte[] result = new byte[size];
            int count = size /8;

            for (int i=0; i<count;i++)
            {
                    _decrypt.processBlock(raw,offset + i*8,result,i*8);
            }
            // TODO can the crypt and decrypt go direct to the array
            System.arraycopy(result, 0, raw, offset, size);
    }

    public byte[] crypt(byte[] raw) throws IOException
    {
            int count = raw.length /8;
            byte[] result = new byte[raw.length];

            for (int i=0; i<count;i++)
            {
                    _crypt.processBlock(raw,i*8,result,i*8);
            }

            return result;
    }
    public void crypt(byte[] raw, final int offset, final int size) throws IOException
    {
        int count = size/8;
        byte[] result = new byte[size];

        for (int i=0; i<count;i++)
        {
            _crypt.processBlock(raw,offset + i*8,result,i*8);
        }
        // TODO can the crypt and decrypt go direct to the array
        System.arraycopy(result, 0, raw, offset, size);
    }
        
            //DEbug only
    public static String byteArrayToHexString(byte in[]) 
    {
        String rslt = "";
            String thes = "";
            for ( int iuo = 0 ; iuo < in.length ; iuo++ ) {
                int wtrf = in[iuo];
                if(wtrf < 0){
                        wtrf = 256+wtrf;
                }

                //rslt += " " + (in[iuo]);

                thes = Integer.toHexString(wtrf);
                if(thes.length() < 2){
                        thes = "0" + thes;
                }
                rslt += " " + thes;
            }
        return rslt.toUpperCase();
    } 
}
