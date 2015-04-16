package models;

import java.util.Stack;

public class TableauStack extends Stack<Card>{

	private static final long serialVersionUID = 1L;

	public boolean canPush(Card card) {
		return true;
	}

}
