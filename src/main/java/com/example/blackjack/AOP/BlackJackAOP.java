package com.example.blackjack.AOP;


import java.util.Map;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.blackjack.Exception.DealerBustException;
import com.example.blackjack.Exception.DealerWonException;
import com.example.blackjack.Exception.DrawExcepction;
import com.example.blackjack.Exception.PlayerBustException;
import com.example.blackjack.Exception.PlayerWonException;
import com.example.blackjack.entity.Dealer;
import com.example.blackjack.entity.GamePlayer;
import com.example.blackjack.entity.Player;

@Component
@Aspect
public class BlackJackAOP {

	
	@AfterReturning(pointcut="execution(com.example.blackjack.entity.Player com.example.blackjack.service.Games.*Player())",returning="player")
	public void checkResult(Player player) {
		System.out.println(player);
		if(player.getCardValue()  > 21 )
			throw new PlayerBustException("Player Bust", player);
		else if (player.getCardValue() == 21) 
			throw new PlayerWonException("BlackJack - Player Wins", player);	
	}
	
	@AfterReturning(pointcut="execution(java.util.Map com.example.blackjack.service.Games.*())",returning="gameplayer")
	public void checkResult(Map<String , GamePlayer> gameplayer) {
		Dealer dealer = (Dealer)gameplayer.get("Dealer");
		Player player = (Player)gameplayer.get("Player");
		if(dealer.getCardValue() > 21)
			throw new DealerBustException("Dealer Bust", dealer);
		else if(dealer.getCardValue() == 21)
			throw new DealerWonException("BlackJack - Dealer", dealer);
		else if(dealer.getCardValue() > player.getCardValue())
			throw new DealerWonException("Dealer Won", dealer);
		else if(dealer.getCardValue() == player.getCardValue()){
			throw new DrawExcepction("The result is Draw", gameplayer);
		}
	}
}
