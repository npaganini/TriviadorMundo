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
	 * recorre el set de players y se fija en sus territorios y
	 * devuelve un String[] con los nombres de estos
	 * Me devuelve un String con uno de ellos seleccionados
	 * ahi debo hacer un contains para el set de territorios del player
	 */
	public void displayPlayerTerritory() {
		// TO DO
	}
	
	public void battle(Territory attacking, Territory defending) {
		
	}
}
