package controllers;

import models.CardStack;
import models.DeckStack;
import models.WasteStack;

public class MoveController {

	public boolean move(CardStack from, CardStack to) {
		if(to.canPush(from.peek())){
			to.push(from.pop());
			return true;
		}
		return false;
	}
	
	public boolean move(DeckStack from, WasteStack to) {
		from.peek().setCovered(false);
		if(to.canPush(from.peek())){
			to.push(from.pop());
			return true;
		}
		return false;
	}

}
