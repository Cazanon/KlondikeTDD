package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import models.Card;
import models.CardSuite;
import models.DeckStack;
import models.TableauStack;
import models.WasteStack;


public class StartGameController {

	private DeckStack deckStack;
	private WasteStack wasteStack;
	private List<TableauStack> tableaus;
	
	public StartGameController(){
		deckStack = new DeckStack();
		wasteStack = new WasteStack();
		tableaus = new ArrayList<TableauStack>();
		for(int i=0;i<7;i++){
			tableaus.add(new TableauStack());
		}
		generateCards(deckStack,tableaus);
	}
	
	private void generateCards(DeckStack deckStack, List<TableauStack> tableaus) {
		Stack<Card> allCards = new Stack<Card>();
		
		for(CardSuite cardSuite : CardSuite.values()){
			for(int i=Card.MIN_VALUE;i<=Card.MAX_VALUE;i++){
				allCards.push(new Card(i,cardSuite));
			}
		}
		
		Random random = new Random();	
		while(deckStack.size()!=DeckStack.MAX_CARDS){
			int randomOrder = random.nextInt(allCards.size());
			if(allCards.get(randomOrder)!=null){
				deckStack.push(allCards.get(randomOrder));
				allCards.remove(randomOrder);
			}				
		}
		
		for(int i=0;i<7;i++){
			while(tableaus.get(i).size()!=i+1){
				int randomOrder = random.nextInt(allCards.size());
				if(allCards.get(randomOrder)!=null){
					tableaus.get(i).push(allCards.get(randomOrder));
					allCards.remove(randomOrder);
				}
			}
		}
	}

	public int sizeWaste() {
		return wasteStack.size();
	}

	public int sizeDeck() {
		return deckStack.size();
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			sizeFoundations.add(0);
		}
		return sizeFoundations;
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> sizeCoveredCardsTableaus = new ArrayList<Integer>();
		for(int i=0;i<7;i++){
			sizeCoveredCardsTableaus.add(i);
		}
		return sizeCoveredCardsTableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = new ArrayList<Stack<Card>>();
		for(int i=0;i<7;i++){
			Card card = new Card(1,CardSuite.CLUB);
			Stack<Card> stackCard = new Stack<Card>();
			stackCard.add(card);
			uncoveredCardsStackTableaus.add(stackCard);
		}
		return uncoveredCardsStackTableaus;
	}

}
