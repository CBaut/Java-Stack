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
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void updateHealth(int health) {
		this.health += health;
	}
	public int getIntelligence() {
		return this.intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public void updateIntelligence(int intelligence) {
		this.intelligence += intelligence;		
	}
	public int getStrength() {
		return this.strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void updateStrength(int strength) {
		this.strength += strength;
	}
	public int getStealth() {
		return this.stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public void updateStealth(int stealth) {
		this.stealth += stealth;
	}
}
