package com.marcis.pokers.repostory;

import com.marcis.pokers.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepostory extends JpaRepository<Deck, Long> {
}
