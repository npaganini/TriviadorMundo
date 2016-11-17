package model;

import java.io.Serializable;

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
