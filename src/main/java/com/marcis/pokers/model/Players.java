package com.marcis.pokers.model;

public class Players {
    private String playerName;
    private Deck playerCards;
    private Combination combination;

    public Players(String playerName){
        this.playerName = playerName;
        this.playerCards = new Deck();
        this.combination = new Combination();
    }

    public Combination getCombination() {
        return this.combination;
    }

    public void setCombination(Deck table) {
        this.combination = new Combination(table,playerCards);
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Deck getPlayerCards() {
        return this.playerCards;
    }

    public String toString() {
        return "\n" + this.playerName + " Cards: " + this.playerCards + " playerCombination: " + this.getCombination().getPlayerCombinationStrength() + " - "+ this.getCombination().getPlayerCombinationName() + "\n";
    }
}
