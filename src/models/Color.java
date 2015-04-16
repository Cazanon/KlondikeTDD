package models;

import java.util.Arrays;
import java.util.List;

public class Color {

	public static final List<CardSuite> BLACK = Arrays.asList(CardSuite.CLUB,CardSuite.SPADE);
	public static final List<CardSuite> RED = Arrays.asList(CardSuite.HEART,CardSuite.DIAMOND);
	
	public static boolean isSameColor(Card card1,Card card2){
		if((BLACK.contains(card1.getCardSuite()) && BLACK.contains(card2.getCardSuite())) ||
		   (RED.contains(card1.getCardSuite()) && RED.contains(card2.getCardSuite()))){
			return true;
		}
		return false;
	}
	
}
