package models;

import java.util.Stack;

public abstract class CardStack extends Stack<Card>{

	private static final long serialVersionUID = 1L;

	public abstract boolean canPush(Card card);
	
}
