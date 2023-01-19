package com.marcis.pokers;

import com.marcis.pokers.model.*;
import com.marcis.pokers.repostory.CardRepostory;
import com.marcis.pokers.repostory.DeckRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class PokersApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PokersApplication.class, args);
/*		Game game = new Game();
		game.addNewPlayer("Mārcis");
		game.addNewPlayer("Aivars");
		game.addNewPlayer("Ernests");
		game.dealerShuffleCards();
		game.dealerGiveCardsToAllPlayer();
		game.dealerDealRiver();
		game.dealerDealFlop();
		game.getCombination();
		game.dealerDealTurn();

		System.out.println(game.toString());*/
	}

	@Bean
	public CommandLineRunner saveData(CardRepostory cardRepostory, DeckRepostory deckRepostory) {
		return(args)->{
/*			Deck deck = new Deck();
			deckRepostory.save(deck);

			Card card1 = new Card(Suit.CLUB,Value.ACE,deck);
			Card card2 = new Card(Suit.DIAMOND,Value.EIGHT,deck);
			Card card3 = new Card(Suit.DIAMOND,Value.NINE,deck);
			Card card4 = new Card(Suit.DIAMOND,Value.TEN,deck);
			Card card5 = new Card(Suit.DIAMOND,Value.THREE,deck);
			Card card6 = new Card(Suit.DIAMOND,Value.TWO,deck);
			cardRepostory.saveAll(Arrays.asList(card1,card2,card3,card4,card5,card6));*/
		};
	}

}
