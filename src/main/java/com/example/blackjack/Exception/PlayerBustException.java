package com.example.blackjack.Exception;

import com.example.blackjack.entity.Player;

public class PlayerBustException extends RuntimeException {

	private Player p;
	
	public PlayerBustException(String message) {
		super(message);
	}
	
	public PlayerBustException(String message, Player p) {
		super(message);
		this.p = p;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
	
	
}
