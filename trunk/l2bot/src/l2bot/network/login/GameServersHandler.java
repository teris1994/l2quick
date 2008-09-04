/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login;

/**
 *
 * @author carl
 */
public class GameServersHandler {
    public GameServerInfo[] gameServers;
    public int ultimoServidor;
    
    public GameServersHandler(byte[] raw){
        
        
       int numeroServidores = raw[3];
       ultimoServidor = raw[4];
       
       gameServers = new GameServerInfo[numeroServidores];
       
       for(int i = 1; i <= numeroServidores;i++){
           byte[] h = new byte[21];
           System.arraycopy(raw, 5 + (i-1)*21, h, 0, 21);
           
           gameServers[i-1] = new GameServerInfo(h);
           //System.out.println(gameServers[i-1].toString());
           
       }
    }

}
