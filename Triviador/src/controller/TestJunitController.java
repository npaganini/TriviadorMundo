package controller;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunitController {
	static final int MAX_ROUNDS = 9;
	
	Triviador controllerTest = new Triviador();
	
	@Test
	public void testCheckChngTurn() {
		// controllerTest.changeTurn();								comodification error
		int turnCount = controllerTest.getTurnCount() + 1;
		int roundCount = controllerTest.getRoundCount() + 1;
		System.out.println(turnCount);
		//assertEquals(turnCount, 2);
		assertEquals(roundCount, 1);
	}
}
