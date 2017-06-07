package AbstractFactoryPattern.character.item;

public class AbstractGlove {

	protected int attackSpeed;
	protected int attackStrength;
	
	public AbstractGlove(int attackSpeed, int attackStrength) {	
		this.attackSpeed = attackSpeed;
		this.attackStrength = attackStrength;
	}
	
	public int getAttackSpeed() { return attackSpeed; }
	public int getAttackStrength() {return attackStrength; }
}
