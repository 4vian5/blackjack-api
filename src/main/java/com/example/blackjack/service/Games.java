package com.example.blackjack.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.blackjack.Exception.BankRuptExcepction;
import com.example.blackjack.entity.Dealer;
import com.example.blackjack.entity.GamePlayer;
import com.example.blackjack.entity.Player;
import com.example.blackjack.utility.Decks;

@Component
public class Games {
	
	private Decks deck;
	
	@Autowired
	private Player player;
	
	@Autowired
	private Dealer dealer;
	
	@Autowired
	private GameLogics game;
	
	private int noOfCards;
	
	private int bet;
	
	public void start(int betAmount){
		this.bet = betAmount;
		player.setBetAmount(betAmount);
		if(player.getDecks().size() != 0)
			throw new BankRuptExcepction("Game is already started");
		else if (betAmount <= 0)
			throw new BankRuptExcepction("Please Enter the bet Amount");
		else {
			deck = new Decks(3);
			shuffle();
			this.noOfCards = deck.getDeck().size();
			placeBet(betAmount);
			playerDraw();
			playerDraw();
			DealerDraw();
			DealerDraw();
			PlayerCardValue();
		}
	}
	
	
	private void placeBet(int betAmount){
		if(player.getBalance() == 0)
			throw new BankRuptExcepction("Player is Bankrupped");
		else if (player.getBalance() < betAmount)
			throw new BankRuptExcepction("Bet Amount is greater than player Balance");
		else {
			player.setBalance(player.getBalance() - betAmount);
		}
	}


	public void PlayerCardValue() {
		game.setValue(player, deck);
	}
	
	public void DealerCardValue() {
		game.setValue(dealer, deck);
	}
	
	public void playerDraw() {
		player.getDecks().add(deck.draw());
	}
	
	public Player hitPlayer() {
		playerDraw();
		PlayerCardValue();
		return getPlayer();
	}
	
	private void DealerDraw() {
		dealer.getDecks().add(deck.draw());
	}
	
	public Map<String , GamePlayer> stand() {
		Map<String, GamePlayer> finalInfo = new HashMap<>();
		DealerCardValue();
		int dealerValue = dealer.getCardValue();
		if(dealerValue <= 16) {
			DealerDraw();
			stand();
		}
		finalInfo.put("Dealer", dealer);
		finalInfo.put("Player", player);
		return finalInfo;
	}
	
	
	public void shuffle() {
		Collections.shuffle(deck.getDeck());
	}

	public Player getPlayer() {
		return player;
	}
	
	public void changeBet(int bet) {
		this.bet = bet;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	
	public void restart() {
		player.setCardValue(0);
		player.getDecks().clear();;
		dealer.setCardValue(0);
		dealer.getDecks().clear();
		deck = new Decks(3);
		placeBet(bet);
		shuffle();
		playerDraw();
		playerDraw();
		DealerDraw();
		DealerDraw();
		PlayerCardValue();
	}
	
	public void deposit(int number) {
		player.deposit(number);
	}
	
	public void hardRest(int betAmount) {
		restart();
		start(betAmount);
	}
	
}
