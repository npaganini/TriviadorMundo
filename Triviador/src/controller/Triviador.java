package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.AproximationQuestion;
import model.Board;
import model.MultipleChoiceQuestion;
import model.Player;
import model.Territory;

public class Triviador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Board board;
	private ArrayList<Player> players;
	private ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions;
	private ArrayList<AproximationQuestion> aproximationQuestions;
	private Player activePlayer;
	private Territory attackingTerritory;
	private Territory defendingTerritory;
	private Integer turnCount;
	private Integer roundCount;
	private Player gameWinner;
	private final static Integer MAX_ROUNDS = 9;
	
	public Triviador() {
		board = new Board();
		players = new ArrayList<Player>();
		addPlayers();
		multipleChoiceQuestions = new ArrayList<MultipleChoiceQuestion>();
		addMultipleChoiceQuestions();
		aproximationQuestions = new ArrayList<AproximationQuestion>();
		addAproximationQuestions();
		activePlayer = null;
		attackingTerritory = null;
		defendingTerritory = null;
		turnCount = 0;
		roundCount = 0;
		gameWinner=null;
		
	}

	public void addPlayers() {
		players.add(new Player("Jugador 1"));
		players.add(new Player("Jugador 2"));
		players.add(new Player("Jugador 3"));
	}
	
	public void addMultipleChoiceQuestions() {
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien es el entrenador de Rafael Nadal?", new String[] {"Su tio", "Ismael Rodriguez", "Joathan Gonzaga", "Su padre"}, 3 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Como obtuvo JAck los boletos para viajan en el Titanic (en la pelicula Titanic)?", new String[] {"En un juego de poker", "Lo compro", "En una apuesta", "En un juego de Bingo"}, 3 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual de estos eventos no forma parte del triatlon “Hombres de hierro?", new String[] {"Ciclismo", "Carreras a caballo", "Natacion", "Carreras de larga distancia"}, 0 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Donde se origino el voleibol?", new String[] {"Las Vegas", "Nueva York", "Londres", "Massachussets"}, 0 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Como se llama el cantante de Metallica?", new String[] {"Axel Rose", "James Hetfield", "Roger Daltrey", "James Franco"}, 3 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("En que arbol crecen los datiles?", new String[] {"Palmera", "Sauce", "Tilo", "Ninguno"}, 0 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual es el segundo idioma mas hablado?", new String[] {"Español", "Ingles", "Frances", "Chino"}, 1 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual es el nombre de pila del cantante Bieber?", new String[] {"Steven", "Justin", "Mary", "John"}, 1));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual es la identidad secreta de Clark Kent?", new String[] {"Batman", "Harry Potter", "Esteban Kramer", "Superman"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien gano el Oscar a mejor actor en el 2015?", new String[] {"Leonardo DiCaprio", "Tom Hanks", "Eddie Redmayne", "Matthew McConaughey"}, 2));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien gano el FIFA Balon de Oro en el 2015?", new String[] {"Lionel Messi", "Cristiano Ronaldo", "Diego Maradona", "Juan Roman Riquelme"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cuales de los siguientes temas no entraban al 1er parcial del 2do cuatrimestre del 2016?", new String[] {"Diagramas UML", "Collections", "Metaprogramming", "Iterators"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual era hasta el 2015 el video mas visto en Youtube?", new String[] {"Sorry de Justin Bieber", "Vlog del Fin del Mundo de Jonathan Katan", "Uptown Funk de Bruno Mars", "Gangnam Style de Psy"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual de los siguientes no es un dios de la mitologia griega?", new String[] {"Zeus", "Apolo", "Borr", "Baco"}, 2));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual de los siguientes juegos RTS fue el primero en lanzarse?", new String[] {"Command & Conquer: Red Alert 2", "Age of Empires II: The Age of Kings", "Warhammer 40000: Dawn of War", "Warcraft III: Reign of Chaos"}, 1));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien fue el DJ #1 segun la revista DJ MAG en el 2015?", new String[] {"Dimitri Vegas & Like Mike", "Skrillex", "David Guetta", "Hardwell"}, 0));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual de los siguientes no es un desierto?", new String[] {"Sahara", "Antartida", "Atacama", "Malesia"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien es mayor?", new String[] {"Gaidamac", "Mirtha Legrand", "Susana Gimenez", "Carmen Barbieri"}, 0));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual es la primera regla del Club de la Pelea?", new String[] {"Se debe pelear sin camisa", "Se debe pelear sin zapatos", "No hay reglas", "No hablar del Club de la Pelea"}, 2));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("De donde proviene el reggae?", new String[] {"Cuba", "Haiti", "Jamaica", "Republica Dominicana"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Quien pinto La Sagrada Familia del Cordero?", new String[] {"Rafael Sanzio", "Velazquez", "Giorgione", "Paul Klee"}, 0));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Como murio la poetisa Alfonsina Storni?", new String[] {"En un accidente automovilistico", "Fue asesinada", "De muerte natural", "Se suicido"}, 3));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("En que era aparecieron los dinosaurios?", new String[] {"Paleozoica", "Mesozoica", "Precambrica", "Cenozoica"}, 1));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Como se llama la snesibilidad dolorosa de los sonidos?", new String[] {"Hipocusia", "Hiperacusia", "Micropsia", "Hipoalgesia"}, 1));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Como se mide la fuerza del viento en el mar?", new String[] {"Pies", "Nudos", "Zancadas", "Kilometros por hora"}, 1));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual de estos paises africanos NO tiene costa?", new String[] {"Sudafrica", "Tunez", "Chad", "Marruecos"}, 2));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cual es la capital de Finlandia?", new String[] {"Helsinki", "Berna", "Estocolmo", "Oslo"}, 0));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Que ciudad tiene mas poblacion?", new String[] {"Rio Cuarto", "Tandil", "La Plata", "Viedma"}, 2));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Cuantos siglos duro El Siglo de Oro?", new String[] {"Dos", "Uno", "Tres", "Medio"}, 0));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("Para que fue creado el plan MArshall en 1947?", new String[] {"Regalo", "Conquista", "Reconstruccion", "Comercio"}, 2));


		
	}
	
	public void addAproximationQuestions() {
		aproximationQuestions.add(new AproximationQuestion("En que ano se independizo Argentina?", 1816));
		aproximationQuestions.add(new AproximationQuestion("Cuantos ganadores del premios nobel son argentinos?", 5));
		aproximationQuestions.add(new AproximationQuestion("Cuantos miles de millones vivian en China en el 2013?", 1357));
		aproximationQuestions.add(new AproximationQuestion("En que ano se fundo el ITBA?", 1959));
		aproximationQuestions.add(new AproximationQuestion("Cuantos mogul vienen en un paquete de Moguls?", 8));
		aproximationQuestions.add(new AproximationQuestion("Cuantos dientes permanentes tiene un ser humano promedio?", 32));
		aproximationQuestions.add(new AproximationQuestion("En que año murio Francisco Franco?", 1975));
		aproximationQuestions.add(new AproximationQuestion("En que año comenzo la Revolucion Francesa?", 1789));
		aproximationQuestions.add(new AproximationQuestion("En que año fallecio Steve Jobs?", 2011));
		aproximationQuestions.add(new AproximationQuestion("En que año se descubrio la tumba de Tutankhamon?", 1921));
		aproximationQuestions.add(new AproximationQuestion("En que año tuvo lugar el ataque a Pearl Harbor?", 1941));
		aproximationQuestions.add(new AproximationQuestion("Cuantos soldados argentinos murieron en la Guerra de las Malvinas?", 649));
		aproximationQuestions.add(new AproximationQuestion("Cuantos siglos duro El Siglo de Oro ?", 2));
		aproximationQuestions.add(new AproximationQuestion("A cuantas personas mato Tiburon en su primer pelicula ?", 11));
		
	}
	
	public MultipleChoiceQuestion getMultipleChoiceQuestion() {
		Collections.shuffle(multipleChoiceQuestions);
		MultipleChoiceQuestion question = multipleChoiceQuestions.get(0);
		multipleChoiceQuestions.remove(0);
		return question;	
	}
	
	public AproximationQuestion getAproximationQuestion() {
		Collections.shuffle(aproximationQuestions);
		AproximationQuestion question = aproximationQuestions.get(0);
		aproximationQuestions.remove(0);
		return question;	
	}
	
	public void changeTurn() {
        for(Player p: players) {
        	if(!hasTerritories(p)) {
        		players.remove(p);
        	}
        }
        if(turnCount == (players.size()-1)) {
            turnCount = 0;
            roundCount++;
            if(roundCount == MAX_ROUNDS) {
                Player winner = getWinner();
                this.setGameWinner(winner);
            }
            nextPlayer();
        } else {
            turnCount++;
        }
        if(players.size() == 1) {
        	this.setGameWinner(getWinner());
        	return;
        }
        nextPlayer();
	}
	
	private void nextPlayer() {
        int auxIndex = players.lastIndexOf(activePlayer) + 1;
        if(auxIndex == players.size()) {
            auxIndex = 0;
        }
        activePlayer = players.get(auxIndex);
    }
	
	/**
	 * Checks amount of territories to assign a winner.
	 * @returns Player who won.
	 */
	public Player getWinner() {
        Integer max = 0;
        for(Player p: players) {
            if(p.getTerritories().size() > max) {
                max = p.getTerritories().size();
            }
        }
        for(Player p: players) {
            if(p.getTerritories().size() == max && max != 0) {
                return p;
            }
        }
		return null;
	}

	public Boolean hasTerritories(Player player) {
		if(player.getTerritories().isEmpty()) {
            return false;
        }
        return true;
	}
	
	public void startNewGame() {
		board.distributeTerritories(players);
		activePlayer = players.get(0);
		roundCount = 1;
	}
	
	public Territory stringToTerritory(String s) {
		for(Territory t: board.getTerritories()) {
			if(s == t.getName())
				return t;
		}
		return null;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public Integer getTurnCount() {
		return turnCount;
	}

	public Integer getRoundCount() {
		return roundCount;
	}

	public static Integer getMaxRounds() {
		return MAX_ROUNDS;
	}
	
	public Player getPlayer1() {
		return players.get(0);
	}
	
	public Player getPlayer2() {
		return players.get(1);
	}
	
	public Player getPlayer3() {
		return players.get(2);
	}

	public Territory getAttackingTerritory() {
		return attackingTerritory;
	}

	public void setAttackingTerritory(Territory attackingTerritory) {
		this.attackingTerritory = attackingTerritory;
	}
	
	public void setGameWinner(Player player){
		gameWinner=player;
	}
	
	public Player getGameWinner(){
		return gameWinner;
	}

	public Territory getDefendingTerritory() {
		return defendingTerritory;
	}

	public void setDefendingTerritory(Territory defendingTerritory) {
		this.defendingTerritory = defendingTerritory;
	}
	
}
