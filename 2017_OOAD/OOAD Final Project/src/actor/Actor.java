package actor;

import pos.MainSystem;

public class Actor {

	MainSystem mainSystem;
	
	String name;
	
	public Actor (String name, MainSystem mainSystem) {
		
		this.name = name;
		this.mainSystem = mainSystem;
	}
}
