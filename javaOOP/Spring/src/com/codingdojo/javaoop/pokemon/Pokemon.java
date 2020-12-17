package com.codingdojo.javaoop.pokemon;

public class Pokemon {
//	[x] name, health, and type member variables.
	private String name = "";
	private int health = 0;
	private String type = "";
//	[x] a count static variable that keeps the number of Pokemon created in the program.
	private static int count = 0;
	
//	[x] a constructor class to set the instance's name, health, and type on creation
	public Pokemon(String name, int health, String type) {
		count++;
		this.setName(name);
		this.setHealth(health);
		this.setType(type);
	}
//	[x] getters and setters for each member variable.
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		System.out.println("This Pokemon's name is: " + this.name);
		return this.name;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		System.out.println(this.name + "'s health is: " + this.health);
		return this.health;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		System.out.println(this.name + "'s type is: " + this.type);
		return this.type;
	}
	public int getCount() {
		System.out.println("Total count of Pokemon is: " + count);
		return count;
	}
	//	[x] void attackPokemon(Pokemon pokemon): This method lowers the attacked Pokemon's health by 10
	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth() - 10);
		System.out.println(pokemon.getName() + " was attacked and lost 10 health!");
		pokemon.getHealth();
	}
}
