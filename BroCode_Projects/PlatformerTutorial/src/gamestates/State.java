package gamestates;

import java.awt.event.*;
import Main.Game;
import UI.MenuButton;

//& SuperClass para todos los futuros States
public class State {
	protected Game game;

	public State(Game game){
		this.game = game;
	}

	public boolean IsIn(MouseEvent e, MenuButton menuButton){
		return menuButton.GetBounds().contains(e.getX(),e.getY());		//Si el boton se encuentra en este Rectangle, retorna verdadero
	}

	public Game GetGame(){
		return this.game;
	}
}
