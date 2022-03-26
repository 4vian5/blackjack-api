package com.example.blackjack.utility;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.blackjack.entity.Card;

public class Decks {
	
	private ArrayList<String> deck = new ArrayList<String>();
    private HashMap<String, String> deckMap = new HashMap<String, String>();

	public Decks(int noOfDecks){
        for(int i =0; i<noOfDecks; i++){
            for(Card.Suit suit : Card.Suit.values()){
                for(Card.CardNumber cardNumbers : Card.CardNumber.values()){
                    deck.add((new Card(cardNumbers, suit)).toString());
                    deckMap.put((new Card(cardNumbers, suit)).toString(), cardNumbers.getValue());
                }
            }
        }
    }

	public ArrayList<String> getDeck() {
		return deck;
	}

	public HashMap<String, String> getDeckMap() {
		return deckMap;
	}
	
	public int getValue(String myCard){
        String value = deckMap.get(myCard);
        return Integer.parseInt(value);
    }
	
	public String draw(){
        String drawn = deck.get(0);
        deck.remove(0);
        return drawn;
    }
	
}
