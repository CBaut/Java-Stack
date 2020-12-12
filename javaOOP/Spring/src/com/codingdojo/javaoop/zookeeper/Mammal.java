package com.codingdojo.javaoop.zookeeper;

public class Mammal {
//	energyLevel
//	private: only access from within the class
	private int energyLevel;
	
//	this is constructor
	public Mammal() {
		this.energyLevel = 100;
	}
//	displayEnergy() - print and return energyLevel
	public int displayEnergy() {
		System.out.println("Energy level: " + energyLevel);
		return energyLevel;
	}
	public void updateEnergy(int value) {
		this.energyLevel += value;
	}
	public int getEnergy() {
		return this.energyLevel;
	}
	public void setEnergy(int energy) {
		this.energyLevel = energy;
	}
}
