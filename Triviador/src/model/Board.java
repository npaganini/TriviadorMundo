package model;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<Territory> territories;

	public Board() {
        territories = new HashSet<Territory>();
        addTerritories();
	}
	
	public void addTerritories() {
		territories.add(new Territory("America del Sur", 100, 187, 346));
		territories.add(new Territory("America Central", 100, 138, 256));
		territories.add(new Territory("America del Norte", 100, 88, 159));
		territories.add(new Territory("Polo Norte", 100, 226, 34));
		territories.add(new Territory("Europa", 100, 368, 131));
		territories.add(new Territory("Africa", 100, 368, 294));
		territories.add(new Territory("MedioOriente", 100, 508, 188));
		territories.add(new Territory("Asia", 100, 573, 98));
		territories.add(new Territory("Oceania", 100, 613, 359));
	}

	public void distributeTerritories(ArrayList<Player> players) {
		int i = 0;  /* Este metodo solo se usa al principio de la partida! */
		for(Territory t: territories) {
			territories.add(t);
            players.get(i%3).addTerritories(t);
            i++;
		}
	}
}
