package Bro_Collisions;
import java.awt.*;
import java.awt.event.*;

public class Box extends Rectangle{
//&=======[Globales]=======
	Color color;


//&=======[Constructor]=======
	/**
	 * @param x = X_Inicial
	 * @param y = Y_Inicial
	 * @param width = Ancho
	 * @param height = Alto
	 * @param color = Color
	 */
	Box(int x, int y, int width, int height,Color color){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.color = color;
}


//&=======[Funciones/Metodos]=======
	public void keyPressed(KeyEvent e){
	//+ Up Arrow
		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.y = y - 10;
		}
	
	//+ Down Arrow
	if(e.getKeyCode() == KeyEvent.VK_DOWN){
		this.y = y + 10;
	}

	//+ Left Arrow
	if(e.getKeyCode() == KeyEvent.VK_LEFT){
		this.x = x - 10;
	}

	//+ Right Arrow
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		this.x = x + 10;
	}
	}


	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
