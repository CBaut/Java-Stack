package com.codingdojo.javaoop.zookeeper;

public class Bat extends Mammal {

	public Bat() {
//	energyLevel 300
		this.setEnergy(300);
	}
//	fly() - print sound and decrease energy by 50
	public void fly() {
		System.out.println("VOOSH!");
		this.updateEnergy(-50);
		this.displayEnergy();
	}
//	eatHumans() - print... nvm.. increase energy by 25
	public void eatHumans() {
		System.out.println("OM NOM NOM NOM!");
		this.updateEnergy(25);
		this.displayEnergy();
	}
//	attackTown() - print sound of town on fire and decrease energy by 100
	public void attackTown() {
		System.out.println("AHHHHHHHHHHHH");
		this.updateEnergy(-100);
		this.displayEnergy();
	}
}
