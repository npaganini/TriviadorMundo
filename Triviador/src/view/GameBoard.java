package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class GameBoard extends JFrame implements Serializable, ActionListener{
	
	private static final long serialVersionUID = 1L;
	private final JLabel attackFromLabel = new JLabel("Atacar desde:");
	private final JLabel attackLabel = new JLabel("Atacar a:");
	private final JComboBox attackFromComboBox = new JComboBox();
	private final JComboBox attackComboBox = new JComboBox();
	private final JTextField currentPlayerField = new JTextField();
	private final JLabel playerOneLabel = new JLabel("Player 1");
	private final JLabel playerTwoLabel = new JLabel("Player 2");
	private final JLabel playerThreeLabel = new JLabel("Player 3");
	
	public GameBoard(){
		final JLabel backgroundImage = new JLabel("");
		final JButton NextTurnButton = new JButton("Pasar Turno");
		final JLayeredPane layeredPane = new JLayeredPane();
		final JTextField playerOneArmyField = new JTextField();
		final JLabel turnLabel = new JLabel("Turno:");
		final JTextField turnNumber = new JTextField();
		final JTextField playerTwoArmyField = new JTextField();
		final JTextField playerThreeArmyField = new JTextField();
		final JButton attackButton = new JButton("Atacar");
		JFrame f = new JFrame("A JFrame");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setTitle("Triviador");
	    f.setSize(800, 600);
	    f.setLocation(300,200);
	    
	    JCharacter character = new JCharacter();
	    character.setVisible(true);
	    
	    f.getContentPane().add(layeredPane, BorderLayout.CENTER);
	    turnNumber.setBounds(531, 543, 51, 26);
	    layeredPane.add(turnNumber);
	    turnNumber.setColumns(10);
	    turnLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    turnLabel.setBounds(530, 524, 49, 16);
	    layeredPane.add(turnLabel);
	    playerOneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerOneLabel.setBounds(8, 524, 51, 16);
	    
	    layeredPane.add(playerOneLabel);
	    playerTwoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerTwoLabel.setBounds(74, 524, 51, 16);
	    
	    layeredPane.add(playerTwoLabel);
	    playerThreeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerThreeLabel.setBounds(138, 524, 51, 16);
	    
	    layeredPane.add(playerThreeLabel);
	    
	    JButton btnAmericaCentral = new JButton("America Central");
	    btnAmericaCentral.setBounds(138, 256, 117, 41);
	    btnAmericaCentral.setBackground(Color.GREEN);
	    layeredPane.add(btnAmericaCentral);
	    
	    JButton btnPoloNorte = new JButton("Polo Norte");
	    btnPoloNorte.setBounds(226, 34, 117, 29);
	    layeredPane.add(btnPoloNorte);
	    
	    JButton btnOceania = new JButton("Oceania");
	    btnOceania.setBounds(613, 359, 117, 29);
	    layeredPane.add(btnOceania);
	    
	    JButton btnEuropa = new JButton("Europa");
	    btnEuropa.setBounds(368, 131, 117, 29);
	    layeredPane.add(btnEuropa);
	    
	    JButton btnAsia_1 = new JButton("Medio Oriente");
	    btnAsia_1.setBounds(508, 188, 117, 29);
	    layeredPane.add(btnAsia_1);
	    
	    JButton btnAsia = new JButton("Asia");
	    btnAsia.setBounds(573, 98, 117, 29);
	    layeredPane.add(btnAsia);
	    
	    JButton btnAmericaDelNorte = new JButton("America del Norte");
	    btnAmericaDelNorte.setBounds(88, 159, 136, 46);
	    layeredPane.add(btnAmericaDelNorte);
	    
	    JButton btnNewButton = new JButton("Africa");
	    btnNewButton.setBounds(368, 294, 117, 29);
	    layeredPane.add(btnNewButton);
	    
	    JButton btnAmerica = new JButton("America del Sur");
	    btnAmerica.setForeground(Color.BLACK);
	    btnAmerica.setBackground(Color.CYAN);
	    btnAmerica.setBounds(187, 346, 117, 54);
	    layeredPane.add(btnAmerica);
	    playerThreeArmyField.setBounds(138, 546, 60, 26);
	    playerThreeArmyField.setColumns(10);
	    
	    layeredPane.add(playerThreeArmyField);
	    playerTwoArmyField.setBounds(74, 546, 60, 26);
	    playerTwoArmyField.setColumns(10);
	    
	    layeredPane.add(playerTwoArmyField);
	    playerOneArmyField.setBounds(8, 546, 64, 26);
	    playerOneArmyField.setColumns(10);
	    
	    layeredPane.add(playerOneArmyField);
	    attackButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	    attackButton.setSelectedIcon(new ImageIcon(GameBoard.class.getResource("resources/flag.png")));
	    attackButton.setBounds(451, 519, 71, 54);
	    
	    layeredPane.add(attackButton);
	    
	    JButton saveGameButton = new JButton("Guardar");
	    saveGameButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    saveGameButton.setBounds(691, 518, 103, 57);
	    layeredPane.add(saveGameButton);
	    NextTurnButton.setBounds(584, 517, 103, 58);
	    layeredPane.add(NextTurnButton);
	    backgroundImage.setBounds(0, -4, 799, 484);
	    layeredPane.add(backgroundImage);
	    backgroundImage.setIcon(new ImageIcon(GameBoard.class.getResource("resources/map.jpg")));
	    attackFromLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    attackFromLabel.setBounds(210, 519, 94, 16);
	    
	    layeredPane.add(attackFromLabel);
	    attackLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    attackLabel.setBounds(334, 520, 103, 16);
	    
	    layeredPane.add(attackLabel);
	    attackFromComboBox.setBounds(208, 544, 112, 27);
	    attackFromComboBox.setSelectedIndex(0);
	    attackFromComboBox.addActionListener(this);
	    
	    layeredPane.add(attackFromComboBox);
	    attackComboBox.setBounds(330, 544, 114, 27);
	    
	    layeredPane.add(attackComboBox);
	    
	    JLabel lblEsElTurno = new JLabel("Es el turno del jugador:");
	    lblEsElTurno.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    lblEsElTurno.setBounds(12, 492, 166, 16);
	    layeredPane.add(lblEsElTurno);
	    currentPlayerField.setColumns(10);
	    currentPlayerField.setBounds(163, 487, 64, 26);
	    
	    
	    
	    layeredPane.add(currentPlayerField);
	    NextTurnButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    JTextArea textArea = new JTextArea(10, 40);
	    textArea.setBackground(Color.BLACK);
	    f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
	}
	
}
