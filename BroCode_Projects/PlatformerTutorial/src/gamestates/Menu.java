package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Main.Game;
import UI.MenuButton;
import utilz.LoadSave;

import java.awt.image.*;

public class Menu extends State implements Statemethods{
//& Variables
	private MenuButton[] buttons = new MenuButton[3];
	private BufferedImage backgroundImg, backgroundImgPink;
	private int menuX, menuY, menuWidth, menuHeight;

//& Constructor
	public Menu(Game game) {
		super(game);
		loadButtons();
		loadBackground();
		
	}

	
//& Functions
	private void loadBackground() {
		backgroundImgPink = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND_IMG);

		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
		menuWidth = (int)(backgroundImg.getWidth() * Game.SCALE);
		menuHeight = (int)(backgroundImg.getHeight() * Game.SCALE);
		menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
		menuY = (int) (45* Game.SCALE);
		}

	private void loadButtons() {
		buttons[0] = new MenuButton((Game.GAME_WIDTH /2) , (int)(150 * Game.SCALE) , 0, Gamestate.PLAYING);
		buttons[1] = new MenuButton((Game.GAME_WIDTH /2) , (int)(220 * Game.SCALE) , 1, Gamestate.OPTIONS);
		buttons[2] = new MenuButton((Game.GAME_WIDTH /2) , (int)(290 * Game.SCALE) , 2, Gamestate.QUIT);
	}

	@Override
	public void update() {
		for(MenuButton menuButton : buttons){
			menuButton.update();
		}
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(backgroundImgPink, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);

		g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);
		for(MenuButton menuButton : buttons){
			menuButton.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(MenuButton menuButton : buttons){
			if(IsIn(e , menuButton)){
				menuButton.setMousePressed(true);
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(MenuButton menuButton : buttons){
			if(IsIn(e , menuButton)){
				if(menuButton.isMousePressed())
					menuButton.applyGamestate();
					break;
			}
		}
		resetButtons();
	}

	private void resetButtons() {
		for(MenuButton mb : buttons){
			mb.resetBools();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(MenuButton mb : buttons){
			mb.setMouseOver(false);
		}
		for(MenuButton mb : buttons){
			if(IsIn(e, mb)){
				mb.setMouseOver(true);
				break;
			}
		}
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			Gamestate.state = Gamestate.PLAYING;
		}
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		
	}
	
}
