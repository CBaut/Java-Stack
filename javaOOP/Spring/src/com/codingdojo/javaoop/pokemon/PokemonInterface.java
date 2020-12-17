package com.codingdojo.javaoop.pokemon;

public interface PokemonInterface {
//	create interface for the following methods:
	Pokemon createPokemon(String name, int health, String type); // creates and returns Pokemon
	String pokemonInfo(Pokemon pokemon); // returns a String with the name, health, and type of the pokemon.
	void listPokemon(); // list all the pokemon names that you have in pokedex
}
