package com.codingdojo.javaoop.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human();
		System.out.println("human1's health is: " + human1.getHealth());
		Human human2 = new Human();
		human1.attack(human2);
		System.out.println("human1's health is: " + human1.getHealth());
		System.out.println("human2's health is: " + human2.getHealth());
//		Wizard time
		Wizard wizard1 = new Wizard();
		wizard1.heal(human2);
		System.out.println("human2's health is: " + human2.getHealth());
		wizard1.fireball(human1);
		System.out.println("human1's health is: " + human1.getHealth());
//		Ninja time
		Ninja ninja1 = new Ninja();
		ninja1.steal(wizard1);
		System.out.println("wizard1's health is: " + wizard1.getHealth());
		System.out.println("ninja1's health is: " + ninja1.getHealth());
		ninja1.runAway();
		System.out.println("ninja1's health is: " + ninja1.getHealth());
//		Samurai time
		Samurai samurai1 = new Samurai();
		samurai1.deathBlow(wizard1);
		System.out.println("wizard1's health is: " + wizard1.getHealth());
		System.out.println("samurai1's health is: " + samurai1.getHealth());
		samurai1.meditate();
		System.out.println("samurai1's health is: " + samurai1.getHealth());
		Samurai samurai2 = new Samurai();
		samurai1.howMany();
	}

}
