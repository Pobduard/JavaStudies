package gamestates;
import java.awt.*;
import java.awt.event.*;

public interface Statemethods {
	//+ Graphics
	public void update();
	public void draw(Graphics g);
	//+ Mouse
	public void mouseClicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	// + KeyBoard
	public void KeyPressed(KeyEvent e);
	public void KeyReleased(KeyEvent e);
}
