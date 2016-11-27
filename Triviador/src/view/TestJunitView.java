package view;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;

import controller.Triviador;
import model.Answer;

public class TestJunitView {
	Triviador trivTest = new Triviador();
	StartGameInterface sgi = new StartGameInterface(trivTest);
	JFrame jf = new JFrame();
	MultipleQuestionsInterface mqi = new MultipleQuestionsInterface(trivTest);
	// GameBoard gmb = new Gameboard(trivTest);
	
	@Test
	public void testCheckGetFrame() {
		jf = sgi.getFrame();
		Answer ans = new Answer();
		// mqi.getCorrectAnswers();
		assertEquals(jf, sgi.getFrame());
		// assertEquals(ans, mqi);
	}
}
