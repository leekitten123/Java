package kookmin.game.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {
	
	private volatile static Server server;
	
	private UserManagerService client;
	private UserManager service;
	
	private Server(){
		client = new UserManagerService();
		service = client.getUserManagerPort();
	}
	
	public synchronized static Server getServerInstance(){
		if(server == null){
			server = new Server();
		}
		return server;
	}
	
	public void register(String userName){


			service.setUser(userName, "10.30.119.255");
		
	}
	
	public String getUserInfo(String userName){
		return service.getUser(userName);
	}
	
	public void removeUserInfo(String userName){
		service.removeUser(userName);
	}
}
