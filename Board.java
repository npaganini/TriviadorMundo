package triviadormundo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
	private Set<Territory> territories;
	private ArrayList<Player> players;
	private Set<MultipleChoiceQuestion> multipleChoiceQuestions;
	private Set<AproximationQuestion> aproximationQuestions;
	private Player activePlayer;
	private Player defendingPlayer;
	private Player firstPlayer;
	private Integer turnCount;
	private Integer roundCount;
	private final static Integer MAX_ROUNDS = 9;
	
	
	public Board() {
		Set<Territory> territories = new HashSet<Territory>();
		List<Player> players = new ArrayList<Player>();
		Set<MultipleChoiceQuestion> multipleChoiceQuestions = new HashSet<MultipleChoiceQuestion>();
		Set<AproximationQuestion> aproximation = new HashSet<AproximationQuestion>();
		this.activePlayer = null;
		this.defendingPlayer = null;
		this.firstPlayer = null;
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
	public void addPlayer(Player player) {
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
	private Question pickAQuestion(HashSet<Question> set) {
		for(Question q: set) {
			if(q.asked == false) {
				q.asked = true;
				return q;
			}
		}
	}
	public AproximationQuestion getAproximationQuestions() {
		return pickAQuestion(aproximationQuestions);
	}
	public MultipleChoiceQuestion getMultipleChoiceQuestions() {
		return pickAQuestion(multipleChoiceQuestions);
	}
	public Player getActivePlayer() {
		return activePlayer;
	}
	public Player getDefendingPlayer() {
		return defendingPlayer;
	}
	public void changeTurn() {
		if()
		//roundCount++;
		//turnCount = 0;
	}
	public void setStartingPlayer() {
		if(activePlayer == null) {
			activePlayer = player;
			firstPlayer = player;
		}
	}
	public void distributeTerritories() {
		return;
	}
	public void battle(Territory active, Territory defending) {
		return;
	}
	public Player getWinner() {
		return;
	}
	public Boolean hasTerritories(Player player) {
		return false;
	}
}
