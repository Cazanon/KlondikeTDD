package controllers;

import models.DeckStack;
import models.WasteStack;

public class MoveController {

	public void move(DeckStack from, WasteStack to) {
		to.push(from.pop());		
	}

}
