package model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

/**
* Clase que representa un territorio en el mapa.
*
*/

public class Territory implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Set<Territory> adjacents;
	private Integer amountArmies;
	private Player owner;
	private Climate climate;
	private Set<Territory> alreadyAttacked;
	
	/**
	* Creates a new territory.
	*
	* @param Name for the territory.
	* @param Adjacent territories to this territory.
	* @amountArmies Fictitious amount of armies that contains this territory.
	* @owner Player who owns this territory.
	* @climate Sets the difficulty of capturing this territory.
	*/
	
	public Territory(String name, Integer amountArmies, Climate climate) {
		this.name = name;
		this.adjacents = new HashSet<Territory>();
		this.amountArmies = amountArmies;
		this.owner = null;
		this.climate=climate;
		this.alreadyAttacked = new HashSet<Territory>();
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
	
	public Climate getClimate(){
		return climate;
	}
	
	public void addAlreadyAttackedTerritory(Territory territory) {
		alreadyAttacked.add(territory);
	}
	
	public boolean hasAttackedTerritory(Territory territory) {
		if(alreadyAttacked.contains(territory))
			return true;
		return false;
	}
	
	public void removeAlreadyAttacked() {
		alreadyAttacked.removeAll(alreadyAttacked);
	}
}
