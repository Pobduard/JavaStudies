package Inputs;
import java.awt.event.*;

import Main.GamePanel;


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
		if(e.getButton() == MouseEvent.BUTTON1){
			gamePanel.getGame().getPlayer().setAttacking(true);
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
