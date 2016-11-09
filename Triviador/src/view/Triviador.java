package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.*;

public class Triviador implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		GameBoard gameBoard = new GameBoard();
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
		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("¿En qué deporte se usa tiza?", new String[] {"Futbol", "Tenis", "Golf", "Pool"}, 4 );
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("¿Cuantas manos tiene un caballo?", new String[] {"0", "2", "3", "4"}, 2 );
		MultipleChoiceQuestion q3 = new MultipleChoiceQuestion("¿Cuales son las dos primeras palabras de la Biblia?", new String[] {"Una vez", "Al comienzo", "Al principio", "En ese"}, 3 );
		MultipleChoiceQuestion q4 = new MultipleChoiceQuestion("¿En que arbol crecen los datiles?", new String[] {"Palmera", "Sauce", "Tilo", "Ninguno"}, 1 );
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("¿Cual es el segundo idioma mas hablado?", new String[] {"Español", "Ingles", "Frances", "Chino"}, 2 );
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
		Territory americaDelSur = new Territory("America del Sur", 100, player1);
		Territory americaCentral = new Territory("America Central", 100, player2);
		Territory americaDelNorte = new Territory("America del Norte", 100, player3);
		Territory poloNorte = new Territory("Polo Norte", 100, player3);
		Territory europa = new Territory("Europa", 100, player2);
		Territory africa = new Territory("Africa", 100, player1);
		Territory medioOriente = new Territory("MedioOriente", 100, player1);
		Territory asia = new Territory("Asia", 100, player2);
		Territory oceania = new Territory("Oceania", 100, player3);
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
		System.out.println("Agregue Territorios");
		//CREO EL BOARD
		Board board = new Board(territories, players, multipleChoiceQuestions, aproximationQuestions);
		board.setStartingPlayer(player1);
		System.out.println("Cree Board y puse active Player");
		//LOOP DEL JUEGO
		while(board.getRoundCount()<board.getMaxRounds()){
			gameBoard.setCurrentPlayer(board.getActivePlayer().getName());
			gameBoard.setCurrentTurn("" + board.getRoundCount()); //pongo el "" para convertirlo a string
			
			for( Territory territory: territories) {
				switch(territory.getName()) {
				case americaDelSur:
				int x= ;
				int y= ;
				break;
				// le agregamos coordenadas al territory o hago este switch?
			}
			
		}
		
		public void saveBoard(){
				ObjectOutputStream file = new ObjectOutputStream(
			      					new BufferedOutputStream(
			      					new FileOutputStream("triviador.out")));
				file.writeObject(triviador.board);
				file.close();
		}		
				
		
		System.out.println("Termina loop del juego");
		
		
		
		
	}
}
