package Inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import gamestates.Gamestate;

public class KeyBoardInputs implements KeyListener{

	private GamePanel gamePanel;
	public KeyBoardInputs(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch (Gamestate.state) {
			case MENU:
				gamePanel.getGame().GetMenu().KeyPressed(e);
				break;
			case PLAYING:
				gamePanel.getGame().GetPlaying().KeyPressed(e);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (Gamestate.state) {
			case MENU:
				gamePanel.getGame().GetMenu().KeyReleased(e);
				break;
			case PLAYING:
				gamePanel.getGame().GetPlaying().KeyReleased(e);
				break;
			default:
				break;
		}
	}
	
}
