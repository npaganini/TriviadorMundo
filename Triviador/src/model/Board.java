package model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/** 
* Clase que representa el tablero del juego. Aca se crean los
* diferentes territoirios.
*/

public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<Territory> territories;

	public Board() {
        territories = new HashSet<Territory>();
        addTerritories();
	}
	
	public void addTerritories() {

		
		Territory americaDelSur = new Territory("America del Sur", 100, new Climate(1));
		Territory americaCentral = new Territory("America Central", 100, new Climate(1));
		Territory americaDelNorte = new Territory("America del Norte", 100, new Climate(1));
		Territory poloNorte = new Territory("Polo Norte", 100, new Climate(3));
		Territory europa = new Territory("Europa", 100, new Climate(1));
		Territory africa = new Territory("Africa", 100, new Climate(2));
		Territory medioOriente = new Territory("MedioOriente", 100, new Climate(2));
		Territory oceania = new Territory("Oceania", 100, new Climate(1));
		Territory asia = new Territory("Asia", 100, new Climate(1));
		
		americaDelSur.addAdjacents(americaCentral);
		americaDelSur.addAdjacents(africa);
		americaDelSur.addAdjacents(oceania);
		
		americaCentral.addAdjacents(americaDelSur);
		americaCentral.addAdjacents(americaDelNorte);
		
		americaDelNorte.addAdjacents(americaCentral);
		americaDelNorte.addAdjacents(poloNorte);
		americaDelNorte.addAdjacents(asia);
		
		poloNorte.addAdjacents(americaDelNorte);
		poloNorte.addAdjacents(europa);
		
		europa.addAdjacents(poloNorte);
		europa.addAdjacents(asia);
		europa.addAdjacents(medioOriente);
		europa.addAdjacents(africa);
		
		africa.addAdjacents(americaDelSur);
		africa.addAdjacents(europa);
		africa.addAdjacents(medioOriente);
		africa.addAdjacents(oceania);
		
		medioOriente.addAdjacents(europa);
		medioOriente.addAdjacents(asia);
		medioOriente.addAdjacents(africa);
		medioOriente.addAdjacents(oceania);
		
		asia.addAdjacents(medioOriente);
		asia.addAdjacents(europa);
		asia.addAdjacents(americaDelNorte);
		
		oceania.addAdjacents(africa);
		oceania.addAdjacents(medioOriente);
		oceania.addAdjacents(americaDelSur);
		
		territories.add(americaDelSur);
		territories.add(americaCentral);
		territories.add(americaDelNorte);
		territories.add(poloNorte);
		territories.add(europa);
		territories.add(africa);
		territories.add(medioOriente);
		territories.add(asia);
		territories.add(oceania);
	}
	
	/**
	 * Distributes territories evenly among the 3 players as it initializes
	 * @param players
	 */
	public void distributeTerritories(ArrayList<Player> players) {
		int i = 0;
		for(Territory t: territories) {
            Player p = players.get(i%3);
			p.addTerritories(t);
			t.setOwner(p);
			p.addArmies(t.getAmountArmies());
            i++;
		}
	}

	public Set<Territory> getTerritories() {
		return territories;
	}
}
