package com.marcis.pokers;

import com.marcis.pokers.model.Deck;
import com.marcis.pokers.model.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokersApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(PokersApplication.class, args);
		Game game = new Game();
		game.addNewPlayer("Mārcis");
		game.addNewPlayer("Aivars");
		game.addNewPlayer("Ernests");
		game.dealerShuffleCards();
		game.dealerGiveCardsToAllPlayer();
		game.dealerDealRiver();
		game.dealerDealFlop();
		game.dealerDealTurn();
		game.combination();

		System.out.println(game.toString());
	}

}
