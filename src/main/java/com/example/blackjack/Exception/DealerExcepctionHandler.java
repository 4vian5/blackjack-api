package com.example.blackjack.Exception;

import com.example.blackjack.entity.Dealer;

public class DealerExcepctionHandler {

		private int status;
		private String message;
		private long timestamp;
		Dealer dealer;
		
		public Dealer getDealer() {
			return dealer;
		}

		public void setDealer(Dealer dealer) {
			this.dealer = dealer;
		}

		public DealerExcepctionHandler() {}
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
}
