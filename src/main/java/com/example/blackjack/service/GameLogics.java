package com.example.blackjack.service;

import org.springframework.stereotype.Component;

import com.example.blackjack.entity.GamePlayer;
import com.example.blackjack.utility.Decks;

@Component
public class GameLogics {

	public void setValue(GamePlayer player, Decks deck) {
		 int value = 0;
	        boolean AceFlag = false;
	        for(String myCard : player.getDecks()){
	            if(myCard.matches(".*ACE$")){
	                AceFlag = true;
	                continue;
	            }
	            value += deck.getValue(myCard);
	        }
	        if(AceFlag)
	            value += valueOfAce(value);
	        player.setCardValue(value);
	    }


	private int valueOfAce(int value){
	    if(value + 11 > 21)
	        return 1;        
	    return 11;
	}
	
}
