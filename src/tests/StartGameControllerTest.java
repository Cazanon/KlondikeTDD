package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import models.Card;

import org.junit.Before;
import org.junit.Test;

import controllers.StartGameController;

public class StartGameControllerTest {

	private StartGameController startGameController;
	
	@Before
	public void before() {
		startGameController = new StartGameController();
	}
	
	@Test
	public void sizeWasteTest() {
		assertEquals(0, startGameController.sizeWaste());
	}
	
	@Test
	public void sizeDeckTest() {
		assertEquals(24, startGameController.sizeDeck());
	}
	
	@Test
	public void sizeFoundationsTest() {
		assertEquals(0, startGameController.sizeFoundations());		
	}
	
	@Test
	public void sizeTableausTest() {
		ArrayList<Integer> sizeTableaus = startGameController.sizeCoveredCardsTableaus();
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = startGameController.uncoveredCardsStackTableaus();
		
		assertEquals(7, sizeTableaus.size());
		assertEquals(7, uncoveredCardsStackTableaus.size());
		
		for (int i = 0; i < sizeTableaus.size(); i++) {
			assertEquals(new Integer(i), sizeTableaus.get(i));
		}
		for (Stack<Card> uncoveredCardsStack : uncoveredCardsStackTableaus) {
			assertEquals(1, uncoveredCardsStack.size());
			assertTrue(uncoveredCardsStack.peek().uncovered()); //cima
		}
	}
}
