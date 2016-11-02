import java.util.Set;

public class Territory {

	private String name;
	private Set<Territory> adjacents;
	private Integer amountArmies;
	private Player owner;
	
	public Territory(String name, Set<Territory> adjacents, Integer amountArmies, Player owner) {
		super();
		this.name = name;
		this.adjacents = adjacents;
		this.amountArmies = amountArmies;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Territory> getAdjacents() {
		return adjacents;
	}
	
	public void setAdjacents(Set<Territory> adjacents) {
		this.adjacents = adjacents;
	}
	
	public Integer getAmountArmies() {
		return amountArmies;
	}
	
	public void setAmountArmies(Integer amountArmies) {
		this.amountArmies = amountArmies;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Boolean isAdjacent( Territory t ) {
		return this.adjacents.contains(t);
	}
	
	public void addArmies(Integer n) {
		amountArmies+=n;
	}
	
	public void loseArmies(Integer n) {
		amountArmies-=n;
	}
	
}
