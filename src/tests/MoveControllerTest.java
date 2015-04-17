package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import models.Card;
import models.CardSuite;
import models.DeckStack;
import models.FoundationStack;
import models.TableauStack;
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
		Card card = new Card(1,CardSuite.CLUB);
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
		Card card = new Card(1,CardSuite.CLUB);
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
	
	@Test
	public void moveWasteToTableausTest() {
		Card card = new Card(1,CardSuite.CLUB);
		WasteStack wasteStack = new WasteStack();
		wasteStack.push(card);
		
		TableauStack tableauStack = new TableauStack();
		
		assertTrue(tableauStack.canPush(card));
		assertFalse(wasteStack.isEmpty());
				
		int numberCardsWasteStack = wasteStack.size();
		int numberCardsTableauStackStack = tableauStack.size();
		
		moveController.move(wasteStack,tableauStack);
		
		assertEquals(numberCardsWasteStack-1,wasteStack.size());
		assertEquals(numberCardsTableauStackStack+1,tableauStack.size());
		assertEquals(card,tableauStack.peek());
	}
	
	@Test
	public void moveWasteToDefinedTableauTest() {
		Card card = new Card(2,CardSuite.CLUB);
		WasteStack wasteStack = new WasteStack();
		wasteStack.push(card);
		
		TableauStack tableauStackRed = new TableauStack();
		TableauStack tableauStackBlack = new TableauStack();
		Card cardRed = new Card(1,CardSuite.DIAMOND);
		Card cardBlack = new Card(1,CardSuite.CLUB);
		
		assertTrue(tableauStackRed.canPush(cardRed));
		tableauStackRed.add(cardRed);
		
		assertTrue(tableauStackBlack.canPush(cardBlack));
		tableauStackBlack.add(cardBlack);
		
		assertFalse(wasteStack.isEmpty());
		
		int numberCardsWasteStack = wasteStack.size();
		int numberCardsTableauStackRed = tableauStackRed.size();
		int numberCardsTableauStackBlack = tableauStackBlack.size();

		assertFalse(moveController.move(wasteStack,tableauStackBlack));
		assertEquals(numberCardsWasteStack,wasteStack.size());
		assertEquals(numberCardsTableauStackBlack,tableauStackBlack.size());
		
		assertTrue(moveController.move(wasteStack,tableauStackRed));
		assertEquals(numberCardsWasteStack-1,wasteStack.size());
		assertEquals(numberCardsTableauStackRed+1,tableauStackRed.size());		
		assertEquals(card,tableauStackRed.peek());
	}
	
	@Test
	public void moveWasteToDefinedFoundationTest() {
		Card cardDiamondTop = new Card(2,CardSuite.CLUB);
		WasteStack wasteStack = new WasteStack();
		wasteStack.push(cardDiamondTop);
		
		FoundationStack foundationDiamond = new FoundationStack();
		FoundationStack foundationClub = new FoundationStack();
		Card cardDiamond = new Card(1,CardSuite.DIAMOND);
		Card cardClub = new Card(1,CardSuite.CLUB);
		
		assertTrue(foundationDiamond.canPush(cardDiamond));
		assertFalse(foundationDiamond.canPush(cardClub));
		foundationDiamond.add(cardDiamond);
		
		assertTrue(foundationClub.canPush(cardClub));
		assertFalse(foundationClub.canPush(cardDiamond));
		foundationClub.add(cardClub);
		
		assertFalse(wasteStack.isEmpty());
		
		int numberCardsWasteStack = wasteStack.size();
		int numberCardsFoundationDiamond = foundationDiamond.size();
		int numberCardsFoundationClub = foundationClub.size();

		assertFalse(moveController.move(wasteStack,foundationDiamond));
		assertEquals(numberCardsWasteStack,wasteStack.size());
		assertEquals(numberCardsFoundationDiamond,foundationDiamond.size());		
		
		assertTrue(moveController.move(wasteStack,foundationClub));
		assertEquals(numberCardsWasteStack-1,wasteStack.size());
		assertEquals(numberCardsFoundationClub+1,foundationClub.size());
		assertEquals(cardDiamondTop,foundationDiamond.peek());
		
		
	}
}
