package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import controller.Board;
import model.*;

public class Triviador implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) throws Exception{	
		//CREO Y AGREGO PLAYERS
		Player player1 = new Player("Player1", 1000);
		Player player2 = new Player("Player2", 1000);
		Player player3 = new Player("Player3", 1000);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		System.out.println("Agregue Jugadores");
		
		//CREO Y AGREGO PREGUNTAS MULTIPLE CHOICE
		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("¿En qué deporte se usa tiza?", new String[] {"Futbol", "Tenis", "Golf", "Pool"}, 3 );
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("¿Cuantas manos tiene un caballo?", new String[] {"0", "2", "3", "4"}, 1 );
		MultipleChoiceQuestion q3 = new MultipleChoiceQuestion("¿Cuales son las dos primeras palabras de la Biblia?", new String[] {"Una vez", "Al comienzo", "Al principio", "En ese"}, 2 );
		MultipleChoiceQuestion q4 = new MultipleChoiceQuestion("¿En que arbol crecen los datiles?", new String[] {"Palmera", "Sauce", "Tilo", "Ninguno"}, 0 );
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("¿Cual es el segundo idioma mas hablado?", new String[] {"Español", "Ingles", "Frances", "Chino"}, 1 );
		ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions = new ArrayList<MultipleChoiceQuestion>();
		multipleChoiceQuestions.add(q1);
		multipleChoiceQuestions.add(q2);
		multipleChoiceQuestions.add(q3);
		multipleChoiceQuestions.add(q4);
		multipleChoiceQuestions.add(q5);
		System.out.println("Agregue MultipleChoiceQuestions");
		
		//CREO Y AGREGO PREGUNTAS POR APROXIMACION
		AproximationQuestion a1= new AproximationQuestion("¿En que año se independizo Argentina?", 1816);
		ArrayList<AproximationQuestion> aproximationQuestions = new ArrayList<AproximationQuestion>();
		aproximationQuestions.add(a1);
		System.out.println("Agregue AproximationQuestions");
		
		//CREO Y AGREGO TERRITORIOS
		Territory americaDelSur = new Territory("America del Sur", 100, player1, 187, 346);
		Territory americaCentral = new Territory("America Central", 100, player2, 138, 256);
		Territory americaDelNorte = new Territory("America del Norte", 100, player3, 88, 159);
		Territory poloNorte = new Territory("Polo Norte", 100, player3, 226, 34);
		Territory europa = new Territory("Europa", 100, player2, 368, 131);
		Territory africa = new Territory("Africa", 100, player1, 368, 294);
		Territory medioOriente = new Territory("MedioOriente", 100, player1, 508, 188);
		Territory asia = new Territory("Asia", 100, player2, 573, 98);
		Territory oceania = new Territory("Oceania", 100, player3, 613, 359);
		Set<Territory> territories = new HashSet<Territory>();
		territories.add(americaDelSur);
		territories.add(americaCentral);
		territories.add(americaDelNorte);
		territories.add(poloNorte);
		territories.add(europa);
		territories.add(africa);
		territories.add(medioOriente);
		territories.add(asia);
		territories.add(oceania);
		americaDelSur.addAdjacents(americaCentral);
		americaCentral.addAdjacents(americaDelSur);
		System.out.println("Agregue Territorios");
		
		//CREO EL BOARD
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
		
		
		
		
	}
}
