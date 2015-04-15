package tests;

import static org.junit.Assert.*;
import models.Card;
import models.Color;
import models.DeckStack;
import models.FoundationStack;
import models.WasteStack;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveController;

public class MoveControllerTest {
	
	private MoveController moveController;
	
	@Before
	public void before() {
		moveController = new MoveController();
	}

	@Test
	public void moveDeckToWasteTest() {
		Card card = new Card(1,Color.CLUB);
		DeckStack deckStack = new DeckStack();
		deckStack.push(card);
		WasteStack wasteStack = new WasteStack();
			
		int numberCardsDeckStack = deckStack.size();
		int numberCardsWasteStack = wasteStack.size();		
		
		assertFalse(deckStack.isEmpty());
		
		moveController.move(deckStack,wasteStack);
		
		assertEquals(numberCardsDeckStack-1,deckStack.size());
		assertEquals(numberCardsWasteStack+1,wasteStack.size());
		assertEquals(card,wasteStack.peek());
	}
	
	@Test
	public void moveWasteToFoundationTest() {
		Card card = new Card(1,Color.CLUB);
		WasteStack wasteStack = new WasteStack();
		wasteStack.push(card);
		
		FoundationStack foundationStack = new FoundationStack();
		
		assertTrue(foundationStack.canPush(card));
		assertFalse(wasteStack.isEmpty());
				
		int numberCardsWasteStack = wasteStack.size();
		int numberCardsFoundationStack = foundationStack.size();
		
		moveController.move(wasteStack,foundationStack);
		
		assertEquals(numberCardsWasteStack-1,wasteStack.size());
		assertEquals(numberCardsFoundationStack+1,foundationStack.size());
		assertEquals(card,foundationStack.peek());
	}
	
}
