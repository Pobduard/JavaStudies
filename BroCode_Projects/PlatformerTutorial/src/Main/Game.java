package Main;

public class Game {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;

	public Game(){
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gameWindow.requestFocus();					//! PON AMBOS POR Si ACASO
		gamePanel.requestFocus();					//!Para que los Inputs de Normal venga aca
	}
}
