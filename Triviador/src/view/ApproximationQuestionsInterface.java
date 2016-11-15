package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Answer;
import model.AproximationQuestion;
import model.Board;
import model.Player;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApproximationQuestionsInterface {

	private Answer answer;
	
	private JFrame frame;
	
	private JLabel questionLabel;
	
	private JLabel player1Label;
	private JTextField player1TextField;
	private JLabel player2Label;
	private JTextField player2TextField;
	
	private JButton okButton;
	
	private JLabel backgroundImage;
	

	public ApproximationQuestionsInterface(AproximationQuestion question, Player attackingPlayer, Player defendingPlayer) {
		answer = new Answer();
		
		frame = new JFrame();
		frame.setBounds(200, 300, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		questionLabel = new JLabel(question.getQuestion());
		questionLabel.setBackground(new Color(255, 255, 255));
		questionLabel.setBounds(30, 15, 740, 100);
		frame.getContentPane().add(questionLabel);
		
		player1Label = new JLabel("Player 1 please type your answer");
		player1Label.setBounds(110, 193, 260, 50);
		frame.getContentPane().add(player1Label);
		
		player1TextField = new JTextField();
		player1TextField.setBounds(110, 255, 260, 50);
		frame.getContentPane().add(player1TextField);
		player1TextField.setColumns(10);
		
		player2Label = new JLabel("Player 2 please type your answer");
		player2Label.setBounds(430, 193, 260, 50);
		frame.getContentPane().add(player2Label);
		
		player2TextField = new JTextField();
		player2TextField.setBounds(430, 255, 260, 50);
		frame.getContentPane().add(player2TextField);
		player2TextField.setColumns(10);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer.setAnswerAttacking(player1TextField.getText());
				answer.setAnswerDefending(player2TextField.getText());
				JOptionPane.showMessageDialog(null, Board.getCorrectAnswers(attackingPlayer, defendingPlayer, question, answer));
				frame.dispose();
			}
		});
		okButton.setBounds(370, 400, 60, 60);
		frame.getContentPane().add(okButton);
		
		backgroundImage = new JLabel();
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, 0, 800, 572);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(ApproximationQuestionsInterface.class.getResource("/view/resources/map.jpg")));
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	/*public static void main(String[] args) {
		AproximationQuestion question = new AproximationQuestion("hola", 100);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproximationQuestionsInterface window = new ApproximationQuestionsInterface(question);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
