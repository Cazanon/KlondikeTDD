package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveDeckToWasteController;

public class MoveDeckToWasteControllerTest {
	
	private MoveDeckToWasteController deckToWasteController;
	
	@Before
	public void before() {
		deckToWasteController = new MoveDeckToWasteController();
	}

	@Test
	public void isEmptyDeckTest() {
		assertFalse(deckToWasteController.isEmptyDeck());
	}
	
	
}
