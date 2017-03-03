package AbstractFactoryPattern.attack;

import AbstractFactoryPattern.character.GameCharacter;

public abstract class MultipleAttack extends Attack{
	public MultipleAttack(int attackStrength, GameCharacter gameCharacter) {
		super(attackStrength, gameCharacter);
	}
}
