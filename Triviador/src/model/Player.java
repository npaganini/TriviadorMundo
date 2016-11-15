package model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Set<Territory> territories;
	private Integer amountArmies;
	
	public Player(String name) {
		this.name = name;
		this.territories = new HashSet<Territory>();
		amountArmies = 0;
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
	
	public void addTerritories(Territory territory) {
		territories.add(territory);
	}

	public void removeTerritories(Territory territory) {
		territories.remove(territory);
	}
	
	public Integer getAmountArmies() {
		return amountArmies;
	}
	
	public void addArmies(Integer amountArmies) {
		this.amountArmies += amountArmies;
	}
	
	public void moveArmies(Integer quantity, Territory t1, Territory t2)throws IllegalArgumentException {
		Integer available= t1.getAmountArmies();
		if ( available <= quantity ) {
			t2.addArmies(quantity);
			t1.loseArmies(quantity);
		} else {
			throw new IllegalArgumentException("Cantidad incorrecta");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountArmies == null) ? 0 : amountArmies.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((territories == null) ? 0 : territories.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (amountArmies == null) {
			if (other.amountArmies != null)
				return false;
		} else if (!amountArmies.equals(other.amountArmies))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (territories == null) {
			if (other.territories != null)
				return false;
		} else if (!territories.equals(other.territories))
			return false;
		return true;
	}
	
}