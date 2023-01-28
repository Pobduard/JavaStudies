package Main;

import java.awt.*;

import javax.swing.*;
import Inputs.*;

public class GamePanel extends JPanel{

	public MouseInputs mouseInputs;		//*Usado en + de 1 lugar? Variable. */
	public KeyBoardInputs keyBoardInputs;
	private Game game;

	public GamePanel(Game game){
		this.game = game;
		mouseInputs = new MouseInputs(this);
		keyBoardInputs = new KeyBoardInputs(this);

		setPanelSize();
		addKeyListener(keyBoardInputs);				//! Nos Sirve añadir estas clases, porque ya implementan el listener, asi podemos controlar la data alla
		addMouseListener(mouseInputs);						//! Mira por Teclas: Presionadas, Soltadas, y Cliqueadas (Ademas de si el Mouse entro ono en un area)
		addMouseMotionListener(mouseInputs);				//!Mira si el Mouse se ha movido, o si ah arrastardo algo
	}

	private void setPanelSize(){
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
	}

	public void updateGame(){

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		game.render(g);
	}

	public Game getGame(){
		return this.game;
	}

	
}
