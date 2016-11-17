package view;

import javax.swing.JFrame;
import model.Answer;
import model.MultipleChoiceQuestion;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Triviador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MultipleQuestionsInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Triviador partida;
	private Answer answer;
	private MultipleChoiceQuestion question;
	
	private JFrame frame;
	
	private JLabel questionLabel;
	private JLabel answerALabel;
	private JLabel answerBLabel;
	private JLabel answerCLabel;
	private JLabel answerDLabel;
	
	private JButton AP1Button;
	private JButton BP1Button;
	private JButton CP1Button;
	private JButton DP1Button;
	
	private JButton AP2Button;
	private JButton BP2Button;
	private JButton CP2Button;
	private JButton DP2Button;
	
	private JButton okButton;
	
	private JLabel backgroundImage;
	
	public MultipleQuestionsInterface(Triviador partida) {
		this.partida = partida;
		question = partida.getMultipleChoiceQuestion();
		answer = new Answer();
		
		frame = new JFrame();
		getFrame().setBounds(300, 200, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);
		
		questionLabel = new JLabel(question.getQuestion());
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		questionLabel.setBackground(new Color(255, 255, 255));
		questionLabel.setBounds(86, 49, 613, 100);
		getFrame().getContentPane().add(questionLabel);
		
		AP1Button = new JButton("A");
		AP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(answer.getAnswerAttacking() == null)
					answer.setAnswerAttacking(question.getAnswer(0));
			}
		});
		AP1Button.setBounds(70, 226, 50, 50);
		getFrame().getContentPane().add(AP1Button);
		
		BP1Button = new JButton("B");
		BP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerAttacking() == null)
					answer.setAnswerAttacking(question.getAnswer(1));
			}
		});
		BP1Button.setBounds(70, 286, 50, 50);
		getFrame().getContentPane().add(BP1Button);
		
		CP1Button = new JButton("C");
		CP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerAttacking() == null)
					answer.setAnswerAttacking(question.getAnswer(2));
			}
		});
		CP1Button.setBounds(70, 348, 50, 50);
		getFrame().getContentPane().add(CP1Button);
		
		DP1Button = new JButton("D");
		DP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerAttacking() == null)
					answer.setAnswerAttacking(question.getAnswer(3));
			}
		});
		DP1Button.setBounds(70, 410, 50, 50);
		getFrame().getContentPane().add(DP1Button);
		
		AP2Button = new JButton("A");
		AP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerDefending() == null)
					answer.setAnswerDefending(question.getAnswer(0));
			}
		});
		AP2Button.setBounds(676, 226, 50, 50);
		getFrame().getContentPane().add(AP2Button);
		
		BP2Button = new JButton("B");
		BP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerDefending() == null)
					answer.setAnswerDefending(question.getAnswer(1));
			}
		});
		BP2Button.setBounds(676, 286, 50, 50);
		getFrame().getContentPane().add(BP2Button);
		
		CP2Button = new JButton("C");
		CP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerDefending() == null)
					answer.setAnswerDefending(question.getAnswer(2));
			}
		});
		CP2Button.setBounds(676, 348, 50, 50);
		getFrame().getContentPane().add(CP2Button);
		
		DP2Button = new JButton("D");
		DP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerDefending() == null)
					answer.setAnswerDefending(question.getAnswer(3));
			}
		});
		DP2Button.setBounds(676, 410, 50, 50);
		getFrame().getContentPane().add(DP2Button);
		
		answerALabel = new JLabel(question.getAnswer(0));
		answerALabel.setBounds(140, 226, 530, 50);
		getFrame().getContentPane().add(answerALabel);
		
		answerBLabel = new JLabel(question.getAnswer(1));
		answerBLabel.setBounds(140, 286, 530, 50);
		getFrame().getContentPane().add(answerBLabel);
		
		answerCLabel = new JLabel(question.getAnswer(2));
		answerCLabel.setBounds(140, 348, 530, 50);
		getFrame().getContentPane().add(answerCLabel);
		
		answerDLabel = new JLabel(question.getAnswer(3));
		answerDLabel.setBounds(140, 410, 530, 50);
		getFrame().getContentPane().add(answerDLabel);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCorrectAnswers();
				frame.setVisible(false);
			}
		});
		okButton.setBounds(370, 480, 60, 60);
		getFrame().getContentPane().add(okButton);
		
		backgroundImage = new JLabel();
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, -7, 800, 600);
		getFrame().getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(MultipleQuestionsInterface.class.getResource("/view/resources/triviadorQuestion.jpg")));
		
		frame.setVisible(true);
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void getCorrectAnswers() {
		if(question.getCorrectAnswer().equals(answer.getAnswerAttacking())) {
			if(question.getCorrectAnswer().equals(answer.getAnswerDefending())) {
				JOptionPane.showMessageDialog(null, "Both players answered correctly!");
				new AproximationQuestionsInterface(partida);
			}
			else {
				JOptionPane.showMessageDialog(null, "Attacking player answered correctly");
				partida.getDefendingTerritory().getClimate().decreaseRemainingDifficulty();
				if(partida.getDefendingTerritory().getClimate().getRemainingDifficulty()<=0){
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
		}
		else if(question.getCorrectAnswer().equals(answer.getAnswerDefending())) {
			JOptionPane.showMessageDialog(null, "Defending player answered correctly");
			new GameBoard(partida);
		}
		else {
			JOptionPane.showMessageDialog(null, "Neither player answered correcly");
			new GameBoard(partida);
		}
	}
	
	/*public static void main(String[] args) {
		String[] answers = {"a", "b", "c", "d"};
		MultipleChoiceQuestion question = new MultipleChoiceQuestion("hola", answers, 0);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleQuestionsInterface window = new MultipleQuestionsInterface(question);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
