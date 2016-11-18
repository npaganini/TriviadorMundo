package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Answer;
import model.AproximationQuestion;
import javax.swing.JTextField;

import controller.Triviador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class AproximationQuestionsInterface extends JFrame {

	private Triviador partida;
	private Answer answer;
	private AproximationQuestion question;
	private final static Integer ARMIES_NUMBER=100;
	
	private JFrame frame;
	
	private JLabel questionLabel;
	
	private JLabel player1Label;
	private JTextField player1TextField;
	private JLabel player2Label;
	private JTextField player2TextField;
	
	private JButton okButton;
	
	private JLabel backgroundImage;
	

	public AproximationQuestionsInterface(Triviador partida) {
		this.partida = partida;
		answer = new Answer();
		question = partida.getAproximationQuestion();
		
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		questionLabel = new JLabel(question.getQuestion());
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		questionLabel.setBackground(new Color(255, 255, 255));
		questionLabel.setBounds(107, 15, 593, 100);
		frame.getContentPane().add(questionLabel);
		
		player1Label = new JLabel("Jugador 1, escriba su respuesta:");
		player1Label.setBounds(110, 193, 260, 50);
		frame.getContentPane().add(player1Label);
		
		player1TextField = new JTextField();
		player1TextField.setBounds(110, 255, 260, 50);
		frame.getContentPane().add(player1TextField);
		player1TextField.setColumns(10);
		
		player2Label = new JLabel("Jugador 2, escriba su respuesta:");
		player2Label.setBounds(430, 193, 260, 50);
		frame.getContentPane().add(player2Label);
		
		player2TextField = new JTextField();
		player2TextField.setBounds(430, 255, 260, 50);
		frame.getContentPane().add(player2TextField);
		player2TextField.setColumns(10);
		
		okButton = new JButton("");
		okButton.setIcon(new ImageIcon(AproximationQuestionsInterface.class.getResource("/view/resources/responderButton.jpg")));
		okButton.setBorderPainted(false);
		okButton.setBorderPainted(false);
		okButton.setOpaque(false);
		okButton.setContentAreaFilled(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer.setAnswerAttacking(player1TextField.getText());
				answer.setAnswerDefending(player2TextField.getText());
				getCorrectAnswers();
				frame.setVisible(false);;
			}
		});
		okButton.setBounds(246, 400, 294, 60);
		frame.getContentPane().add(okButton);
		
		backgroundImage = new JLabel();
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, -7, 800, 600);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(AproximationQuestionsInterface.class.getResource("/view/resources/triviadorQuestion.jpg")));
		
		frame.setVisible(true);
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void getCorrectAnswers() {
		Integer answerAttacking = Math.abs(question.getAnswer() - Integer.parseInt(answer.getAnswerAttacking()));
		Integer answerDefending = Math.abs(question.getAnswer() - Integer.parseInt(answer.getAnswerDefending()));
		
		if(answerAttacking < answerDefending) {
			JOptionPane.showMessageDialog(null, "Attacking player is closer than defending player");
			partida.getDefendingTerritory().getClimate().decreaseRemainingDifficulty();
			if(partida.getDefendingTerritory().getClimate().getRemainingDifficulty()<=0){
				partida.getActivePlayer().addArmies(ARMIES_NUMBER);
				partida.getDefendingTerritory().getClimate().restoreRemainingDifficulty();
				partida.getDefendingTerritory().setOwner(partida.getAttackingTerritory().getOwner());
				partida.getDefendingTerritory().getOwner().removeTerritories(partida.getDefendingTerritory());
				partida.getAttackingTerritory().getOwner().addTerritories(partida.getDefendingTerritory());
				partida.getDefendingTerritory().addArmies(partida.getAttackingTerritory().getAmountArmies());
				new GameBoard(partida);
			}
			else{
				this.dispose();
				new MultipleQuestionsInterface(partida);
			}
		}
		else if(answerAttacking > answerDefending) {
			JOptionPane.showMessageDialog(null, "Defending player is closer than attacking player");
			new GameBoard(partida);
		}
		else {
			JOptionPane.showMessageDialog(null, "Both players answered " + answer.getAnswerAttacking() + " and the answer was: " + question.getAnswer() + ". Lets try again");
			new AproximationQuestionsInterface(partida);
		}
	}
}
