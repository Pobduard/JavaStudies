package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Levels.*;
import Main.Game;
import UI.PauseOverlay;
import entities.*;
import utilz.LoadSave;

public class Playing extends State implements Statemethods{
	private Player player;
	private LevelManager levelManager;
	private PauseOverlay pauseOvelay;
	private boolean paused = false;

	private int xLvlOffset;
	private int leftBorder = (int)(0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int)(0.8 * Game.GAME_WIDTH);
	private int lvlTilesWide = LoadSave.GetLevelData()[0].length;
	private int maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;	//Total de Tiles
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;		//Total de Pixeles

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
			checkCloseToBorder();
		} else {
					pauseOvelay.update();
		}
	}

	private void checkCloseToBorder() {
		int playerX = (int)(player.getHitBox().x);
		int diff = playerX - xLvlOffset;
		//! Que se mueva la pantala, o se pueda mover, controlar el xLvlOffSet
		if(diff > rightBorder){
			xLvlOffset += (diff - rightBorder);		//verifica el borde y la posicion actual, como las resta, el offset, sera la cant de pixeles que se encuentre mas alla del borde
		}
		else if(diff < leftBorder){
			xLvlOffset += (diff - leftBorder);	//Mismo de arriba, per puede irse para negativo, lo cual nos sirve
		}
		//! Bordes "Harcodeados"
		if(xLvlOffset > maxLvlOffsetX){
			xLvlOffset = maxLvlOffsetX;
		}
		else if (xLvlOffset < 0){
			xLvlOffset = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		levelManager.draw(g, xLvlOffset);
		player.render(g, xLvlOffset);

		if(paused){
			g.setColor(new Color(0,0,0,150));
			g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
			pauseOvelay.draw(g);
		}
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
