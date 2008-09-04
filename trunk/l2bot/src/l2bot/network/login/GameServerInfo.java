/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.login;

/**
 *
 * @author carl
 */
public class GameServerInfo {
    
    public byte id;
    public String ip;
    public int port;
    public int players;
    public int maxplayers;
    public boolean pvp;
    public boolean online;
    public boolean test;
    public boolean brackets;
    
    
    public GameServerInfo(byte _id, String _ip,int _port,int _players, int _maxplayers, boolean _pvp, boolean _online,boolean _test,boolean _brackets){
        id = _id;
        ip=_ip;
        port=_port;
        players=_players;
        maxplayers=_maxplayers;
        pvp=_pvp;
        online=_online;
        test=_test;
        brackets=_brackets;
        
    }
    
    public GameServerInfo(byte[] gsi){
        id = gsi[0];
        
        ip = ((int)gsi[1] & 0xFF) + "." + ((int)gsi[2] & 0xFF) + "." + ((int)gsi[3] & 0xFF) + "." + ((int)gsi[4] & 0xFF);
        
        port = gsi[5] &0xff;
        port |= gsi[6] << 8 &0xff00;
        port |= gsi[7] << 0x10 &0xff0000;
        port |= gsi[8] << 0x18 &0xff000000;
        
        pvp = gsi[10] == 0x01;
        
        //players = unsignedByteToInt(gsi[11]) << 8;
        //players += unsignedByteToInt(gsi[12]) << 0;
        players =gsi[11] &0xff;
	players |= gsi[12] << 8 &0xff00;
        
        
        //maxplayers = unsignedByteToInt(gsi[13]) << 8;
        //maxplayers += unsignedByteToInt(gsi[14]) << 0;
        maxplayers =gsi[13] &0xff;
	maxplayers |= gsi[14] << 8 &0xff00;
        
        online = gsi[15] ==  0x01;
        
        test = gsi[19] > 0x03;
        
        brackets = gsi[20] == 0x01;
        
    }

    public static int unsignedByteToInt(byte b) {
    return (int) b & 0xFF;
    }
    
    @Override
    public String toString(){
        String g = "--------Game Server Info--------\n";
              g += "---   id:         " + id + "\n";
              g += "---   ip:         " + ip + "\n";
              g += "---   puerto:     " + port + "\n";
              g += "---   players:    " + players + "\n";
              g += "---   max players:" + maxplayers + "\n";
              g += "---   pvp:        " + pvp + "\n";
              g += "---   online:     " + online + "\n";
              g += "---   test:       " + test + "\n";
              g += "---   breakts:    " + brackets + "\n";
              g += "--------------------------------";              
              return g;
        
    }
}


