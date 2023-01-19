package com.marcis.pokers.services.impl;

import com.marcis.pokers.model.Card;
import com.marcis.pokers.model.Deck;
import com.marcis.pokers.model.Suit;
import com.marcis.pokers.model.Value;
import com.marcis.pokers.repostory.CardRepostory;
import com.marcis.pokers.repostory.DeckRepostory;
import com.marcis.pokers.services.IDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeckServiceImpl implements IDeckService {

    @Autowired
    DeckRepostory deckRepostory;
    @Autowired
    CardRepostory cardRepostory;
    @Override
    public ArrayList<Deck> selectDeck() {
        return (ArrayList<Deck>) deckRepostory.findAll();
    }

    @Override
    public void createFullDeck() {
        Deck newDeck = new Deck();
        this.deckRepostory.save(newDeck);
        for(Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                Card card = new Card(cardSuit,cardValue,newDeck);
                this.cardRepostory.save(card);
            }
        }
    }
}
