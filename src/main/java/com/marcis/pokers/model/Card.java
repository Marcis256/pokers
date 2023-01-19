package com.marcis.pokers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity(name = "card")
@Getter @Setter @NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;
    @Column(name = "suit")
    private Suit suit;
    @Column(name = "value")
    private Value value;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "did")
    private Deck deck;
    
    public Card(Suit suit, Value value, Deck deck){
        this.value = value;
        this.suit = suit;
        this.deck = deck;
    }
    public Card(Suit suit, Value value){
        this.value = value;
        this.suit = suit;
    }
    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }
}
