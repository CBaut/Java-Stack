package com.codingdojo.javaoop.objectmaster;

public class Samurai extends Human{
	static int count = 0;
	public Samurai() {
//		default health 200
		this.setHealth(200);
		count++;
	}
//	deathBlow(Human) - kills other human, but reduce samurai by half
	public void deathBlow(Human human) {
		System.out.println("deathBlow has been performed...");
		human.setHealth(0);
		int half = this.getHealth() / 2;
		this.setHealth(half);
	}
//	meditate() - health samurai for half current health
	public void meditate() {
		System.out.println("meditating under a waterfall...");
		int half = this.getHealth() / 2;
		this.updateHealth(half);
	}
//	howMany() - return the total current number of Samurai
	public int howMany() {
		if(count > 1) {
			System.out.println("there are " + count + " of us!");
		}
		else {
			System.out.println("there is " + count + " of us!");
		}
		return count;
	}

}
