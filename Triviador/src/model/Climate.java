package model;

import java.io.Serializable;

/**
* Clase que representa el tipo de clima que va a tener el
* territorio. El clima determina la dificultad de conquistar el
* territorio ya que aumenta o disminuye la cantidad de preguntas
* que va a tener que responder el atacante para conquistarlo.
*/

public class Climate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer difficulty;
	private Integer remainingDifficulty;
	
	public Climate(Integer difficulty){
		this.difficulty=difficulty;
		remainingDifficulty=difficulty;
	}
	
	public Integer getDifficulty(){
		return difficulty;
	}
	
	public Integer getRemainingDifficulty(){
		return remainingDifficulty;
	}
	
	public void decreaseRemainingDifficulty(){
		remainingDifficulty-=1;
	}
	
	public void restoreRemainingDifficulty(){
		remainingDifficulty=difficulty;
	}
	
	
}
