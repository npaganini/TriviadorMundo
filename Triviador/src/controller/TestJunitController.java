package controller;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunitController {
	static final int MAX_ROUNDS = 9;
	
	Triviador controllerTest = new Triviador();
	
	@Test
	public void testCheckChngTurn() {
		controllerTest.changeTurn();
		int turnCount = controllerTest.getTurnCount() + 1;
		int roundCount = controllerTest.getRoundCount() + 1;
		System.out.println(turnCount);
		assertEquals(turnCount, 2);
		assertEquals(roundCount, 1);
	}
}
	
/*
	@Test
	public void testCheckChngTurn() {
		controllerTest.changeTurn();
		int turnCount = controllerTest.getTurnCount() + 1;
		//int turnCount = controllerTest.getTurnCount() + 1;
		int roundCount = controllerTest.getRoundCount() + 1;
		assertEquals(turnCount, 2);
		assertEquals(roundCount, 1);
		
		for(int i = 0; i < MAX_ROUNDS * 3; i++) {
			controllerTest.changeTurn();
		}
		*/
		//assertEquals()

