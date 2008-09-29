/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.puppet;

/**
 *
 * @author carl
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

/*
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;*/
import java.net.Socket;
//import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import l2bot.network.login.LoginCrypt;


public class PGameSocket extends PuppetGamePacketsHandler implements Runnable {
    
    private ServerSocket ssocket;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;
    public boolean conectado;
    public PGameSocket()
    {
        try {
            ssocket = new ServerSocket(7777);
            //System.out.println("sdasdasdasd");
        }catch (java.net.BindException ex){
            System.out.println("Ya hay un programa escuchando el puerto 7777, por favor, cierra ese programa y reinicia l2quick si quieres usar las funciones IG");
        } catch (IOException ex) {
            Logger.getLogger(PShocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread hilo = new Thread(this);
        hilo.start();       
    }
    
    public void run(){
        try {
            while(true){
                System.out.println("esperando conexion");
                socket = ssocket.accept();
                System.out.println("Cliente conectado");
                conectado = true;
                salida = new DataOutputStream( socket.getOutputStream() );      
                salida.flush();
                entrada = new DataInputStream(socket.getInputStream());
                while(socket.isConnected() && !socket.isClosed()){
                    byte[] buf = new byte[2];
                    entrada.read(buf);

                    int tama = (buf[0] & 0xFF) + (buf[1] & 0xFF)*256;

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
                    //System.out.println("C->S" + LoginCrypt.byteArrayToHexString(buf2));
                    paquete(buf2);
                }
            }
                
            
        } catch (IOException ex) {
            System.out.println("Error");
        }      
    }
    
    @Override
    public void sendToClient(byte[] raw){
        try {
            salida.write(raw);
            //System.out.println(LoginCrypt.byteArrayToHexString(raw)); 
        } catch (IOException ex) {
            Logger.getLogger(PShocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
