package models;

import java.util.Stack;

public class FoundationStack extends Stack<Card>{

	private static final long serialVersionUID = 1L;

	public boolean canPush(Card card) {
		if(this.isEmpty()) return true; //y es la primera
		Card topCard = this.peek();
		if(card.isSameColor(topCard) && card.isNext(topCard)){
			return true;
		}
		return false;		
	}

}
