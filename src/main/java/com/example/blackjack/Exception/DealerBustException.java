package com.example.blackjack.Exception;

import com.example.blackjack.entity.Dealer;

public class DealerBustException extends RuntimeException {

	private Dealer d;
	
	public DealerBustException(String message) {
		super(message);
	}
	
	public DealerBustException(String message, Dealer d) {
		super(message);
		this.d = d;
	}

	public Dealer getP() {
		return d;
	}

	public void setP(Dealer d) {
		this.d = d;
	}
	
	
}
