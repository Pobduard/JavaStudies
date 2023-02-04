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
		switch (e.getKeyCode()) {
		//+UP
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				gamePanel.getGame().getPlayer().setUp(true);
				break;
		//+DOWN
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				gamePanel.getGame().getPlayer().setDown(true);
				break;
		//+LEFT
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				gamePanel.getGame().getPlayer().setLeft(true);
				break;
		//+RIGHT
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				gamePanel.getGame().getPlayer().setRight(true);
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			//+UP
				case KeyEvent.VK_W:
				case KeyEvent.VK_UP:
				gamePanel.getGame().getPlayer().setUp(false);

			//+DOWN
				case KeyEvent.VK_S:
				case KeyEvent.VK_DOWN:
				gamePanel.getGame().getPlayer().setDown(false);

			//+LEFT
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
				gamePanel.getGame().getPlayer().setLeft(false);

			//+RIGHT
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					gamePanel.getGame().getPlayer().setRight(false);
					break;
			}
	}
	
}
