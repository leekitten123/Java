package AbstractFactoryPattern;

import AbstractFactoryPattern.attack.AttackRegistry;
import AbstractFactoryPattern.attack.FireBallAttack;
import AbstractFactoryPattern.attack.KnifeAttack;
import AbstractFactoryPattern.character.AbstractCharacterFactory;
import AbstractFactoryPattern.character.CharacterFactory;
import AbstractFactoryPattern.character.Enemy;
import AbstractFactoryPattern.character.GameCharacter;
import AbstractFactoryPattern.util.KeyListener;

public class AbstractFactoryPattern {

	public static void main(String[] args) {

		AbstractCharacterFactory characterFactory = new CharacterFactory();
		GameCharacter sanguk = characterFactory.createCharacter();
		
		sanguk.setEnemy(new Enemy("Junha"));
		
		AttackRegistry.registerAttack(49, new KnifeAttack(sanguk));
		AttackRegistry.registerAttack(50, new FireBallAttack(sanguk));
	}
}