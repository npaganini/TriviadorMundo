import java.util.Set;

public class Player {

	private Integer playerNumber;
	private String name;
	private Set<Territory> territories;
	private Integer amountArmies;
	
	public Player(String name, Set<Territory> territories, Integer amountArmies) {
		this.name = name;
		this.territories = territories;
		this.amountArmies = amountArmies;
	}

	public Integer getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Territory> getTerritories() {
		return territories;
	}
	
	public void setTerritories(Set<Territory> territories) {
		this.territories = territories;
	}
	
	public Integer getAmountArmies() {
		return amountArmies;
	}
	
	public void setAmountArmies(Integer amountArmies) {
		this.amountArmies = amountArmies;
	}
	
	public void moveArmies( Integer quantity, Territory t1, Territory t2)throws IllegalArgumentException {
		Integer available= t1.getAmountArmies();
		if ( available <= quantity ) {
			t2.addArmies(quantity);
			t1.loseArmies(quantity);
		} else {
			throw new IllegalArgumentException("Cantidad incorrecta");
		}
	}
	
}