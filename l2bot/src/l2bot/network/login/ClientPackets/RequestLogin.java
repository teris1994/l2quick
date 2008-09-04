/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login.ClientPackets;

import java.math.BigInteger;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import l2bot.network.login.LoginCrypt;


/**
 *
 * @author carl
 */
public class RequestLogin extends ClientPacket{
    public RequestLogin(String user, String password,byte[] key, byte[] seid) throws NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] crypted = null;
        byte[] raw = getArray(user,password);
        //System.out.println(LoginCrypt.byteArrayToHexString(raw));
        BigInteger g = new BigInteger(unscrambleModulus(key));
        
        RSAPublicKey rsaKey;
 
        KeyFactory kfac = KeyFactory.getInstance("RSA");
        
        RSAPublicKeySpec kspec1 = new RSAPublicKeySpec(g, RSAKeyGenParameterSpec.F4);
        rsaKey = (RSAPublicKey)kfac.generatePublic(kspec1);


        
        
        try
        {
            Cipher rsaCipher = Cipher.getInstance("RSA/ECB/nopadding");
            
            rsaCipher.init(Cipher.DECRYPT_MODE, rsaKey);
            
            crypted = rsaCipher.doFinal(raw, 0x00, 0x80 );
        }
        catch (GeneralSecurityException e)
        {
                e.printStackTrace();
                return;
        }
        
        //writeC(0); //size
        //writeC(0); //size
        
        writeC(0); //id
        writeB(crypted);
        
        writeB(seid);
        
        byte[] fixed = {(byte)0x23,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x67,(byte)0x45,(byte)0x00,(byte)0x00,(byte)0xAB,(byte)0x89,(byte)0x00,(byte)0x00,(byte)0xEF,(byte)0xCD,(byte)0x00,(byte)0x00,(byte)0x08,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
        
        writeB(fixed);
        
        
        
        //writeD(0); //checksum
    }
    
    public byte[] getArray(String user,String pass){
        byte[] r = new byte[128];
        r[92] = 0x24;
        System.arraycopy(user.getBytes(), 0, r, 0x5E, Math.min(14,user.length()));
        System.arraycopy(pass.getBytes(), 0, r, 0x6C, Math.min(16,pass.length()));
        return r;
    }
    
            public static byte[] unscrambleModulus(byte[] unscrambledMod){		
		
		for (int i = 0; i < 0x40; i++){
            unscrambledMod[0x40 + i] = (byte) (unscrambledMod[0x40 + i] ^ unscrambledMod[i]);
        }
		
		for (int i = 0; i < 4; i++){
            unscrambledMod[0x0d + i] = (byte) (unscrambledMod[0x0d + i] ^ unscrambledMod[0x34 + i]);
        }
		
		for (int i = 0; i < 0x40; i++){
            unscrambledMod[i] = (byte) (unscrambledMod[i] ^ unscrambledMod[0x40 + i]);
        }
		
		for (int i = 0; i < 4; i++){
            byte temp = unscrambledMod[0x00 + i];
            unscrambledMod[0x00 + i] = unscrambledMod[0x4d + i];
            unscrambledMod[0x4d + i] = temp;
        }
		
		if (new BigInteger(unscrambledMod).signum()==-1)
        {
            byte[] temp = new byte[0x81];
            System.arraycopy(unscrambledMod, 0, temp, 1, 0x80);
            temp[0]=0x00;
            unscrambledMod = temp;
        }
		
		return unscrambledMod;
	}
    
    
    
    
}
