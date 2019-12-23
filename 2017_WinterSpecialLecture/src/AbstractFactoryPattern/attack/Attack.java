package AbstractFactoryPattern.attack;

import AbstractFactoryPattern.character.Enemy;
import AbstractFactoryPattern.character.GameCharacter;
import Socket.Sender;

public abstract class Attack {
	
	protected int attackStrength;
	protected int characterAttackStrength;
	protected int characterAttackSpeed;
	
	protected Sender sender = new Sender();
	
	public Attack(int attackStrength, GameCharacter gameCharacter) {
		this.attackStrength = attackStrength;
		
		setCharacterAttackStrength(gameCharacter);
		setCharacterAttackSpeed(gameCharacter);
	}
	
	public abstract void execute(Enemy enemy);
	
	private void setCharacterAttackStrength(GameCharacter gameCharacter) {
		this.characterAttackStrength = gameCharacter.getTotalAttackStrength();
	}
	
	private void setCharacterAttackSpeed(GameCharacter gameCharacter) {
		this.characterAttackSpeed = gameCharacter.getTotalAttackSpeed();
	}
	
	public int getAllAttackStrength() { return attackStrength + characterAttackStrength; }
	public int getAllAttackSpeed() { return characterAttackSpeed; }
	
	protected AttackHandle getAttackHandle() {
		return new AttackHandle(this);
	}
}
