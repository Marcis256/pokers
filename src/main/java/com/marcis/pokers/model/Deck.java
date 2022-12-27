package com.marcis.pokers.model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    private ArrayList<Card> cards;
    
    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    
    public void createFullDeck() {
        for(Suit cardSuit : Suit.values()) {
            for(Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
    
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int orginalSize = this.cards.size();
        for(int i = 0; i< orginalSize; i++) {
            //generate Random Index rand.nextInt((max - min) + 1) + min)
            randomCardIndex = random.nextInt((this.cards.size()-1 -0) + 1) + 0;
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }
    
    public String toString() {
        String cardListOutput = "";
        for(Card aCard : this.cards) {
            cardListOutput += " " + aCard.toString();
        }
        return cardListOutput;
    }
    
    public void removeCard(int i) {
        this.cards.remove(i);
    }
    
    public Card getCard(int i) {
        return this.cards.get(i);
    }
    
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }
    
    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
}
