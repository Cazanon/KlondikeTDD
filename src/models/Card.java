package models;

public class Card {

	private Color color;

	public boolean uncovered() {
		return true;
	}

	public boolean isSameColor(Card topCard) {
		return this.color == topCard.getColor();		
	}

	public boolean isNext(Card topCard) {
		return true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
