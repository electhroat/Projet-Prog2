package Objects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FroggerFrame extends JFrame implements ActionListener {

	private Image backgroundIMG;
    private FroggerPanel panel;
    
	public FroggerFrame() {
		//on commence par dessiner le "terrain" de jeu
		setTitle("Frogger!");
		setResizable(false);
		setSize(600, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		try {
			this.backgroundIMG = ImageIO.read(new File("src/resources/grid.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		setContentPane(new JLabel(new ImageIcon(backgroundIMG)));
		setLocationRelativeTo(null);

		// creates the panel
		panel = new FroggerPanel();
		// gets the frames insets
		Insets frameInsets = getInsets();
		// calculates panel size
		int frameWidth = panel.getWidth() + (frameInsets.left + frameInsets.right);
		int frameHeight = panel.getHeight() + (frameInsets.top + frameInsets.bottom);
		// sets the frame's size
		//setPreferredSize(new Dimension(frameWidth, frameHeight));
		// turns off the layout options
		setLayout(null);
		// adds the panel to the frame
		add(panel);
		// adjusts the window to meet its new preferred size
		pack();
		// shows the frame
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}


}

