package com.example.blackjack.Exception;

import com.example.blackjack.entity.Player;

public class PlayerWonException extends RuntimeException {

	private Player p;
	
	public PlayerWonException(String message) {
		super(message);
	}
	
	public PlayerWonException(String message, Player p) {
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
