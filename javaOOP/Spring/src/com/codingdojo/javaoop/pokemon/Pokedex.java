package com.codingdojo.javaoop.pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
//	need attribute myPokemons
	private ArrayList<Pokemon> myPokemons;
	
	public Pokedex() {
//		empty Pokedex
		this.myPokemons = new ArrayList<Pokemon>();
		System.out.println("Successfully created new Pokedex");
	}
	public void add(Pokemon pokemon) {
		myPokemons.add(pokemon);
		System.out.println(pokemon.getName() + " was successfully added to the Pokedex.");
	}
//	implements listPokemon()
	@Override
	public void listPokemon() {
		for(Pokemon mon : myPokemons) {
			System.out.println(this.pokemonInfo(mon));
		}
	}
}
