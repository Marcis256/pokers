package com.marcis.pokers;

import com.marcis.pokers.model.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokersApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(PokersApplication.class, args);
		System.out.println("Hi!!");
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		Deck playerDeck = new Deck();
		Deck opponentDeck = new Deck();
		Deck tableDeck = new Deck();
		
		playerDeck.draw(playingDeck);
		playerDeck.draw(playingDeck);

		opponentDeck.draw(playingDeck);
		opponentDeck.draw(playingDeck);

		tableDeck.draw(playingDeck);
		tableDeck.draw(playingDeck);
		tableDeck.draw(playingDeck);
		tableDeck.draw(playingDeck);
		tableDeck.draw(playingDeck);
		
		System.out.println("Your hand:");
		System.out.println(playerDeck.toString());

		System.out.println("Opponent hand:");
		System.out.println(opponentDeck.toString());
		
		System.out.println("TableDeck hand:");
		System.out.println(tableDeck.toString());
	}

}
