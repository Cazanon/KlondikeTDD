package models;

import java.util.Stack;

public class TableauStack extends CardStack{

	private static final long serialVersionUID = 1L;

	public boolean canPush(Card card) {
		if(this.isEmpty() && card.isFirst()) return true;
		Card topCard = this.peek();
		if(!topCard.isCovered() || card.isSameColor(topCard) || !card.isNext(topCard)) return false;		
		return true;
	}

	public Integer getCoveredCards() {
		int coveredCards = 0;
		for(Card card : this){
			if(card.isCovered()) coveredCards++;
		}
		return coveredCards;
	}

	public Stack<Card> getUncoveredCards() {
		Stack<Card> uncoveredCards = new Stack<Card>();
		for(Card card : this){
			if(!card.isCovered()) uncoveredCards.add(card);
		}
		return uncoveredCards;
	}

}
