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
	
	
}
