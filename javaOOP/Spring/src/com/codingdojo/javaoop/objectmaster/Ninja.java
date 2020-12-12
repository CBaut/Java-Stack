package com.codingdojo.javaoop.objectmaster;

public class Ninja extends Human {

	public Ninja() {
//		default stealth 10
		this.setStealth(10);
	}
	public void steal(Human human) {
//		decrease human's health by ninja's stealth and adds to ninja's stealth
		int stealAmount = this.getStealth();
		human.updateHealth(-stealAmount);
		this.updateStealth(stealAmount);
	}
//	runAway() - decrease ninja's health by 10
	public void runAway() {
		System.out.println("Ninja has fled the scene!");
		this.updateHealth(-10);
	}

}
