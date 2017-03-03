package AbstractFactoryPattern.attack;

import AbstractFactoryPattern.character.Enemy;
import AbstractFactoryPattern.character.GameCharacter;

public class FireBallAttack extends MultipleAttack{

	public FireBallAttack(GameCharacter gameCharacter) {
		super(50, gameCharacter);
	}
	
	public void execute(Enemy enemy) {
		sender.send(enemy.getIP(), getAttackHandle());
	}
}
