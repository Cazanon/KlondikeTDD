package models;

import java.util.Stack;

public class TableauStack extends Stack<Card>{

	private static final long serialVersionUID = 1L;

	public boolean canPush(Card card) {
		if(this.isEmpty() && card.isFirst()) return true;
		Card topCard = this.peek();
		if(!topCard.isUncovered() || card.isSameColor(topCard) || !topCard.isNext(card)) return false;		
		return true;
	}

}
