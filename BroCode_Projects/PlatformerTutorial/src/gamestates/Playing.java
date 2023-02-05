package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Levels.*;
import Main.Game;
import entities.*;

public class Playing extends State implements Statemethods{
	private Player player;
	private LevelManager levelManager;

	public Playing(Game game){
		super(game);
		initClasses();
	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer(){
		return this.player;
	}

	@Override
	public void update() {
		levelManager.update();
		player.update();
	}

	@Override
	public void draw(Graphics g) {
		levelManager.draw(g);
		player.render(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			player.setAttacking(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			// //+UP
			// 	case KeyEvent.VK_W:
			// 	case KeyEvent.VK_UP:
			// 		player.setUp(true);
			// 		break;
			// //+DOWN
			// 	case KeyEvent.VK_S:
			// 	case KeyEvent.VK_DOWN:
			// 		player.setDown(true);
			// 		break;
			//+LEFT
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					player.setLeft(true);
					break;
			//+RIGHT
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					player.setRight(true);
					break;
			//+ Espacio
				case KeyEvent.VK_SPACE:
					player.setJump(true);
					break;
				case KeyEvent.VK_ESCAPE:
					Gamestate.state = Gamestate.MENU;
					break;
			}
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			// //+UP
			// 	case KeyEvent.VK_W:
			// 	case KeyEvent.VK_UP:
			// 		player.setUp(false);

			// //+DOWN
			// 	case KeyEvent.VK_S:
			// 	case KeyEvent.VK_DOWN:
			// 		player.setDown(false);

			//+LEFT
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					player.setLeft(false);

			//+RIGHT
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
			//+ Espacio
				case KeyEvent.VK_SPACE:
					player.setJump(false);
					break;
			}
	}
}
