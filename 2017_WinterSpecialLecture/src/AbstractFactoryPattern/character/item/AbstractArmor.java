package AbstractFactoryPattern.character.item;

import AbstractFactoryPattern.attack.Attack;

public class AbstractArmor {
	
	protected int defense;
	
	public AbstractArmor(int defense) {
		this.defense = defense ;
	}
	
	public int getDefense() { return defense; }
}