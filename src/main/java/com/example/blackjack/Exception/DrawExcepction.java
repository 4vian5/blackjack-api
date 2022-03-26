package com.example.blackjack.Exception;

import java.util.Map;

import com.example.blackjack.entity.GamePlayer;

public class DrawExcepction extends RuntimeException {

	private Map<String , GamePlayer> gamer;
	
	public DrawExcepction(String message) {
		super(message);
	}
	public DrawExcepction(String message, Map<String, GamePlayer> d) {
		super(message);
		this.gamer = d;
	}

	public Map<String , GamePlayer> getP() {
		return gamer;
	}

	public void setP(Map<String , GamePlayer> d) {
		this.gamer = d;
	}
	
	
}
