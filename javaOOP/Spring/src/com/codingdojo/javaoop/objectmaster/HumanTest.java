package com.codingdojo.javaoop.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human();
		human1.getHealth();
		Human human2 = new Human();
		human1.attack(human2);
		human1.getHealth();
		human2.getHealth();
	}

}
