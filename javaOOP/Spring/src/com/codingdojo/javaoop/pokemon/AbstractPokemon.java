package com.codingdojo.javaoop.pokemon;

public abstract class AbstractPokemon implements PokemonInterface{
//	[x] only implements createPokemon and pokemonInfo(Pokemon pokemon)
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon newPokemon = new Pokemon(name, health, type);
		return newPokemon;
	}
	public String pokemonInfo(Pokemon pokemon) {
		String info = pokemon.getName() + " - " + pokemon.getHealth() + " - " + pokemon.getType();
		return info;
	}
}
