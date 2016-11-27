package model;

/**
* Clase en la que se guarda la respuesta del jugador que ataca
* y el jugador que responde.
*/

public class Answer {
	private String answerAttacking;
	private String answerDefending;
	private Player[] winner;
	
	public Player[] getWinner() {
		return winner;
	}

	public void setWinner(Player[] winner) {
		this.winner = winner;
	}

	public Answer () {
		answerAttacking = null;
		answerDefending = null;
		winner = null;
	}

	public String getAnswerAttacking() {
		return answerAttacking;
	}

	public void setAnswerAttacking(String answerAttacking) {
		this.answerAttacking = answerAttacking;
	}

	public String getAnswerDefending() {
		return answerDefending;
	}

	public void setAnswerDefending(String answerDefending) {
		this.answerDefending = answerDefending;
	}
}
