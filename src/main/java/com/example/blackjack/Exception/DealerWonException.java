package com.example.blackjack.Exception;

import com.example.blackjack.entity.Dealer;

public class DealerWonException extends RuntimeException {

	private Dealer d;
	
	public DealerWonException(String message) {
		super(message);
	}
	
	public DealerWonException(String message, Dealer d) {
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
