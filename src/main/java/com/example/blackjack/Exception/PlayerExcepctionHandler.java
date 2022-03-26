package com.example.blackjack.Exception;

import com.example.blackjack.entity.Player;

public class PlayerExcepctionHandler {

		private int status;
		private String message;
		private long timestamp;
		Player player;
		
		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

		public PlayerExcepctionHandler() {}
		
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
