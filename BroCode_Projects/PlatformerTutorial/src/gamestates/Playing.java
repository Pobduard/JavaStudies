package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Levels.*;
import Main.Game;
import UI.PauseOverlay;
import entities.*;

public class Playing extends State implements Statemethods{
	private Player player;
	private LevelManager levelManager;
	private PauseOverlay pauseOvelay;
	private boolean paused = false;

	public Playing(Game game){
		super(game);
		initClasses();
	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		player = new Player( (int)(200 * Game.SCALE) , (int)(200 * Game.SCALE) , (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
		pauseOvelay = new PauseOverlay(this);
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer(){
		return this.player;
	}

	@Override
	public void update() {
		if(!paused){
			levelManager.update();
			player.update();
		} else {
					pauseOvelay.update();
		}
	}

	@Override
	public void draw(Graphics g) {
		levelManager.draw(g);
		player.render(g);

		if(paused)
			pauseOvelay.draw(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			player.setAttacking(true);
		}
	}

	public void mouseDragged(MouseEvent e){
		if(paused)
			pauseOvelay.mouseDragged(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(paused)
			pauseOvelay.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(paused)
			pauseOvelay.mouseReleased(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(paused)
			pauseOvelay.mouseMoved(e);
	}

	public void unpauseGame(){
		paused = false;
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
					paused = !paused;		//Siempre sera lo contrario
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
