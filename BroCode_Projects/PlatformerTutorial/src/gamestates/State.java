package gamestates;

import Main.Game;

//& SuperClass para todos los futuros States
public class State {
	protected Game game;

	public State(Game game){
		this.game = game;
	}

	public Game GetGame(){
		return this.game;
	}
}
