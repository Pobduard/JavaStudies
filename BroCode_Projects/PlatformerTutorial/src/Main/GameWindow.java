package Main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.*;
public class GameWindow extends JFrame{
	private JFrame frame;

	public GameWindow(GamePanel gamePanel){
		frame = new JFrame("Game");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamePanel);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);					//*Que Aparezca en medio de la pantalla */
		frame.setVisible(true);

		frame.addWindowFocusListener(new WindowFocusListener(){

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();		//Para poner todos los booleans de direccion a false si se pierde el focus, osease si se sale de la ventana
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
			}
		});
	}
	
}
