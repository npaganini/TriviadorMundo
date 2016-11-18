package model;

import org.junit.Test;

import controller.Triviador;

import static org.junit.Assert.*;

import java.io.Serializable;

public class TestJunitModel {
	Player p1 = new Player("Tester1");
	Player p2 = new Player("Tester2");
	Climate c = new Climate(2);
	MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("Hello World!", new String[] {"Yes", "No", "Maybe"}, 0);
	AproximationQuestion aq = new AproximationQuestion("Hello World too!", 2);
	Answer ans = new Answer();
	
	@Test
	public void testCheckClimate() {
		c.decreaseRemainingDifficulty();
		c.decreaseRemainingDifficulty();
		assertEquals(new Integer(0), c.getRemainingDifficulty());
		c.restoreRemainingDifficulty();
		assertEquals(c.getDifficulty(), c.getRemainingDifficulty());
	}
	@Test
	public void testCheckTerritory() {
		Territory t1 = new Territory("TestTerri", 100, c);
		Territory t2 = new Territory("TestTerry", 200, c);
		t1.addAdjacents(t2);
		t2.addAdjacents(t1);
		assertEquals(t1.getAdjacents().size(), t2.getAdjacents().size(), 1);
	}
	@Test
	public void testCheckPlayer() {
		Territory t = new Territory("TestTerry", 200, c);
		p1.addTerritories(t);
		assertEquals(1, p1.getTerritories().size());
	}
	@Test
	public void testCheckMCQ() {
		assertEquals("Yes", mcq.getCorrectAnswer());
	}
	@Test
	public void testCheckAQ() {
		assertEquals(new Integer(2), aq.getAnswer());
	}
	@Test
	public void testCheckAnswer() {
		Player[] aux = new Player[] {p1, p2};
		ans.setAnswerAttacking("True");
		ans.setAnswerDefending("True");
		ans.setWinner(aux);
		assertEquals(ans.getAnswerAttacking(), ans.getAnswerDefending());
		assertArrayEquals(aux, ans.getWinner());
	}
	@Test
	public void testCheckSaveLoad() {
		Triviador trivTest = new Triviador();
		FileManager fm = new FileManager(trivTest);
		fm.saveGame(trivTest);
		assertTrue(fm.loadGame().getClass() instanceof Serializable);
	}
}
