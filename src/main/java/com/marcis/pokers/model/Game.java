package com.marcis.pokers.model;

import java.util.*;

public class Game {

    private ArrayList<Players> playersName;
    private String playerCombination;
    private Deck table;
    private Deck dealer;
    private String Winner;

    public Game() {
        this.playersName = new ArrayList<Players>();
        this.table = new Deck();
        this.dealer = new Deck();
    }

    public void addNewPlayer(String name) {
        this.playersName.add(new Players(name));
    }

    public void dealerShuffleCards() {
        dealer.createFullDeck();
        dealer.shuffle();
    }

    public void dealerGiveCardsToAllPlayer() {
        for(Players players : playersName) {
            players.getPlayerCards().draw(dealer);
            players.getPlayerCards().draw(dealer);
        }
    }
    public void dealerDealRiver() {
        table.draw(dealer);
        table.draw(dealer);
        table.draw(dealer);
    }

    public void dealerDealFlop() {
        table.draw(dealer);
    }

    public void dealerDealTurn() {
        table.draw(dealer);
    }

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

    public void combination() {
        for(Players players : playersName) {
            Deck playerFullTable = playerFullTable(players.getPlayerCards(),this.table);
            boolean pair = pair(playerFullTable);

            if(flush(playerFullTable) && straight(playerFullTable)) {
                players.setPlayerCombination(9);
            } else if(pair && "FOUR OF A KIND".equalsIgnoreCase(this.playerCombination)) {
                players.setPlayerCombination(8);
            } else if(pair && "FULL HOUSE".equalsIgnoreCase(this.playerCombination)) {
                players.setPlayerCombination(7);
            } else if(flush(playerFullTable)) {
                players.setPlayerCombination(6);
            }else if(straight(playerFullTable)) {
                players.setPlayerCombination(5);
            } else if(pair && "THREE OF A KIND".equalsIgnoreCase(this.playerCombination)) {
                players.setPlayerCombination(4);
            } else if(pair && "TWO PAIR".equalsIgnoreCase(this.playerCombination)) {
                players.setPlayerCombination(3);
            } else if(pair && "ONE PAIR".equalsIgnoreCase(this.playerCombination)) {
                players.setPlayerCombination(2);
            }else{
                players.setPlayerCombination(1);
            }
        }
    }


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
            this.playerCombination = "FOUR OF A KIND";
            return true;
        } else if (threeOfKind && pair) {
            this.playerCombination = "FULL HOUSE";
            return true;
        } else if (threeOfKind) {
            this.playerCombination = "THREE OF A KIND";
            return true;
        } else if (twoPair){
            this.playerCombination = "TWO PAIR";
            return true;
        } else if (pair) {
            this.playerCombination = "ONE PAIR";
            return true;
        }

        return false;
    }

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

    public String toString() {
        return
                "playerNames" + playersName.toString() + "\n" +
                "Table: " + table.toString() + "\n" +
                "Winner: " + Winner + "\n"
                ;
    }
}
