package com.example.blackjack.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Player implements GamePlayer {

	private int balance = 100;
	private String name;
	private int cardValue;
	private ArrayList<String> decks = new ArrayList<>();
	private int betAmount;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCardValue() {
		return cardValue;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
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
	
	public void win(int times) {
		this.balance += betAmount*times;
	}
	
	public int getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}
	@Override
	public String toString() {
		return " { \"balance\" : " + balance + ", \"name\" : \" " + name + " \", \"cardValue\" : " + cardValue + ", \"decks\" : \" " + decks + "\" }";
	}
	
}
