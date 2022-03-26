package com.example.blackjack.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Dealer implements GamePlayer {

	private int cardValue;
	private ArrayList<String> decks = new ArrayList<>();
	
	public int getCardValue() {
		return cardValue;
	}
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
	public ArrayList<String> getDecks() {
		return decks;
	}
	public void setDecks(ArrayList<String> decks) {
		this.decks = decks;
	}
	public String dealerValue() {
		return " { \"decks\" : \" ["  + decks.get(0) + " , null ]\" }";
	}
	
	public String toString() {
		return " {  \"cardValue\" : " + cardValue + ", \"decks\" : \" " + decks + "\" }";
	}
}
