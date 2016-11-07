package controller;

import java.io.Serializable;
import model.*;
import view.*;

public class GameController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private GameBoard view;
	private Board model;
	
	public GameController(GameBoard view, Board model) {
		this.model = model;
		this.view = view;
	}
	
	/** displayPlayerTerritory
	 * recorre el set del activePlayer y se fija en sus territorios y
	 * devuelve un String[] con los nombres de estos
	 */
	public String[] displayPlayerTerritory() {
		String[] s = new String[model.getActivePlayer().getTerritories().size()];
		int i = 0;
		for(Territory t: model.getActivePlayer().getTerritories()) {
			s[i] = t.getName();
			i++;
		}
		return s;
	}
	
	/**
	 * Me devuelve un String con uno de ellos seleccionados
	 * ahi debo hacer un contains para el set de territorios del player
	 */
	public String[] displayAdjEnemyTerritories(String territory) {
		for(Territory t: model.getActivePlayer().getTerritories()) {
			if(territory.equals(t.getName())) {
				String[] ans = new String[t.getAdjacents().size()];
				int i = 0;
				for(Territory adj: t.getAdjacents()) {
					ans[i] = adj.getName();
				}
			return ans;
			}
		}
		return null;
	}
	
	
	
	
	/** Crear funcion para comunicar el cambio de changeTurn
	 * 
	 */
	
	public void battle(Territory attacking, Territory defending) {
		
	}
}
