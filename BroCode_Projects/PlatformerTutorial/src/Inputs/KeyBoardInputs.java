package Inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class KeyBoardInputs implements KeyListener{

	private GamePanel gamePanel;
	public KeyBoardInputs(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}


	@Override
	public void keyPressed(KeyEvent e) {
	System.out.println("keyPressed");
		switch (e.getKeyCode()) {
		//+UP
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				gamePanel.changeYDelta(-5);
				break;
		//+DOWN
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				gamePanel.changeYDelta(+5);
				break;
		//+LEFT
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				gamePanel.changeXDelta(-5);
				break;
		//+RIGHT
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				gamePanel.changeXDelta(+5);
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
	}
	
}
