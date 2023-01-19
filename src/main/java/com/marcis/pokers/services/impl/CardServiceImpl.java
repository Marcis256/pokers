package com.marcis.pokers.services.impl;

import com.marcis.pokers.model.Card;
import com.marcis.pokers.model.Suit;
import com.marcis.pokers.model.Value;
import com.marcis.pokers.repostory.CardRepostory;
import com.marcis.pokers.services.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    CardRepostory cardRepostory;

    @Override
    public ArrayList<Card> selectCards() {
        return (ArrayList<Card>) cardRepostory.findAll();
    }

    @Override
    public Card selectOneCardById(long id) throws Exception {
        if (cardRepostory.existsById(id)) {
            return cardRepostory.findById(id).get();
        } else {
            throw new Exception("Id nav pareizs");
        }
    }

    @Override
    public Card updateCardById(long id, Card card) throws Exception {
        if(cardRepostory.existsById(id))
        {
            Card task = cardRepostory.findById(id).get();
            task.setSuit(card.getSuit());
            task.setValue(card.getValue());

            cardRepostory.save(card);
            return card;
        }
        else
            throw new Exception("Id nav pareizs");
        }

    @Override
    public Card createNewCard(Card card) throws Exception {
        return cardRepostory.save(card);
    }
}
