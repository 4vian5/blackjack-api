package com.example.blackjack.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.blackjack.Exception.BankRuptExcepction;
import com.example.blackjack.entity.GamePlayer;
import com.example.blackjack.entity.Player;
import com.example.blackjack.service.Games;
import com.example.blackjack.utility.PostObjects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1")
public class BlackJackRest {
	
	@Autowired
	Games game;
	
	ObjectMapper mapper = new ObjectMapper();
	Map<String, String> map;

	@PostMapping(value="/start",produces="application/json")
	public String start(@RequestBody PostObjects post) throws BankRuptExcepction{
		game.start(post.getBetAmount());
		return "{\"success\" : true, \"Player\" : " + game.getPlayer().toString() + " ,\"Dealer\" : " + game.getDealer().dealerValue() +"}";
	}
	
	
	@GetMapping(value="/shuffle",produces="application/json")
	public String shuffle(){
		game.shuffle();
		return "{\"success\" : true}";
	}
	
	@GetMapping("/player")
	public Player getPlayer() {
		return game.getPlayer();
	}
	
	@PostMapping(value="/player",produces="application/json")
	public String setPlayerName(@RequestBody String req) throws JsonMappingException, JsonProcessingException {
		 map = mapper.readValue(req, Map.class);
		 if(map.containsKey("name")) {
			 game.getPlayer().setName(map.get("name"));
			 return "{\"success\" : true, \"Player\" : " + game.getPlayer().toString() + "}";
			 
		 }		 
		 else
			throw new BankRuptExcepction("Error on Post Request");
	}
	
	@GetMapping("/hit")
	public Player playerHit() {
		return game.hitPlayer();
	}
	
	@PostMapping(value="/bet",produces="application/json")
	public String setBet(@RequestBody String req) throws JsonMappingException, JsonProcessingException {
		 map = mapper.readValue(req, Map.class);
		 if(map.containsKey("betAmount")) {
			 game.changeBet(Integer.parseInt(map.get("betAmount")));
			 return "{\"success\" : true }";		 
		 }		 
		 else
			throw new BankRuptExcepction("Error on Post Request");
	}
	
	@GetMapping("/stand")
	public Map<String , GamePlayer> stand() {
		return game.stand();
	}
	
	@GetMapping(value="/start",produces="application/json")
	public String start() throws BankRuptExcepction{
		game.restart();
		return "{\"success\" : true, \"Player\" : " + game.getPlayer().toString() + " ,\"Dealer\" : " + game.getDealer().dealerValue() +"}";
	}
	
	@PostMapping(value="/deposit",produces="application/json")
	public String depositBalance(@RequestBody String req) throws JsonMappingException, JsonProcessingException {
		 map = mapper.readValue(req, Map.class);
		 if(map.containsKey("amount")) {
			 game.deposit(Integer.parseInt(map.get("amount")));
			 return "{\"success\" : true }";		 
		 }		 
		 else
			throw new BankRuptExcepction("Error on Post Request");
	}
	
	@PostMapping(value="/mysecretendpoint",produces="application/json")
	public String secreMode(@RequestBody PostObjects post) throws BankRuptExcepction{
		game.start(post.getBetAmount());
		return "{\"success\" : true, \"Player\" : " + game.getPlayer().toString() + " ,\"Dealer\" : " + game.getDealer().dealerValue() +"}";
	}
	
}
