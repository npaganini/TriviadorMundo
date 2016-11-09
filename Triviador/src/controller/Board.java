package controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.Answer;
import model.AproximationQuestion;
import model.MultipleChoiceQuestion;
import model.NotAdjacentException;
import model.Player;
import model.Territory;
import view.ApproximationQuestionsInterface;
import view.MultipleQuestionsInterface;

public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<Territory> territories;
	private ArrayList<Player> players;
	private Set<MultipleChoiceQuestion> multipleChoiceQuestions;
	private Set<AproximationQuestion> aproximationQuestions;
	private Player activePlayer;
	private Player defendingPlayer;
	private Integer turnCount;
	private Integer roundCount;
	private final static Integer MAX_ROUNDS = 9;
	
	
	public Board() {
        this.territories = new HashSet<>();
        this.players = new ArrayList<>();
        this.multipleChoiceQuestions = new HashSet<MultipleChoiceQuestion>();
        this.aproximationQuestions = new HashSet<AproximationQuestion>();
		this.activePlayer = null;
		this.defendingPlayer = null;
		this.turnCount = 0;
		this.roundCount = 0;
	}
	
	
	public void addTerritory(Territory territory) {
		territories.add(territory);
		return;
	}
	public void removeTerritory(Territory territory) {
		territories.remove(territory);
		return;
	}
    private void setStartingPlayer(Player player) {
        if(activePlayer == null) {
            activePlayer = player;
        }
    }
	public void addPlayer(Player player) {
        if(players.isEmpty()) {
            setStartingPlayer(player);
        }
		players.add(player);
		player.setPlayerNumber(players.size()-1);
	}
	public void removePlayer(Player player) {
		players.remove(player);
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void addQuestion(MultipleChoiceQuestion question) {
		multipleChoiceQuestions.add(question);
	}
	public void addQuestion(AproximationQuestion question) {
		aproximationQuestions.add(question);
	}
	public AproximationQuestion getAproximationQuestions() {
        for(AproximationQuestion q: aproximationQuestions) {
                return q;
        }
        return null;
	}
	public MultipleChoiceQuestion getMultipleChoiceQuestions() {
        for(MultipleChoiceQuestion q: multipleChoiceQuestions) {
                return q;
        }
        return null;
	}
	public Player getActivePlayer() {
		return activePlayer;
	}
	public Player getDefendingPlayer() {
		return defendingPlayer;
	}
	private void nextPlayer() {
        int auxIndex = players.lastIndexOf(activePlayer) + 1;
        if(auxIndex == players.size()) {
            auxIndex = 0;
        }
        activePlayer = players.get(auxIndex);
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

	public void distributeTerritories() {
		int i = 0;  /* Este metodo solo se usa al principio de la partida! */
		for(Territory t: territories) {
			territories.add(t);
            players.get(i%3).addTerritories(t);
            i++;
		}
	}
	public void battle(Territory active, Territory defending) throws Exception {
		Player[] possibleWinner = {active.getOwner(), null};
		
		if(!defending.isAdjacent(active)) {
            throw new NotAdjacentException("" + active.getName() + " can't attack " + defending.getName());
        }
        
        MultipleChoiceQuestion multipleChoiceQuestion = getMultipleChoiceQuestions();
        MultipleQuestionsInterface window1 = new MultipleQuestionsInterface(multipleChoiceQuestion, active.getOwner(), defending.getOwner());
		ApproximationQuestionsInterface window2;
        window1.getFrame().setVisible(true);
		
		if(window1.getAnswer().getWinner().length == 2) {
			do {
				AproximationQuestion aproximationQuestion = getAproximationQuestions();
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
	public Boolean hasTerritories(Player player) {
		if(player.getTerritories().isEmpty()) {
            return false;
        }
        return true;
	}
}
