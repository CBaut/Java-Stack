package com.codingdojo.javaoop.objectmaster;

public class Wizard extends Human{

	public Wizard() {
//		default health 50
		this.setHealth(50);
//		default intelligence 8
		this.setIntelligence(8);
	}
//	heal(Human) - heal by wizard's intelligence
	public void heal(Human human) {
		human.updateHealth(this.getIntelligence());
		System.out.println("was healed by " + this.getIntelligence() + "!");
	}
//	fireball(Human) - decrease health by 3 * wizard's intelligence
	public void fireball(Human human) {
		int decreaseBy = 3 * this.getIntelligence();
		human.updateHealth(-decreaseBy);
		System.out.println("got burned for " + decreaseBy + " damage!");
	}
	

}
