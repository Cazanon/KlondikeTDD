package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import models.Card;
import models.CardSuite;
import models.DeckStack;
import models.FoundationStack;
import models.TableauStack;
import models.WasteStack;


public class StartGameController {

	private DeckStack deckStack;
	private WasteStack wasteStack;
	private List<TableauStack> tableaus;
	private List<FoundationStack> foundations;
	
	public StartGameController(){
		deckStack = new DeckStack();
		
		wasteStack = new WasteStack();
		
		tableaus = new ArrayList<TableauStack>();
		for(int i=0;i<7;i++){
			tableaus.add(new TableauStack());
		}
		generateCards(deckStack,tableaus);
		
		foundations = new ArrayList<FoundationStack>();
		for(int i=0;i<4;i++){
			foundations.add(new FoundationStack());
		}
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
			tableaus.get(i).peek().setCovered(false);
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
		for(FoundationStack foundation : foundations){
			sizeFoundations.add(foundation.size());
		}
		return sizeFoundations;
	}

	public ArrayList<Integer> sizeCoveredCardsStackTableaus() {
		ArrayList<Integer> sizeCoveredCardsTableaus = new ArrayList<Integer>();
		for(TableauStack tableau : tableaus){
			sizeCoveredCardsTableaus.add(tableau.getCoveredCards());
		}
		return sizeCoveredCardsTableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = new ArrayList<Stack<Card>>();
		for(TableauStack tableau : tableaus){
			uncoveredCardsStackTableaus.add(tableau.getUncoveredCards());
		}
		return uncoveredCardsStackTableaus;
	}

	public List<TableauStack> getTableaus() {
		return tableaus;
	}
	
	public Stack<Card> getCards(){		
		Stack<Card> totalCards = new Stack<Card>();
		
		totalCards.addAll(deckStack);
		totalCards.addAll(wasteStack);
		
		for(Stack<Card> stackCard : tableaus){
			totalCards.addAll(stackCard);
		}
		
		for(Stack<Card> stackCard : foundations){
			totalCards.addAll(stackCard);
		}
		
		return totalCards;		
	}

}
