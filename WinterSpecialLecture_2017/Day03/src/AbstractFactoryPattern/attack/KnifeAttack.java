package AbstractFactoryPattern.attack;

import AbstractFactoryPattern.character.Enemy;
import AbstractFactoryPattern.character.GameCharacter;

public class KnifeAttack extends SingleAttack {

	public KnifeAttack(GameCharacter gameCharacter) {
		super(10, gameCharacter);
	}
	
	public void execute(Enemy enemy) {
		sender.send(enemy.getIP(), getAttackHandle());
	}
}
