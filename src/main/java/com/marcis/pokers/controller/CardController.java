package com.marcis.pokers.controller;

import com.marcis.pokers.model.Card;
import com.marcis.pokers.repostory.CardRepostory;
import com.marcis.pokers.services.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CardController {

    @Autowired
    ICardService cardService;
    @Autowired
    CardRepostory cardRepostory;

    @GetMapping("/cards")
    @ResponseBody
    public ResponseEntity<ArrayList<Card>> getCards() {
        return new ResponseEntity<ArrayList<Card>>(cardService.selectCards(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/cards")
    public Card createNewCard(@RequestBody Card card) { return cardRepostory.save(card);}


    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        try {
            Card existingCard = cardService.selectOneCardById(id);
            return ResponseEntity.ok(existingCard);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card card) {
        try {
            Card existingCard = cardService.updateCardById(id, card);
            return ResponseEntity.ok(existingCard);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
