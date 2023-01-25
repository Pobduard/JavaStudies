package Main;

import java.awt.*;
import javax.swing.*;
import Inputs.*;

public class GamePanel extends JPanel{

	public MouseInputs mouseInputs;		//*Usado en + de 1 lugar? Variable. */
	public KeyBoardInputs keyBoardInputs;
	private int XDelta = 100;
	private int YDelta = 100;



	public GamePanel(){
		mouseInputs = new MouseInputs(this);
		keyBoardInputs = new KeyBoardInputs(this);
		addKeyListener(keyBoardInputs);				//! Nos Sirve añadir estas clases, porque ya implementan el listener, asi podemos controlar la data alla
		addMouseListener(mouseInputs);						//! Mira por Teclas: Presionadas, Soltadas, y Cliqueadas (Ademas de si el Mouse entro ono en un area)
		addMouseMotionListener(mouseInputs);				//!Mira si el Mouse se ha movido, o si ah arrastardo algo
	}

	public void changeXDelta(int value){
		this.XDelta += value;
		repaint();
	}

	public void changeYDelta(int value){
		this.YDelta += value;
		repaint();
	}

	public void setRectPosition(int x, int y){
		this.XDelta = x;
		this.YDelta = y;
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.fillRect(XDelta, YDelta, 200, 50);
	}
	
}
