package com.marcis.pokers.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Combination {
    private int playerCombinationStrength;
    private String playerCombinationName;

    public Combination(Deck table, Deck playerCard){
        setPlayerCombinationAndNameStrength(table,playerCard);
    }
    public Combination(){
        this.playerCombinationStrength = 0;
        this.playerCombinationName = "Error";
    }

    public String getPlayerCombinationName() {
        return this.playerCombinationName;
    }
    public int getPlayerCombinationStrength() {
        return this.playerCombinationStrength;
    }

    //Main function who set combination Strength
    public void setPlayerCombinationAndNameStrength(Deck table, Deck playerCard) {
        Deck playerFullTable = playerFullTable(playerCard,table);
        boolean pair = pair(playerFullTable);
        if(flush(playerFullTable) && straight(playerFullTable)) {
            this.playerCombinationStrength = 9;
            this.playerCombinationName = "STRAIGHT FLUSH";
        } else if(pair && "FOUR OF A KIND".equalsIgnoreCase(this.playerCombinationName)) {
            this.playerCombinationStrength = 8;
        } else if(pair && "FULL HOUSE".equalsIgnoreCase(this.playerCombinationName)) {
            this.playerCombinationStrength = 7;
        } else if(flush(playerFullTable)) {
            this.playerCombinationStrength = 6;
            this.playerCombinationName = "FLUSH";
        }else if(straight(playerFullTable)) {
            this.playerCombinationStrength = 5;
            this.playerCombinationName = "STRAIGHT";
        } else if(pair && "THREE OF A KIND".equalsIgnoreCase(this.playerCombinationName)) {
            this.playerCombinationStrength = 4;
        } else if(pair && "TWO PAIR".equalsIgnoreCase(this.playerCombinationName)) {
            this.playerCombinationStrength = 3;
        } else if(pair && "ONE PAIR".equalsIgnoreCase(this.playerCombinationName)) {
            this.playerCombinationStrength = 2;
        }else{
            this.playerCombinationStrength = 1;
            this.playerCombinationName = "HIGH CARD";
        }
    }

    //Add playerCard with Table Card together
    public Deck playerFullTable(Deck player, Deck table) {
        Deck playerFullTable = new Deck();
        for(Card playerCard : player.getCards()) {
            playerFullTable.addCard(playerCard);
        }
        for(Card tableCard : table.getCards()) {
            playerFullTable.addCard(tableCard);
        }
        Collections.sort(playerFullTable.getCards(), new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return playerFullTable;
    }

    //Check pair combination
    public boolean pair(Deck playerFullTable) {
        boolean fourOfKind = false;
        boolean threeOfKind = false;
        boolean pair = false;
        boolean twoPair = false;
        Map<Integer,Integer> countMap = new HashMap<>();

        for(Card playerCards1 : playerFullTable.getCards()) {
            if(countMap.containsKey(playerCards1.getValue().ordinal())) {
                countMap.put(playerCards1.getValue().ordinal(), countMap.get(playerCards1.getValue().ordinal()) + 1);
            } else {
                countMap.put(playerCards1.getValue().ordinal(),1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 4) {
                fourOfKind = true;
            } else if(entry.getValue() == 3) {
                threeOfKind = true;
            } else if (entry.getValue() == 2) {
                if(pair) {
                    twoPair = true;
                } else {
                    pair = true;
                }
            }
            //System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        if(fourOfKind) {
            this.playerCombinationName = "FOUR OF A KIND";
            return true;
        } else if (threeOfKind && pair) {
            this.playerCombinationName = "FULL HOUSE";
            return true;
        } else if (threeOfKind) {
            this.playerCombinationName = "THREE OF A KIND";
            return true;
        } else if (twoPair){
            this.playerCombinationName = "TWO PAIR";
            return true;
        } else if (pair) {
            this.playerCombinationName = "ONE PAIR";
            return true;
        }

        return false;
    }

    //Check straight combination
    public boolean straight(Deck playerFullTable) {
        int higherCard = 0;
        int i = 1;
        int before = -1;
        for(Card playerCards1 : playerFullTable.getCards()) {
            if(before == -1) {
                before = playerCards1.getValue().ordinal();
            } else {
                if(playerCards1.getValue().ordinal() == before + 1) {
                    i++;
                    before = playerCards1.getValue().ordinal();
                    higherCard = before;
                }else if(playerCards1.getValue().ordinal() == before) {
                }else{
                    i=1;
                    before = playerCards1.getValue().ordinal();
                }
            }
        }
        if(i>=5) {
            return true;
        }
        return false;
    }

    //Check flush combination
    public boolean flush(Deck playerFullTable) {
        int HEART = 0;
        int SPADE = 0;
        int CLUB = 0;
        int DIAMOND = 0;
        for(Card playerCards1 : playerFullTable.getCards()) {
            if("HEART".equalsIgnoreCase(playerCards1.getSuit().toString())) {
                HEART++;
            } else if ("SPADE".equalsIgnoreCase(playerCards1.getSuit().toString())) {
                SPADE++;
            } else if ("CLUB".equalsIgnoreCase(playerCards1.getSuit().toString())) {
                CLUB++;
            } else if ("DIAMOND".equalsIgnoreCase(playerCards1.getSuit().toString())) {
                DIAMOND++;
            }
            if(HEART == 5 || SPADE == 5 || CLUB == 5 || DIAMOND == 5) {
                return true;
            }
        }
        return false;
    }
}
