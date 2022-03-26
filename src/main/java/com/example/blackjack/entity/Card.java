package com.example.blackjack.entity;


public class Card {
	
	public enum CardNumber {
        ACE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("10"),
        QUEEN("10"),
        KING("10");
    
          private String value;
    
          public String getValue() {
                 return this.value;
          }
          
          private CardNumber(String value) {
                 this.value = value;
          }
    }

    public enum Suit{
        DIAMONDS,
        SPADES,
        HEARTS,
        CLUBS;
    }
    
    public CardNumber cardNumber;
    public Suit suit;

    public Card(CardNumber cardNumber, Suit suit){
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    public String toString(){
        return this.suit + "-" + cardNumber;
    }

}
