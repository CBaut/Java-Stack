package com.codingdojo.javaoop.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
//		instantiate gorilla
		Gorilla rillaGo = new Gorilla();
//		throw 3 things
		rillaGo.throwSomething("paper bag");
		rillaGo.throwSomething("banana peel");
		rillaGo.throwSomething("tire");

//		eat bananas twice
		rillaGo.eatBananas();
		rillaGo.eatBananas();
		
//		climb once
		rillaGo.climb();
	}

}
