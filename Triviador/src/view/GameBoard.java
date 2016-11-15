package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import controller.Triviador;
import model.Territory;

public class GameBoard extends JFrame implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Triviador partida;
	
	private JFrame mainFrame;
	private JLayeredPane layeredPane;
	
	private JButton americaCentralBtn;
	private JButton americaDelSurBtn;
	private JButton americaDelNorteBtn;
	private JButton poloNorteBtn;
	private JButton africaBtn;
	private JButton europaBtn;
	private JButton asiaBtn;
	private JButton medioOrienteBtn;
	private JButton oceaniaBtn;
	
	JLabel lblEsElTurno;
	private JLabel playerOneLabel;
	private JLabel playerOneArmyField;
	private JLabel playerTwoLabel;
	private JLabel playerTwoArmyField;
	private JLabel playerThreeLabel;
	private JLabel playerThreeArmyField;
	
	private JLabel roundLabel;
	private final JLabel roundCount;
	
	private JLabel attackFromLabel;
	private JComboBox<String> attackFromComboBox;
	private JLabel attackToLabel;
	private JComboBox<String> attackToComboBox;
	
	private JButton attackButton;
	private JButton NextTurnButton;
	private JButton saveGameButton;
	
	private JLabel backgroundImage;
	
	public GameBoard(Triviador partida) {
		
		this.partida = partida;
		
		mainFrame = new JFrame();
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.setTitle("Triviador");
	    mainFrame.setSize(800, 600);
	    mainFrame.setLocation(300,200);
	    
	    layeredPane = new JLayeredPane();
	    mainFrame.getContentPane().add(layeredPane, BorderLayout.CENTER);
	    
	    americaCentralBtn = new JButton("America Central");
	    americaCentralBtn.setBounds(138, 256, 117, 41);
	    americaCentralBtn.setBackground(UIManager.getColor("Button.background"));
	    layeredPane.add(americaCentralBtn);
	    
	    poloNorteBtn = new JButton("Polo Norte");
	    poloNorteBtn.setBounds(226, 34, 117, 29);
	    layeredPane.add(poloNorteBtn);
	    
	    oceaniaBtn = new JButton("Oceania");
	    oceaniaBtn.setBounds(613, 359, 117, 29);
	    layeredPane.add(oceaniaBtn);
	    
	    europaBtn = new JButton("Europa");
	    europaBtn.setBounds(368, 131, 117, 29);
	    layeredPane.add(europaBtn);
	    
	    medioOrienteBtn = new JButton("Medio Oriente");
	    medioOrienteBtn.setBounds(508, 188, 136, 29);
	    layeredPane.add(medioOrienteBtn);
	    
	    asiaBtn = new JButton("Asia");
	    asiaBtn.setBounds(573, 98, 117, 29);
	    layeredPane.add(asiaBtn);
	    
	    americaDelNorteBtn = new JButton("America del Norte");
	    americaDelNorteBtn.setBounds(88, 159, 136, 58);
	    layeredPane.add(americaDelNorteBtn);
	    
	    africaBtn = new JButton("Africa");
	    africaBtn.setBounds(368, 294, 117, 29);
	    layeredPane.add(africaBtn);
	    
	    americaDelSurBtn = new JButton("America del Sur");
	    americaDelSurBtn.setBounds(187, 346, 117, 54);
	    layeredPane.add(americaDelSurBtn);
	    
	    lblEsElTurno = new JLabel("Es el turno del jugador: " + partida.getActivePlayer().getName());
	    lblEsElTurno.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    lblEsElTurno.setBounds(12, 492, 243, 16);
	    layeredPane.add(lblEsElTurno);
	    
	    playerOneLabel = new JLabel("Player 1");
	    playerOneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerOneLabel.setBounds(8, 524, 51, 16);
	    layeredPane.add(playerOneLabel);
	    playerOneArmyField = new JLabel(partida.getPlayer1().getAmountArmies().toString());
	    playerOneArmyField.setBounds(8, 546, 64, 26);
	    layeredPane.add(playerOneArmyField);
	    
	    playerTwoLabel = new JLabel("Player 2");
	    playerTwoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerTwoLabel.setBounds(74, 524, 51, 16);
	    layeredPane.add(playerTwoLabel);
	    playerTwoArmyField = new JLabel(partida.getPlayer2().getAmountArmies().toString());
	    playerTwoArmyField.setBounds(74, 546, 60, 26);
	    layeredPane.add(playerTwoArmyField);
	    
	    playerThreeLabel = new JLabel("Player 3");
	    playerThreeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    playerThreeLabel.setBounds(138, 524, 51, 16);
	    layeredPane.add(playerThreeLabel);
	    playerThreeArmyField = new JLabel(partida.getPlayer3().getAmountArmies().toString());
	    playerThreeArmyField.setBounds(138, 546, 60, 26);
	    layeredPane.add(playerThreeArmyField);
	    
	    roundLabel = new JLabel("Ronda:");
	    roundLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    roundLabel.setBounds(530, 524, 49, 16);
	    layeredPane.add(roundLabel);
	    roundCount = new JLabel(partida.getRoundCount().toString());
	    roundCount.setBounds(531, 543, 51, 26);
	    layeredPane.add(roundCount);
	    
	    attackFromLabel = new JLabel("Atacar desde:");
	    attackFromLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    attackFromLabel.setBounds(210, 519, 94, 16);
	    layeredPane.add(attackFromLabel);
	    attackFromComboBox = new JComboBox<String>();
	    attackFromComboBox.setBounds(208, 544, 112, 27);
	    initializeAttackFromComboBox();
	    attackFromComboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		initializeAttackToComboBox((String) attackFromComboBox.getSelectedItem());
	    	}
	    });
	    layeredPane.add(attackFromComboBox);
	    
	    attackToLabel = new JLabel("Atacar a:");
	    attackToLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    attackToLabel.setBounds(334, 520, 103, 16);
	    layeredPane.add(attackToLabel);
	    attackToComboBox = new JComboBox<String>();
	    attackToComboBox.setBounds(330, 544, 114, 27);
	    layeredPane.add(attackToComboBox);
	    
	    attackButton = new JButton("Atacar");
	    attackButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	    attackButton.setSelectedIcon(new ImageIcon(GameBoard.class.getResource("/view/resources/flag.png")));
	    attackButton.setBounds(451, 519, 71, 54);
	    attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	    layeredPane.add(attackButton);
	    
	    NextTurnButton = new JButton("Pasar Turno");
	    NextTurnButton.setBounds(584, 517, 103, 58);
	    NextTurnButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    layeredPane.add(NextTurnButton);
	    
	    saveGameButton = new JButton("Guardar");
	    saveGameButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    saveGameButton.setBounds(691, 518, 103, 57);
	    layeredPane.add(saveGameButton);
	    
	    backgroundImage = new JLabel();
	    backgroundImage.setBounds(0, 0, 800, 484);
	    layeredPane.add(backgroundImage);
	    backgroundImage.setIcon(new ImageIcon(GameBoard.class.getResource("/view/resources/map.jpg")));
	    
	    mainFrame.setVisible(true);   
	}
	
	public void initializeAttackFromComboBox() {
		while(attackFromComboBox.getModel().getSize() > 0)
			attackFromComboBox.removeItemAt(0);
		for(Territory territory: partida.getActivePlayer().getTerritories())
			attackFromComboBox.addItem(territory.getName());
	}
	
	public void initializeAttackToComboBox(String s) {
		Territory attackingTerritory = partida.stringToTerritory(s);
		while(attackToComboBox.getModel().getSize() > 0)
			attackToComboBox.removeItemAt(0);
		for(Territory territory: attackingTerritory.getAdjacents())
			if(!attackingTerritory.getOwner().equals(territory.getOwner()))
				attackToComboBox.addItem(territory.getName());
	}
	
	public void setTotalArmiesPlayerOne(String armies){
		playerOneArmyField.setText(armies);
	}
	
	public void setTotalArmiesPlayerTwo(String armies){
		playerTwoArmyField.setText(armies);
	}
	
	public void setTotalArmiesPlayerThree(String armies){
		playerThreeArmyField.setText(armies);
	}
}
	
