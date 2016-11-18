package model;

import java.io.Serializable;
import controller.Triviador;
import view.StartGameInterface;

public class Main implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) throws Exception {	
		Triviador partida = new Triviador();
		new StartGameInterface(partida);
	}
}
