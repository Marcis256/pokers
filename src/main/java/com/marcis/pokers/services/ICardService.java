package com.marcis.pokers.services;

import com.marcis.pokers.model.Card;
import com.marcis.pokers.model.Suit;
import com.marcis.pokers.model.Value;

import java.util.ArrayList;

public interface ICardService {
    ArrayList<Card> selectCards();
    Card selectOneCardById(long id) throws Exception;

    Card updateCardById(long id, Card card) throws Exception;

    Card createNewCard(Card card) throws Exception;
}
