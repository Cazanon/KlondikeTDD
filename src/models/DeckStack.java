package models;


public class DeckStack extends CardStack{

	private static final long serialVersionUID = 1L;
	public static final int MAX_CARDS = 24;
	
	@Override
	public boolean canPush(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

}
