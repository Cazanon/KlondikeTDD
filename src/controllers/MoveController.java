package controllers;

import models.DeckStack;
import models.FoundationStack;
import models.WasteStack;

public class MoveController {

	public void move(DeckStack from, WasteStack to) {
		to.push(from.pop());		
	}

	public void move(WasteStack from, FoundationStack to) {
		to.push(from.pop());		
	}

}
