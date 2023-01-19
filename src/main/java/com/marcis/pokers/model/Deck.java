package com.marcis.pokers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Table
@Entity(name = "deck")
@Getter @Setter @NoArgsConstructor
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long did;
    @OneToMany(mappedBy = "deck")
    @ToString.Exclude
    private List<Card> cards;

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
            cardListOutput += ", " + aCard.toString();
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
