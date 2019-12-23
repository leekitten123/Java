package AbstractFactoryPattern.character;

import kookmin.game.server.Server;

public class Enemy {

	private String ip ;
	private String name;
	
	public Enemy(String name) {
		this.name = name;
		this.ip = Server.getServerInstance().getUserInfo(name);
	}
	
	
	public String getIP() { return ip; }
}
