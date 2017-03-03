package AbstractFactoryPattern.attack;

import java.io.Serializable;
import java.util.Date;

import AbstractFactoryPattern.util.Observer;

public class AttackHandle extends Thread implements Serializable, Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3561624813844381494L;
	private int attackStrength;
	private int attackSpeed;
	
	public int getAttackStrength() { return attackStrength; };
	public int getAttackSpeed() { return attackSpeed; };
	
	public boolean attackStatus;
	
	public final boolean ATTACK_SUCCESS = true;
	public final boolean ATTACK_FAIL = false;
	
	public void setAttackStrength(int attackStrength) { this.attackStrength = attackStrength; };
	public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; };
	
	public AttackHandle(Attack attack) {
		setAttackStrength(attack.getAllAttackStrength());
		setAttackSpeed(attack.getAllAttackSpeed());
	}
	
	public boolean isAttackStatus(){
		return this.attackStatus;
	}
	public void run() {
		long start = System.currentTimeMillis();
		
		while(!Thread.currentThread().isInterrupted()) {			
			try {
				Thread.sleep(100);
			
				if(System.currentTimeMillis() - start >= this.getAttackSpeed() * 2) {
					attackStatus = ATTACK_SUCCESS;
					this.interrupt();
				}
				
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	@Override
	public void setActionType(int type) {
		if (type == 57) {
			attackStatus = ATTACK_FAIL;
			this.interrupt();
		} else {
			System.out.println("Defense Failed");
		}
	}
}
