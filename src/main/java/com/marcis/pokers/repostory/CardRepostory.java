package com.marcis.pokers.repostory;

import com.marcis.pokers.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepostory extends JpaRepository<Card, Long> {
}
