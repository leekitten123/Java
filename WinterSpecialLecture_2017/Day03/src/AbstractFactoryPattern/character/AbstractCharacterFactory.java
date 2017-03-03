package AbstractFactoryPattern.character;

import AbstractFactoryPattern.character.item.AbstractArmor;
import AbstractFactoryPattern.character.item.AbstractGlove;
import AbstractFactoryPattern.character.item.AbstractWeapon;

public abstract class AbstractCharacterFactory {

	public GameCharacter createCharacter() {
		
		AbstractGlove glove = this.createGlove();
		AbstractArmor armor = this.createArmor();
		AbstractWeapon leftKnife = this.createLeftWeapon();
		AbstractWeapon rightKnife = this.createRightWeapon();
		
		return GameCharacter.createGameCharacter(glove, armor, leftKnife, rightKnife);
	}
	
	public abstract AbstractGlove createGlove();
	public abstract AbstractArmor createArmor();
	public abstract AbstractWeapon createLeftWeapon();
	public abstract AbstractWeapon createRightWeapon();
}