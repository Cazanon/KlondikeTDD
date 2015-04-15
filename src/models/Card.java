package models;

public class Card {

	private Color color;
	private int value;

	public boolean uncovered() {
		return true;
	}

	public boolean isSameColor(Card topCard) {
		return this.color == topCard.getColor();		
	}

	public boolean isNext(Card topCard) {
		return this.value + 1 == topCard.getValue();		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
