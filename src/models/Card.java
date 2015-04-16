package models;

public class Card {

	private CardSuite color;
	private int value;

	public Card(int value, CardSuite color){
		this.value = value;
		this.color = color;
	}
	
	public boolean isUncovered() {
		return true;
	}

	public boolean isSameColor(Card topCard) {
		return this.color == topCard.getColor();		
	}

	public boolean isNext(Card topCard) {
		return this.value + 1 == topCard.getValue();		
	}

	public CardSuite getColor() {
		return color;
	}

	public void setColor(CardSuite color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
