package AbstractFactoryPattern.character.item;

import AbstractFactoryPattern.attack.Attack;
import AbstractFactoryPattern.character.Enemy;

public class AbstractWeapon {
	
	protected int attackSpeed;
	protected int attackStrength;
	
	public AbstractWeapon(int attackSpeed, int attackStrength) {
		this.attackSpeed = attackSpeed;
		this.attackStrength = attackStrength;
	}
	
	public int getAttackSpeed() { return attackSpeed; }
	public int getAttackStrength() { return attackStrength; }
	
	public void attack(Enemy enemy, Attack attack){
		attack.execute(enemy);
	}
	
}
