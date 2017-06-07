package AbstractFactoryPattern.character;

import AbstractFactoryPattern.character.item.AbstractArmor;
import AbstractFactoryPattern.character.item.AbstractGlove;
import AbstractFactoryPattern.character.item.AbstractWeapon;
import AbstractFactoryPattern.character.item.Armor;
import AbstractFactoryPattern.character.item.Glove;
import AbstractFactoryPattern.character.item.Knife;
import AbstractFactoryPattern.character.item.Lance;

public class CharacterFactory extends AbstractCharacterFactory{
	public AbstractGlove createGlove () { return new Glove(); }
	public AbstractArmor createArmor() { return new Armor(); }
	public AbstractWeapon createLeftWeapon() { return new Lance(); }
	public AbstractWeapon createRightWeapon() { return new Knife();}
}