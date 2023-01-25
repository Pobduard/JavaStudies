package Main;

import javax.swing.*;
public class GameWindow extends JFrame{
	private JFrame frame;
	GamePanel gamePanel;

	public GameWindow(GamePanel this_gamePanel){
		this.gamePanel = this_gamePanel;
		frame = new JFrame("Game");

		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamePanel);
		frame.setLocationRelativeTo(null);					//*Que Aparezca en medio de la pantalla */

		frame.setVisible(true);
	}
	
}
