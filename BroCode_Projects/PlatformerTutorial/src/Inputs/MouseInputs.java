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
		gamePanel.setRectPosition(e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
