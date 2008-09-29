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
package l2bot.network.puppet.serverpackets;

//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.List;

//import javolution.util.FastList;
//import net.sf.l2j.loginserver.GameServerTable;
//import net.sf.l2j.loginserver.L2LoginClient;
//import net.sf.l2j.loginserver.GameServerTable.GameServerInfo;
//import net.sf.l2j.loginserver.gameserverpackets.ServerStatus;

/**
 * ServerList
 * Format: cc [cddcchhcdc]
 *
 * c: server list size (number of servers)
 * c: ?
 * [ (repeat for each servers)
 * c: server id (ignored by client?)
 * d: server ip
 * d: server port
 * c: age limit (used by client?)
 * c: pvp or not (used by client?)
 * h: current number of players
 * h: max number of players
 * c: 0 if server is down
 * d: 2nd bit: clock
 *    3rd bit: wont dsiplay server name
 *    4th bit: test server (used by client?)
 * c: 0 if you dont want to display brackets in front of sever name
 * ]
 *
 * Server will be considered as Good when the number of  online players
 * is less than half the maximum. as Normal between half and 4/5
 * and Full when there's more than 4/5 of the maximum number of players
 */
public final class ServerList extends ServerBasePacket
{
	//private List<ServerData> _servers;
	//private int _lastServer;
//
	//class ServerData
	//{
		//protected String _ip;
		//protected int _port;
		//protected boolean _pvp;
		//protected int _currentPlayers;
		//protected int _maxPlayers;
		//protected boolean _testServer;
		//protected boolean _brackets;
		//protected boolean _clock;
		//protected int _status;
		//protected int _serverId;
//
		//ServerData(String pIp, int pPort, boolean pPvp, boolean pTestServer, int pCurrentPlayers,
				//int pMaxPlayers, boolean pBrackets, boolean pClock, int pStatus, int pServer_id)
		//{
			//_ip = pIp;
			//_port = pPort;
			//_pvp = pPvp;
			//_testServer = pTestServer;
			//_currentPlayers = pCurrentPlayers;
			//_maxPlayers = pMaxPlayers;
			//_brackets = pBrackets;
			//_clock = pClock;
			//_status = pStatus;
			//_serverId = pServer_id;
		//}
	//}

	//public ServerList(L2LoginClient client)
	//{
		//_servers = new FastList<ServerData>();
		//_lastServer = client.getLastServer();
		//for (GameServerInfo gsi : GameServerTable.getInstance().getRegisteredGameServers().values())
		//{
			//if (gsi.getStatus() == ServerStatus.STATUS_GM_ONLY && client.getAccessLevel() > 0)
			//{
				//// Server is GM-Only but you've got GM Status
				//addServer(client.usesInternalIP() ? gsi.getInternalHost() : gsi.getExternalHost(), gsi.getPort(), gsi.isPvp(), gsi.isTestServer(), gsi.getCurrentPlayerCount(), gsi.getMaxPlayers(), gsi.isShowingBrackets(), gsi.isShowingClock(), gsi.getStatus(), gsi.getId());
			//}
			//else if (gsi.getStatus() != ServerStatus.STATUS_GM_ONLY)
			//{
				//// Server is not GM-Only
				//addServer(client.usesInternalIP() ? gsi.getInternalHost() : gsi.getExternalHost(), gsi.getPort(), gsi.isPvp(), gsi.isTestServer(), gsi.getCurrentPlayerCount(), gsi.getMaxPlayers(), gsi.isShowingBrackets(), gsi.isShowingClock(), gsi.getStatus(), gsi.getId());
			//}
			//else
			//{
				//// Server's GM-Only and you've got no GM-Status
				//addServer(client.usesInternalIP() ? gsi.getInternalHost() : gsi.getExternalHost(), gsi.getPort(), gsi.isPvp(), gsi.isTestServer(), gsi.getCurrentPlayerCount(), gsi.getMaxPlayers(), gsi.isShowingBrackets(), gsi.isShowingClock(), ServerStatus.STATUS_DOWN, gsi.getId());
			//}
		//}
	//}
//
	//public void addServer(String ip, int port, boolean pvp, boolean testServer, int currentPlayer,
			//int maxPlayer, boolean brackets, boolean clock, int status, int server_id)
	//{
		//_servers.add(new ServerData(ip, port, pvp, testServer, currentPlayer, maxPlayer, brackets,
				//clock, status, server_id));
	//}
//

	public void write()
	{
                writeC(0x4a);
                writeC(0);
            
		writeC(0x04);
		writeC(1); //size
		writeC(1); //last
		
                writeC(1); // server id

                writeC(127);   //ip
                writeC(0);
                writeC(0);
                writeC(1);
                
                writeD(7777);
                writeC(0x00); // age limit
                writeC(0); //pvp
                writeH(0);
                writeH(10);
                writeC(1);

                writeD(0);
                writeC(0);
	}
}
