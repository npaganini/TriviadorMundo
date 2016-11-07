package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.MultipleChoiceQuestion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MultipleQuestionsInterface {

	private JFrame frame;
	private JTextField textField;

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
	public MultipleQuestionsInterface(MultipleChoiceQuestion question) {
		initialize(question);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MultipleChoiceQuestion question) {
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(question.getQuestion());
		textField.setBounds(30, 15, 740, 100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(question.getAnswer(0));
		btnNewButton.setBounds(30, 226, 740, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(question.getAnswer(1));
		btnNewButton_1.setBounds(30, 286, 740, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton(question.getAnswer(2));
		button.setBounds(30, 348, 740, 50);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton(question.getAnswer(3));
		button_1.setBounds(30, 410, 740, 50);
		frame.getContentPane().add(button_1);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(0, -4, 799, 484);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(GameBoard.class.getResource("/view/resources/map.jpg")));
	}
}
