package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.Triviador;

public class FileManager {

private Triviador partida;
	
	public FileManager(Triviador partida) {
		this.partida = partida;
	}
	
	public FileManager() {
		this(null);
	}

	public void saveGame ( Triviador partida ) {		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/controller/saves/out.bin"));
			out.writeObject(partida);
			out.close();
		} catch (IOException i) {
			i.printStackTrace(); 
		}
	}
	
	public Triviador loadGame() {
		Triviador game = null;
		try {
			FileInputStream file = new FileInputStream("src/controller/saves/out.bin");
			ObjectInputStream input = new ObjectInputStream(file);
			game = (Triviador) input.readObject();
			this.partida=game;
			input.close();
			file.close();
		} catch (IOException i) {
			System.out.println("Error 404 Game not found");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if( game!= null) {
			this.partida = game;
		}
		return partida;
	}
}
