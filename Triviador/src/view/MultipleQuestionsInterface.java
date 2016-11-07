package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Answer;
import model.MultipleChoiceQuestion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class MultipleQuestionsInterface {

	private JFrame frame;
	private JLabel textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleQuestionsInterface window = new MultipleQuestionsInterface(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Answer answer;
	private JLabel textField_1;
	private JLabel textField_2;
	private JLabel textField_3;
	private JLabel textField_4;
	public MultipleQuestionsInterface(MultipleChoiceQuestion question) {
		initialize(question);
		answer = new Answer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MultipleChoiceQuestion question) {
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JLabel(question.getQuestion());
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(30, 15, 740, 100);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(0));
			}
		});
		btnNewButton.setBounds(30, 226, 50, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(1));
			}
		});
		btnNewButton_1.setBounds(30, 286, 50, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(2));
			}
		});
		button.setBounds(30, 348, 50, 50);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("D");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP1() == null)
					answer.setAnswerP1(question.getAnswer(3));
			}
		});
		button_1.setBounds(30, 410, 50, 50);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(0));
			}
		});
		button_2.setBounds(720, 226, 50, 50);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("B");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(1));
			}
		});
		button_3.setBounds(720, 286, 50, 50);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("C");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(2));
			}
		});
		button_4.setBounds(720, 348, 50, 50);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("D");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.getAnswerP2() == null)
					answer.setAnswerP2(question.getAnswer(3));
			}
		});
		button_5.setBounds(720, 410, 50, 50);
		frame.getContentPane().add(button_5);
		
		textField_1 = new JLabel(question.getAnswer(0));
		textField_1.setBounds(100, 226, 600, 50);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JLabel(question.getAnswer(1));
		textField_2.setBounds(100, 286, 600, 50);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JLabel(question.getAnswer(2));
		textField_3.setBounds(100, 348, 600, 50);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JLabel(question.getAnswer(3));
		textField_4.setBounds(100, 410, 600, 50);
		frame.getContentPane().add(textField_4);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(GameBoard.class.getResource("/view/resources/map.jpg")));
	}
}
