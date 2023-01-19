package com.marcis.pokers.controller;

import com.marcis.pokers.model.Card;
import com.marcis.pokers.model.Deck;
import com.marcis.pokers.repostory.CardRepostory;
import com.marcis.pokers.repostory.DeckRepostory;
import com.marcis.pokers.services.ICardService;
import com.marcis.pokers.services.IDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class DeckController {
    @Autowired
    IDeckService deckService;
    @Autowired
    DeckRepostory deckRepostory;

    @GetMapping("/decks")
    @ResponseBody
    public ResponseEntity<ArrayList<Deck>> getDecks() {
        return new ResponseEntity<ArrayList<Deck>>(deckService.selectDeck(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/decks")
    public void createNewDeck() { deckService.createFullDeck();}
}
