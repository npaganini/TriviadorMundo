package model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

public class Territory implements Serializable {

	private String name;
	private Set<Territory> adjacents;
	private Integer amountArmies;
	private Player owner;
	
	public Territory(String name, Integer amountArmies, Player owner) {
		super();
		this.name = name;
		this.adjacents = new HashSet<Territory>();
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
	
	public void addAdjacents(Territory adjacentTerritory) {
		adjacents.add(adjacentTerritory);
	}

	public void removeAdjacents(Territory adjacentTerritory) {
		adjacents.remove(adjacentTerritory);
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
