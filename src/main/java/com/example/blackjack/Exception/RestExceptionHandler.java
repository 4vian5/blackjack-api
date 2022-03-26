package com.example.blackjack.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<GlobalExcepctionHandler> handleBankRupt(BankRuptExcepction e){
		GlobalExcepctionHandler error = new GlobalExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<PlayerExcepctionHandler> playerWon(PlayerWonException e){
		PlayerExcepctionHandler error = new PlayerExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.OK.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setPlayer(e.getP());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<PlayerExcepctionHandler> handleBankRupt(PlayerBustException e){
		PlayerExcepctionHandler error = new PlayerExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setPlayer(e.getP());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<DealerExcepctionHandler> DealerWon(DealerWonException e){
		DealerExcepctionHandler error = new DealerExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.OK.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setDealer(e.getP());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<DealerExcepctionHandler> DealerWon(DealerBustException e){
		DealerExcepctionHandler error = new DealerExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setDealer(e.getP());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<DrawExcepctionHandler> draw(DrawExcepction e){
		DrawExcepctionHandler error = new DrawExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.OK.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setD(e.getP());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<GlobalExcepctionHandler> global(Exception e){
		GlobalExcepctionHandler error = new GlobalExcepctionHandler();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
