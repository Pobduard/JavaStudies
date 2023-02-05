package Inputs;
import java.awt.event.*;

import Main.GamePanel;
import gamestates.Gamestate;


public class MouseInputs implements MouseListener, MouseMotionListener{

	GamePanel gamePanel;
	public MouseInputs(GamePanel this_gamePanel){
		this.gamePanel = this_gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Gamestate.state) {
			case MENU:
				gamePanel.getGame().GetMenu().mouseClicked(e);
				break;
			case PLAYING:
				gamePanel.getGame().GetPlaying().mouseClicked(e);
				break;
			default:
				break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
	
}
