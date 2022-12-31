package com.marcis.pokers.model;

import java.util.ArrayList;

public class Players {
    String playerName;
    Deck playerCards;
    int playerCombinationStrength;
    String playerCombinationName;

    public Players(String playerName){
        this.playerName = playerName;
        this.playerCards = new Deck();
        this.playerCombinationStrength = 0;
        this.playerCombinationName = "error";
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public Deck getPlayerCards() {
        return this.playerCards;
    }
    public int getPlayerCombination() {
        return this.playerCombinationStrength;
    }

    public void setPlayerCombination(int playerCombination) {
        this.playerCombinationStrength = playerCombination;
        this.playerCombinationName = setPlayerCombinationName();
    }

    public String setPlayerCombinationName() {
        if (this.playerCombinationStrength == 1) {
            return "HIGH CARD";
        } else if (this.playerCombinationStrength == 2) {
            return "ONE PAIR";
        } else if (this.playerCombinationStrength == 3) {
            return "TWO PAIR";
        } else if (this.playerCombinationStrength == 4) {
            return "THREE OF A KIND";
        } else if (this.playerCombinationStrength == 5) {
            return "STRAIGHT";
        } else if (this.playerCombinationStrength == 6) {
            return "FLUSH";
        } else if (this.playerCombinationStrength == 7) {
            return "FULL HOUSE";
        } else if (this.playerCombinationStrength == 8) {
            return "FOUR OF A KIND";
        } else if (this.playerCombinationStrength == 9) {
            return "STRAIGHT FLUSH";
        } else {
            return "ERROR";
        }
    }

    public String getPlayerCombinationName() {
        return this.playerCombinationName;
    }

    public String toString() {
        return "\n" + this.playerName + " Cards: " + this.playerCards + " playerCombination: " + this.playerCombinationName + "\n";
    }
}
