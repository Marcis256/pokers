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
