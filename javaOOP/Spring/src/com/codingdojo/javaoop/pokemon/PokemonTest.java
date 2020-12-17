package com.codingdojo.javaoop.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle", 100, "Water");
		Pokemon charmander = new Pokemon("Charmander", 100, "Fire");
		squirtle.attackPokemon(charmander);
		charmander.attackPokemon(squirtle);
		Pokedex newDex = new Pokedex();
		newDex.add(squirtle);
		newDex.add(charmander);
		newDex.listPokemon();
	}

}
