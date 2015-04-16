package models;

public class Card {

	public static final int MAX_VALUE = 13;
	public static final int MIN_VALUE = 1;
	private CardSuite cardSuite;
	private int value;

	public Card(int value, CardSuite cardSuite){
		this.value = value;
		this.cardSuite = cardSuite;
	}
	
	public boolean isUncovered() {
		return true;
	}

	public boolean isSameColor(Card topCard) {
		return Color.isSameColor(this, topCard);				
	}

	public boolean isNext(Card topCard) {
		return this.value + 1 == topCard.getValue();		
	}

	public CardSuite getCardSuite() {
		return cardSuite;
	}

	public void setCardSuite(CardSuite cardSuite) {
		this.cardSuite = cardSuite;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isFirst() {
		return value == 1;
	}

}
