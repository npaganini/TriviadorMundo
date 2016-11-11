package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartGameInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	private JButton newGameButton;
	private JButton loadGameButton;
	
	private JLabel backgroundImage;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGameInterface frame = new StartGameInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StartGameInterface() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 300, 800, 600);
		frame.getContentPane().setLayout(null);
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		newGameButton.setBounds(360, 348, 120, 25);
		frame.getContentPane().add(newGameButton);
		
		loadGameButton = new JButton("Load Game");
		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		loadGameButton.setBounds(360, 414, 120, 25);
		frame.getContentPane().add(loadGameButton);
		
		backgroundImage = new JLabel();
		backgroundImage.setBackground(new Color(255, 255, 255));
		backgroundImage.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(backgroundImage);
		backgroundImage.setIcon(new ImageIcon(StartGameInterface.class.getResource("/view/resources/triviadorHome.jpg")));
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
