package view;

import javax.swing.JFrame;
import model.Answer;
import model.MultipleChoiceQuestion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

public class MultipleQuestionsInterface {

	private Answer answer;
	
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
	
	public MultipleQuestionsInterface(MultipleChoiceQuestion question) {
		answer = new Answer();
		
		frame = new JFrame();
		getFrame().setBounds(300, 200, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		questionLabel = new JLabel(question.getQuestion());
		questionLabel.setBackground(new Color(255, 255, 255));
		questionLabel.setBounds(30, 15, 740, 100);
		getFrame().getContentPane().add(questionLabel);
		
		AP1Button = new JButton("A");
		AP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(0));
			}
		});
		AP1Button.setBounds(30, 226, 50, 50);
		getFrame().getContentPane().add(AP1Button);
		
		BP1Button = new JButton("B");
		BP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(1));
			}
		});
		BP1Button.setBounds(30, 286, 50, 50);
		getFrame().getContentPane().add(BP1Button);
		
		CP1Button = new JButton("C");
		CP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(2));
			}
		});
		CP1Button.setBounds(30, 348, 50, 50);
		getFrame().getContentPane().add(CP1Button);
		
		DP1Button = new JButton("D");
		DP1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(3));
			}
		});
		DP1Button.setBounds(30, 410, 50, 50);
		getFrame().getContentPane().add(DP1Button);
		
		AP2Button = new JButton("A");
		AP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(0));
			}
		});
		AP2Button.setBounds(720, 226, 50, 50);
		getFrame().getContentPane().add(AP2Button);
		
		BP2Button = new JButton("B");
		BP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(1));
			}
		});
		BP2Button.setBounds(720, 286, 50, 50);
		getFrame().getContentPane().add(BP2Button);
		
		CP2Button = new JButton("C");
		CP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(2));
			}
		});
		CP2Button.setBounds(720, 348, 50, 50);
		getFrame().getContentPane().add(CP2Button);
		
		DP2Button = new JButton("D");
		DP2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(3));
			}
		});
		DP2Button.setBounds(720, 410, 50, 50);
		getFrame().getContentPane().add(DP2Button);
		
		answerALabel = new JLabel(question.getAnswer(0));
		answerALabel.setBounds(100, 226, 600, 50);
		getFrame().getContentPane().add(answerALabel);
		
		answerBLabel = new JLabel(question.getAnswer(1));
		answerBLabel.setBounds(100, 286, 600, 50);
		getFrame().getContentPane().add(answerBLabel);
		
		answerCLabel = new JLabel(question.getAnswer(2));
		answerCLabel.setBounds(100, 348, 600, 50);
		getFrame().getContentPane().add(answerCLabel);
		
		answerDLabel = new JLabel(question.getAnswer(3));
		answerDLabel.setBounds(100, 410, 600, 50);
		getFrame().getContentPane().add(answerDLabel);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, getCorrectAnswers(question));				
			}
		});
		okButton.setBounds(370, 480, 60, 60);
		getFrame().getContentPane().add(okButton);
		
		backgroundImage = new JLabel();
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, 0, 800, 600);
		getFrame().getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(MultipleQuestionsInterface.class.getResource("/view/resources/map.jpg")));
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public String getCorrectAnswers(MultipleChoiceQuestion question) {
		if(question.getCorrectAnswer().equals(answer.getAnswerP1())) {
			if(question.getCorrectAnswer().equals(answer.getAnswerP2()))
				return "Both players answered correctly";
			else
				return "Player 1 answered correctly";
		}
		else if(question.getCorrectAnswer().equals(answer.getAnswerP2()))
			return "Player 2 has answered correctly";
		return "Neither player has answered correcly";
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) {
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
	}
}
