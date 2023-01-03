package com.marcis.pokers.model;

import java.util.*;

public class Game {

    private ArrayList<Players> playersName;
    private Deck table;
    private Deck dealer;
    private String Winner;

    public Game() {
        this.playersName = new ArrayList<Players>();
        this.table = new Deck();
        this.dealer = new Deck();
    }

    public void addNewPlayer(String name) {
        this.playersName.add(new Players(name));
    }

    public void dealerShuffleCards() {
        dealer.createFullDeck();
        dealer.shuffle();
    }
    public void dealerGiveCardsToAllPlayer() {
        for(Players players : playersName) {
            players.getPlayerCards().draw(dealer);
            players.getPlayerCards().draw(dealer);
        }
    }
    public void dealerDealRiver() {
        table.draw(dealer);
        table.draw(dealer);
        table.draw(dealer);
    }
    public void dealerDealFlop() {
        table.draw(dealer);
    }
    public void dealerDealTurn() {
        table.draw(dealer);
    }

    public void getCombination() {
        for(Players players : playersName) {
            players.setCombination(this.table);
        }
    }
    public String toString() {
        return
                "playerNames" + playersName.toString() + "\n" +
                "Table: " + table.toString() + "\n" +
                "Winner: " + Winner + "\n"
                ;
    }
}
