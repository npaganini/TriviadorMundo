package view;

import java.io.Serializable;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JCharacter extends JPanel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	
	public JCharacter() {
	       try {                
	          image = ImageIO.read(new File("resources/CharacterRed.png"));
	       } catch (IOException ex) {
	            System.err.println("Error");
	       }
	    }

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	
	
	

}
