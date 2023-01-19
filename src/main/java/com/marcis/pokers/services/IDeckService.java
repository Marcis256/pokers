package com.marcis.pokers.services;


import com.marcis.pokers.model.Deck;

import java.util.ArrayList;

public interface IDeckService {
    ArrayList<Deck> selectDeck();
    void createFullDeck();
}
