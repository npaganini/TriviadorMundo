package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;

public class GameBoard {
	private static final JLabel backgroundImage = new JLabel("");
	private static final JButton btnNextTurn = new JButton("Pasar Turno");
	private static final JLayeredPane layeredPane = new JLayeredPane();
	private static final JTextField PlayerOneName = new JTextField();
	private static final JTextField playerOneArmy = new JTextField();
	private static final JLabel lblTurn = new JLabel("Turno:");
	private static final JTextField turnNumber = new JTextField();
	private static final JTextField PlayerTwoName = new JTextField();
	private static final JTextField playerTwoArmy = new JTextField();
	private static final JTextField PlayerThreeName = new JTextField();
	private static final JTextField playerThreeArmy = new JTextField();
	private static final JButton btnNewButton = new JButton("Atacar");
	public static void main(String[] args) {
	      
	      JFrame f = new JFrame("A JFrame");
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setTitle("Triviador");
	      f.setSize(800, 600);
	      f.setLocation(300,200);
	      
	      f.getContentPane().add(layeredPane, BorderLayout.CENTER);
	      turnNumber.setBounds(509, 546, 103, 26);
	      layeredPane.add(turnNumber);
	      turnNumber.setColumns(10);
	      lblTurn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	      lblTurn.setBounds(509, 520, 103, 16);
	      layeredPane.add(lblTurn);
	      PlayerThreeName.setText("Player 3");
	      PlayerThreeName.setBounds(240, 515, 110, 26);
	      PlayerThreeName.setColumns(10);
	      
	      layeredPane.add(PlayerThreeName);
	      playerThreeArmy.setBounds(240, 546, 110, 26);
	      playerThreeArmy.setColumns(10);
	      
	      layeredPane.add(playerThreeArmy);
	      PlayerTwoName.setText("Player 2");
	      PlayerTwoName.setBounds(124, 515, 110, 26);
	      PlayerTwoName.setColumns(10);
	      
	      layeredPane.add(PlayerTwoName);
	      playerTwoArmy.setBounds(124, 546, 110, 26);
	      playerTwoArmy.setColumns(10);
	      
	      layeredPane.add(playerTwoArmy);
	      PlayerOneName.setBounds(8, 515, 110, 26);
	      layeredPane.add(PlayerOneName);
	      PlayerOneName.setText("Player 1");
	      PlayerOneName.setColumns(10);
	      playerOneArmy.setBounds(8, 546, 110, 26);
	      playerOneArmy.setColumns(10);
	      
	      layeredPane.add(playerOneArmy);
	      btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	      btnNewButton.setSelectedIcon(new ImageIcon(GameBoard.class.getResource("/Resources/Textures/flag.png")));
	      btnNewButton.setBounds(218, 367, 71, 29);
	      
	      layeredPane.add(btnNewButton);
	      btnNextTurn.setBounds(612, 515, 182, 57);
	      layeredPane.add(btnNextTurn);
	      backgroundImage.setBounds(0, 0, 799, 509);
	      layeredPane.add(backgroundImage);
	      backgroundImage.setIcon(new ImageIcon(GameBoard.class.getResource("/Resources/Textures/map.jpg")));
	      btnNextTurn.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	}
	      });
	      JTextArea textArea = new JTextArea(10, 40);
	      textArea.setBackground(Color.BLACK);
	      f.setVisible(true);
	      
	    }
}
