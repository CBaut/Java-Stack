package com.codingdojo.javaoop.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {}
	
//	throwSomething() - print out a message that the gorilla has thrown something as well as decrease energy level by 5
	public void throwSomething(String thing) {
		System.out.println("Gorilla threw a " + thing);
		this.updateEnergy(-5);
		this.displayEnergy();
	}
//	eatBananas() - print a message that gorilla is satisfied and increase energy by 10
	public void eatBananas() {
		System.out.println("Gorilla ate some bananas and is satisfied!");
		this.updateEnergy(10);
		this.displayEnergy();
	}
//	climb() - print message gorilla has climbed a tree and decrease energy by 10
	public void climb() {
		System.out.println("Gorill has climbed a tree.");
		this.updateEnergy(-10);
		this.displayEnergy();
	}
}
