package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Answer;
import model.AproximationQuestion;
import model.Board;
import model.MultipleChoiceQuestion;
import model.NotAdjacentException;
import model.Player;
import model.Territory;
import view.ApproximationQuestionsInterface;
import view.MultipleQuestionsInterface;

public class Triviador {
	private Board board;
	private ArrayList<Player> players;
	private ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions;
	private ArrayList<AproximationQuestion> aproximationQuestions;
	private Player activePlayer;
	private Integer turnCount;
	private Integer roundCount;
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
		turnCount = 0;
		roundCount = 0;
		
	}

	public void addPlayers() {
		players.add(new Player("Jugador 1"));
		players.add(new Player("Jugador 2"));
		players.add(new Player("Jugador 3"));
	}
	
	public void addMultipleChoiceQuestions() {
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("¿En qué deporte se usa tiza?", new String[] {"Futbol", "Tenis", "Golf", "Pool"}, 3 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("¿Cuantas manos tiene un caballo?", new String[] {"0", "2", "3", "4"}, 1 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("¿Cuales son las dos primeras palabras de la Biblia?", new String[] {"Una vez", "Al comienzo", "Al principio", "En ese"}, 2 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("¿En que arbol crecen los datiles?", new String[] {"Palmera", "Sauce", "Tilo", "Ninguno"}, 0 ));
		multipleChoiceQuestions.add(new MultipleChoiceQuestion("¿Cual es el segundo idioma mas hablado?", new String[] {"Español", "Ingles", "Frances", "Chino"}, 1 ));
	}
	
	public void addAproximationQuestions() {
		aproximationQuestions.add(new AproximationQuestion("¿En que año se independizo Argentina?", 1816));
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
        if(turnCount == (players.size()-1)) {
            turnCount = 0;
            roundCount++;
            if(roundCount == MAX_ROUNDS) {
                getWinner();                                    // ACA DEBERIA TERMINAR EL JUEGO!
                return;
            }
            nextPlayer();
        } else {
            turnCount++;
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
	
	public Player getWinner() {
        Integer max = 0;
        for(Player p: players) {
            if(p.getAmountArmies() > max) {
                max = p.getAmountArmies();
            }
        }
        for(Player p: players) {
            if(p.getAmountArmies() == max && max != 0) {
                return p;
            }
        }
		return null;
	}
	
	public void battle(Territory active, Territory defending) throws Exception {
		Player[] possibleWinner = {active.getOwner(), null};
		
		if(!defending.isAdjacent(active)) {
            throw new NotAdjacentException("" + active.getName() + " can't attack " + defending.getName());
        }
        
        MultipleChoiceQuestion multipleChoiceQuestion = getMultipleChoiceQuestion();
        MultipleQuestionsInterface window1 = new MultipleQuestionsInterface(multipleChoiceQuestion, active.getOwner(), defending.getOwner());
		ApproximationQuestionsInterface window2;
        window1.getFrame().setVisible(true);
		
		if(window1.getAnswer().getWinner().length == 2) {
			do {
				AproximationQuestion aproximationQuestion = getAproximationQuestion();
				window2 = new ApproximationQuestionsInterface(aproximationQuestion, active.getOwner(), defending.getOwner());
				window2.getFrame().setVisible(true);
			}
			while(window2.getAnswer().getWinner().length == 2);
			
			if(window2.getAnswer().getWinner().equals(possibleWinner)) {
				defending.setOwner(active.getOwner());
				defending.getOwner().removeTerritories(defending);
				active.getOwner().addTerritories(defending);
				defending.addArmies(active.getAmountArmies());
			}
		} else if(window1.getAnswer().getWinner().equals(possibleWinner)) {
			defending.setOwner(active.getOwner());
			defending.getOwner().removeTerritories(defending);
			active.getOwner().addTerritories(defending);
			defending.addArmies(active.getAmountArmies());
		}
	}
	
	public static String getCorrectAnswers(Player attackingPlayer, Player defendingPlayer, MultipleChoiceQuestion question, Answer answer) {
		if(question.getCorrectAnswer().equals(answer.getAnswerAttacking())) {
			if(question.getCorrectAnswer().equals(answer.getAnswerDefending())) {
				Player[] winner = {attackingPlayer, defendingPlayer};
				answer.setWinner(winner);
				return "Both players answered correctly";
			}
			else {
				Player[] winner = {attackingPlayer};
				answer.setWinner(winner);
				return "Attacking player answered correctly";
			}
		}
		else if(question.getCorrectAnswer().equals(answer.getAnswerDefending())) {
			Player[] winner = {defendingPlayer};
			answer.setWinner(winner);
			return "Defending player answered correctly";
		}
		else {
			return "Neither player answered correcly";
		}
	}
	
	public static String getCorrectAnswers(Player attackingPlayer, Player defendingPlayer, AproximationQuestion question, Answer answer) {
		Integer answerAttacking = Math.abs(question.getAnswer() - Integer.parseInt(answer.getAnswerAttacking()));
		Integer answerDefending = Math.abs(question.getAnswer() - Integer.parseInt(answer.getAnswerDefending()));
		
		if(answerAttacking < answerDefending) {
			Player[] winner = {attackingPlayer};
			answer.setWinner(winner);
			return "Attacking player is closer than defending player";
		}
		else if(answerAttacking > answerDefending) {
			Player[] winner = {defendingPlayer};
			answer.setWinner(winner);
			return "Defending player is closer than attacking player";
		}
		else {
			Player[] winner = {attackingPlayer, defendingPlayer};
			answer.setWinner(winner);
			return "Both players answered " + answer.getAnswerAttacking() + " and the answer was: " + question.getAnswer() + ". Lets try again";
		}
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
	
	public void saveGame () {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/controller/saves/out.bin"));
			out.writeObject(this.board);
			out.close();
		} catch (IOException i) {
			i.printStackTrace(); 
		}
	}
	
	public void loadGame() {
		Board game = null;
		try {
			FileInputStream file = new FileInputStream("src/controller/saves/out.bin");
			ObjectInputStream input = new ObjectInputStream(file);
			game = (Board) input.readObject();
			input.close();
			file.close();
		} catch (IOException i) {
			System.out.println("Error 404 Game not found");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if( game!= null) {
			this.board = game;
		}
	}
}
