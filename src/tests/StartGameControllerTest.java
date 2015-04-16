package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import models.Card;
import models.TableauStack;

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
		ArrayList<Integer> sizeFoundations = startGameController.sizeFoundations();
		assertEquals(4, sizeFoundations.size());
		for (int cardsFoundation : sizeFoundations) {
			assertEquals(0, cardsFoundation);
		}
	}
	
	@Test
	public void sizeTableausTest() {
		List<TableauStack> tableaus = startGameController.getTableaus();
		
		assertEquals(7, tableaus.size());
		
		for (int i = 0; i < tableaus.size(); i++) {
			assertEquals(new Integer(i), tableaus.get(i).getCoveredCards());
		}
		
		ArrayList<Integer> coveredCardsStackTableaus = startGameController.sizeCoveredCardsStackTableaus();
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = startGameController.uncoveredCardsStackTableaus();
		
		assertEquals(7, coveredCardsStackTableaus.size());
		assertEquals(7, uncoveredCardsStackTableaus.size());
		
		for(Integer coveredCards : coveredCardsStackTableaus){
			assertEquals(new Integer(1),coveredCards);
		}
		
		for (int i = 0; i < coveredCardsStackTableaus.size(); i++) {
			assertEquals(new Integer(i), coveredCardsStackTableaus.get(i));
		}
		
		for (Stack<Card> uncoveredCardsStack : uncoveredCardsStackTableaus) {
			assertEquals(1, uncoveredCardsStack.size());
			assertTrue(uncoveredCardsStack.peek().isUncovered()); //cima
		}
	}
	
	@Test
	public void totalCardsTest(){
		int cardsNumber=0;
		
		cardsNumber += startGameController.sizeDeck();
		cardsNumber += startGameController.sizeWaste();
		
		//ArrayList<Integer> sizeTableaus = startGameController.sizeCoveredCardsTableaus();
		/*ArrayList<Stack<Card>> uncoveredCardsStackTableaus = startGameController.uncoveredCardsStackTableaus();
		
		for (int i = 0; i < sizeTableaus.size(); i++) {
			cardsNumber += sizeTableaus.get(i);
		}*/
		/*
		for (Stack<Card> uncoveredCardsStack : uncoveredCardsStackTableaus) {
			cardsNumber += uncoveredCardsStack.size();
		}
		*/
		assertEquals(52, cardsNumber);
	}
}
