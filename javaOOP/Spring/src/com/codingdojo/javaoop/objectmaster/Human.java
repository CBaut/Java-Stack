package com.codingdojo.javaoop.objectmaster;

public class Human {
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;
	
	public Human() {
//		strength, stealth, and intelligence default 3
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
//		health default 100
		this.health = 100;
	}
	
	public void attack(Human human) {
//		reduce health of attacked human by the strength of current human
		human.health -= this.strength;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		System.out.println("Health is: " + this.health);
		return this.health;
	}
	public void updateHealth(int health) {
		this.health += health;
		System.out.println("Health is updated... " + this.getHealth());
	}
}
