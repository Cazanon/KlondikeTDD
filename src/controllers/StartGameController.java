package controllers;

import java.util.ArrayList;
import java.util.Stack;

import models.Card;
import models.CardSuite;


public class StartGameController {

	public int sizeWaste() {
		return 0;
	}

	public int sizeDeck() {
		return 24;
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
