package tests;

import static org.junit.Assert.assertEquals;

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
	
}
