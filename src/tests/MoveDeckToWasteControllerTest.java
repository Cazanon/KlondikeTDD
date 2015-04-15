package tests;

import static org.junit.Assert.assertEquals;
import models.Card;
import models.DeckStack;
import models.WasteStack;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveController;

public class MoveDeckToWasteControllerTest {
	
	private MoveController moveController;
	
	@Before
	public void before() {
		moveController = new MoveController();
	}

	@Test
	public void moveDeckToWasteTest() {
		Card card = new Card();
		DeckStack deckStack = new DeckStack();
		deckStack.push(card);
		WasteStack wasteStack = new WasteStack();
			
		int numberCardsDeckStack = deckStack.size();
		int numberCardsWasteStack = wasteStack.size();		
		
		moveController.move(deckStack,wasteStack);
		
		assertEquals(numberCardsDeckStack-1,deckStack.size());
		assertEquals(numberCardsWasteStack+1,wasteStack.size());
		assertEquals(card,wasteStack.peek());
	}
	
	
}
