package model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	}
	public void removePlayer(Player player) {
		players.remove(player);
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
//	public void battle(Territory active, Territory defending) throws Exception {
//        Player pAux = activePlayer;
//        if(!defending.isAdjacent(active)) {
//            throw new NotAdjacentException("" + active.getName() + " can't attack " + defending.getName());
//        }
//        // Deberia fijarse si los territorios son adyacentes
//        getMultipleChoiceQuestions().print();   // Llamado a controller para que muestre pregunta y devuelva las rtas
//        // Ask for answer, get an object "Answer" with the 2 answers from the different players
//        if(answer.player1 == answer.player2) {
//            getAproximationQuestions().print(); // Devuelta no deberia estar aca
//        }
//        pAux = assignWinner();         // A este le deberia llegar el ganador de la pregunta
//        if(pAux == activePlayer) {
//            active.setOwner(activePlayer);
//        }
//	}
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
