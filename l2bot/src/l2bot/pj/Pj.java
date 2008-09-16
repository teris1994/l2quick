/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj;

import l2bot.pj.cosas.Character;
import java.util.Map;
import javolution.util.FastMap;
import l2bot.interfaz.PjInter;
import l2bot.Main;
import l2bot.network.game.GShocket;
import l2bot.network.login.GameServerInfo;
import l2bot.network.login.LShocket;
import l2bot.pj.handlers.*;

/**
 *
 * @author carl
 */
public class Pj /*extends Character*/ {
    //maps
    public Map<Integer,Character> players = new FastMap<Integer,Character>();
    public Map<Integer,Character> npcs = new FastMap<Integer,Character>();
    public Map<Integer,Character> chars = new FastMap<Integer,Character>();
    //variables del sistema
    public int id;
    
    public int sessionId;
    
    public int clanId;  
     
    
    //cosas
    public PjInter inter;
    
    public LShocket loginSocket;
    public GShocket gameSocket;
    
    public byte[] playkey;
    
    //Informacion para el login
    public PjInfo connectionInfo;
    
    
    
    //informacion del pj
    public String nombre = "?";  
    public String title = "?";
    
    public byte sexo = -1; //0 hombre, 1 mujer, -1 sin definir aun
    
    public Race raza = null;
    public ClassId clase = null;
    
    public int x;
    public int y;
    public int z;
    
    public double hp = -1;
    public double maxHp = -1;
    
    public double mana = -1;
    public double maxMana = -1;
    
    public int cp = -1;
    public int maxCp = -1;
    
    public int lvl = -1;
    public long exp = -1;
    
    public int sp = -1;
    
    public int karma = -1;
    
    public int INT = -1;
    public int STR = -1;
    public int CON = -1;
    public int MEN = -1;
    public int DEX = -1;
    public int WIT = -1;
    
    public int cielo = -1;
    
    //handlers
    public AbnormalStatusHandler abnormalStatusHandler = new AbnormalStatusHandler();
    public CharSelectHandler charSelectHandler = new CharSelectHandler(this);
    public PartyHandler partyHandler = new PartyHandler();
    public InventoryHandler inventoryHandler;
    public DoorHandler doorHandler = new DoorHandler();
    
    
    public Pj(String Name){
        connectionInfo = new PjInfo(Name);
        
        
        inter =  new PjInter(Name);
        Main.g.makePJ(inter);
        loginSocket = new LShocket(connectionInfo.port,connectionInfo.host,inter.l){
            @Override
            public void onDisconect(boolean todoOk,GameServerInfo server,byte[] key){
                //loginSocket = null;
                if(todoOk){
                    conectarAlGs(server);
                    playkey = key;
                }
            }
        };
        loginSocket.setLoginInfo(connectionInfo.user, connectionInfo.pass,connectionInfo.gss);
        //loginSocket = new LShocket(2106,"127.0.0.1");
    }
    
    
    public void conectarAlGs(GameServerInfo server){
        gameSocket = new GShocket(server.ip,server.port,inter.l);
        gameSocket.pj = this;
        inventoryHandler = new InventoryHandler(inter.inv);
    }
           
    
    
    

}
