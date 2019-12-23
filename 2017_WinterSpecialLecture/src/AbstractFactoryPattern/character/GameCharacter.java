package AbstractFactoryPattern.character;

import java.util.ArrayList;
import java.util.List;

import AbstractFactoryPattern.attack.AttackHandle;
import AbstractFactoryPattern.attack.AttackRegistry;
import AbstractFactoryPattern.character.item.AbstractArmor;
import AbstractFactoryPattern.character.item.AbstractGlove;
import AbstractFactoryPattern.character.item.AbstractWeapon;
import AbstractFactoryPattern.util.KeyListener;
import AbstractFactoryPattern.util.Observer;
import Socket.Receiver;
import Socket.Sender;
import kookmin.game.server.Server;

public class GameCharacter implements Observer{
	
	private volatile static GameCharacter character = null;
	
	private Enemy enemy;
	
	private AbstractGlove glove;
	private AbstractArmor armor;
	private List<AbstractWeapon> weapon = new ArrayList<AbstractWeapon>();
	protected int totalDefense;
	protected int totalAttackSpeed;
	protected int totalAttackStrength;
	
	private final int LEFT = 0;
	private final int RIGHT = 1;
	
	private Receiver receiver;
	
	private KeyListener listener;
	
	protected int health = 1000;
	
	public static synchronized GameCharacter createGameCharacter(AbstractGlove glove, AbstractArmor armor, AbstractWeapon leftWeapon, AbstractWeapon rightWeapon) {
		if(character==null){
			setItems(glove, armor, leftWeapon, rightWeapon);
			calculateStat(glove, armor);
			runReceiver();
			Server.getServerInstance().register("sanguk");
			System.out.println("ip: s" + Server.getServerInstance().getUserInfo("sanguk"));
			character.listener = new KeyListener();
			character.listener.registerObserver(character);
			character.listener.start();
		}
		
		return character;
	}

	public void setListener(KeyListener listener){
		this.listener = listener;
	}
	public void setEnemy(Enemy enemy){
		this.enemy = enemy;
	}
	private static void runReceiver() {
		character.receiver = new Receiver();		
		character.receiver.setCharacter(character);
		character.receiver.start();
	}

	private static void calculateStat(AbstractGlove glove, AbstractArmor armor) {
		character.totalDefense = armor.getDefense();
		character.totalAttackSpeed = character.weapon.get(character.LEFT).getAttackSpeed() + character.weapon.get(character.RIGHT).getAttackSpeed() + glove.getAttackSpeed();
		character.totalAttackStrength = character.weapon.get(character.LEFT).getAttackStrength() + character.weapon.get(character.RIGHT).getAttackStrength() + glove.getAttackStrength();
	}

	private static void setItems(AbstractGlove glove, AbstractArmor armor, AbstractWeapon leftWeapon,
			AbstractWeapon rightWeapon) {
		character = new GameCharacter();
		character.glove = glove;
		character.armor = armor;
		character.weapon.add(leftWeapon);
		character.weapon.add(rightWeapon);
	}
	
	public int getTotalDefense() { return totalDefense; }
	public int getTotalAttackSpeed() { return totalAttackSpeed; }
	public int getTotalAttackStrength() { return totalAttackStrength; }
	
	public Enemy getEnemy() { return enemy; }
	
	public void attack(int type) {
		if(AttackRegistry.getAttack(type)!=null)
			this.weapon.get(0).attack(this.enemy, AttackRegistry.getAttack(type));
	}
	
	public void defense(AttackHandle attackHandle) {
		System.out.println("Name : " + attackHandle.getName());
		System.out.println("Speed : " + attackHandle.getAttackSpeed());
		System.out.println("Strength : " +attackHandle.getAttackStrength());
		
		
		try {
			this.listener.registerObserver(attackHandle);
			attackHandle.start();
			attackHandle.join();
			this.listener.unregisterObserver(attackHandle);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(attackHandle.isAttackStatus()){
			health -= attackHandle.getAttackStrength();
			System.out.println("you damaged!! Current HP: " + health + "!!");
			if(health <= 0) {
				System.out.println("You dead!");
				System.exit(0);
			}
		}else{
			System.out.println("you defensed!!!");
		}
		
	}

	@Override
	public void setActionType(int type) { this.attack(type); }
}