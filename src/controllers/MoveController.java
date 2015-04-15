package controllers;

import java.util.Stack;

import models.Card;

public class MoveController {

	public void move(Stack<Card> from, Stack<Card> to) {
		to.push(from.pop());		
	}

}
