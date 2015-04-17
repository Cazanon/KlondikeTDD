package models;


public class FoundationStack extends CardStack{

	private static final long serialVersionUID = 1L;

	public boolean canPush(Card card) {
		if(this.isEmpty() && card.isFirst()) return true;
		Card topCard = this.peek();
		if(card.isSameColor(topCard) && card.isNext(topCard)){
			return true;
		}
		return false;		
	}

}
