package models;


public class WasteStack extends CardStack{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean canPush(Card card) {
		if(!card.isCovered()) return true;
		return false;
	}

}
