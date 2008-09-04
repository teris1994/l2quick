/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.puppet;
/*
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;*/

/**
 *
 * @author carl
 */


public class PShocket/* extends PuppetHandler implements Runnable */ {
   /* private ServerSocket ssocket;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;
    public boolean conectado;
    public PShocket()
    {
        try {
            ssocket = new ServerSocket(2106);
        } catch (IOException ex) {
            Logger.getLogger(PShocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Thread t;
        
    }
    
    public void run(){
        try {
            while(true){
                socket = ssocket.accept();
                System.out.println("Cliente conectado");
                conectado = true;
                salida = new DataOutputStream( socket.getOutputStream() );      
                salida.flush();

                entrada = new DataInputStream(socket.getInputStream());
                while(conectado){
                    byte[] buf = new byte[2];
                    entrada.read(buf);

                    int tama = ((int)buf[0] & 0xFF) + ((int)buf[1] & 0xFF)*256;

                    byte[] buf2 = new byte[tama];

                    entrada.read(buf2,2,tama -2);

                    try{
                        buf2[0] = buf[0];
                        buf2[1] = buf[1];
                    }catch(ArrayIndexOutOfBoundsException e){
                        if(socket.isConnected()){
                            paquete(null);
                            socket.close();
                            conectado = false;
                        }else
                        {
                            System.out.println("Desconectado");
                        }
                        return;
                    }
                    paquete(buf2);

                    //String mensaje = byteArrayToHexString(buf2);
                    //System.out.println("mensaje recivido");
                    
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Error");
        }
       
               
    }
    */
    
}
