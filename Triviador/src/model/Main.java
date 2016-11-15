package model;

import java.io.Serializable;
import controller.Triviador;
import view.StartGameInterface;

public class Main implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) throws Exception{	
		Triviador partida = new Triviador();
		@SuppressWarnings("unused")
		StartGameInterface startGame = new StartGameInterface(partida);
		
		/*//CREO EL BOARD
		StartGameInterface startingWindow = new StartGameInterface();
		startingWindow.getFrame().setVisible(true);
		Board board = new Board(territories, players, multipleChoiceQuestions, aproximationQuestions);
		board.setStartingPlayer(player1);
		GameBoard gameBoard = new GameBoard();
		System.out.println("Cree Board y puse active Player");
		
		//CREO INTERFACE DE MULTIPLE CHOICE
		Collections.shuffle(multipleChoiceQuestions);
		MultipleQuestionsInterface multipleQuestionInterface = new MultipleQuestionsInterface(multipleChoiceQuestions.get(0), player1, player2);
		//multipleQuestionInterface.setVisible(false);
		System.out.println("Cree la interfaz de preguntas multiple choice");
		
		//LOOP DEL JUEGO
		while(board.getRoundCount()<board.getMaxRounds()){
			gameBoard.setCurrentPlayer(board.getActivePlayer().getName());
			gameBoard.setCurrentTurn("" + board.getRoundCount()); //pongo el "" para convertirlo a string
			TimeUnit.SECONDS.sleep(3);
			board.battle(americaDelSur, americaCentral);
			gameBoard.setVisible(false);
			multipleQuestionInterface.setVisible(true);
			multipleQuestionInterface.setVisible(false);
			
			
		}
		
		System.out.println("Termina loop del juego");
		*/
		
		
		
	}
}
