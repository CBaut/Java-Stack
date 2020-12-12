package com.codingdojo.javaoop.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		instantiate Bat
		Bat ahh = new Bat();
//		attack 3 towns
		ahh.attackTown();
		ahh.attackTown();
		ahh.attackTown();
//		eat 2 humans
		ahh.eatHumans();
		ahh.eatHumans();
//		fly twice
		ahh.fly();
		ahh.fly();
		ahh.displayEnergy();
	}

}
