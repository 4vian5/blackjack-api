package com.example.blackjack.Exception;

import java.util.Map;

import com.example.blackjack.entity.Dealer;
import com.example.blackjack.entity.GamePlayer;

public class DrawExcepctionHandler {

		private int status;
		private String message;
		private long timestamp;
		private Map<String , GamePlayer> Gamers;
		

		public Map<String, GamePlayer> getD() {
			return Gamers;
		}

		public void setD(Map<String, GamePlayer> d) {
			this.Gamers = d;
		}

		public DrawExcepctionHandler() {}
		
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
