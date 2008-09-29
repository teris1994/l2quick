/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login;

/**
 *
 * @author carl
 */
import java.io.*;
import java.net.*;
import l2bot.pj.Pj;

public class LShocket extends LoginHandler implements Runnable {
	private int puerto;
	private String host;
	
        public boolean Conectado;
        
        
	private Socket Login;
	
        private DataOutputStream salida;
        private DataInputStream entrada;
        


	public LShocket(int _lpuerto, String _Login,Pj l){
            this.pj = l;
            puerto = _lpuerto;
            host = _Login;
            
            try{
		Login = new Socket(host,puerto);
		
                salida = new DataOutputStream( Login.getOutputStream() );      
                salida.flush();

                entrada = new DataInputStream(Login.getInputStream());
            }catch ( EOFException excepcionEOF ) {
                pj.getLogger().logError("El cliente termino la conexión" );
            }
            catch ( IOException excepcionES ) {
                pj.getLogger().logError( "Error: imposible conectar al servidor" );
                return;
            }
            this.estado = LoginHandler.LoginStatus.WF_INIT;
            Conectado = true;
            Thread hilo = new Thread(this);
            hilo.start();
       
	 }
	
    public void run()
    {
		try{
			while (Conectado && !error)
			{
				//System.out.println("hola");
				//System.out.println(lentrada.readUTF());				
				byte[] buf = new byte[2];
				entrada.read(buf);
				
				int tama = Sbyte2int(buf[0]) + Sbyte2int(buf[1])*256;
				
				byte[] buf2 = new byte[tama];
				
				entrada.read(buf2,2,tama -2);
				
                                try{
                                    buf2[0] = buf[0];
                                    buf2[1] = buf[1];
                                }catch(ArrayIndexOutOfBoundsException e){
                                    if(Login.isConnected()){
                                        Paquete(null);
                                        Login.close();
                                        Conectado = false;
                                        onDisconect(false,null,null);
                                    }else
                                    {
                                        pj.getLogger().logError("Desconectado");
                                    }
                                    return;
                                }
				Paquete(buf2);
                                
				//String mensaje = byteArrayToHexString(buf2);
				//System.out.println("S->C" + mensaje);
			}
		}
		catch (ConnectException e){
			pj.getLogger().logError("Error: Error de conexion");
		}
                catch (IOException e){
			pj.getLogger().logError("Error: Error de comunicacion");
		}
   } 
   
    @Override
    public void SendPacketToLogin(byte[] raw){
        try{
            salida.write(raw);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void desconectar(boolean todoOk, GameServerInfo server, byte[] key){
        onDisconect(todoOk,server, key);
        Conectado = false;
       /* try {
            Login.close();
        } catch (IOException ex) {
            Logger.getLogger(LShocket.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    
    }
    
    public void onDisconect(boolean todoOk,GameServerInfo Server, byte[] key){};

   
   
	static String byteArrayToHexString(byte in[]) 
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
	private int Sbyte2int(byte sb){
			int wtrf = sb;
			if(wtrf < 0){
				wtrf = 256+wtrf;
			}
			return wtrf;
	}

}