package controllers;

import models.CardStack;

public class MoveController {

	public boolean move(CardStack from, CardStack to) {
		if(to.canPush(from.peek())){
			to.push(from.pop());
			return true;
		}
		return false;
	}

}
