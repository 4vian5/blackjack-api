package com.example.blackjack.entity;

import java.util.ArrayList;

public interface GamePlayer {
	public int getCardValue();
	public void setCardValue(int cardValue);
	public ArrayList<String> getDecks();
	public void setDecks(ArrayList<String> decks);
}
