package UI;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import Main.Game;
import gamestates.Gamestate;
import gamestates.Playing;
import utilz.LoadSave;

import static utilz.Constants.UI.PauseButtons.*;
import static utilz.Constants.UI.URMButtons.*;
import static utilz.Constants.UI.VolumeButtons.*;

public class PauseOverlay {

	private Playing playing;
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgWidth, bgHeight;
	private SoundButton musicButton, sfxButton;
	private URMButton menuB, replayB, unpauseB;
	private VolumeButton volumeButton;

	public PauseOverlay(Playing playing) {
		this.playing = playing;
		loadBackground();
		createSoundButton();
		createUrmButtons();
		createVolumeButton();
	}

	private void createVolumeButton() {
		int vX = (int)(309 *Game.SCALE);
		int vY = (int)(278 *Game.SCALE);
		volumeButton = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_BUTTON_HEIGHT);
	}

	private void createUrmButtons() {
		int menuX = (int)(313 * Game.SCALE);
		int replayX = (int)(387 * Game.SCALE);
		int unpauseX = (int)(462 * Game.SCALE);
		int bY = (int)(325 * Game.SCALE);

		unpauseB = new URMButton(unpauseX, bY, URM_BUTTON_SIZE, URM_BUTTON_SIZE, 0);
		replayB = new URMButton(replayX, bY, URM_BUTTON_SIZE, URM_BUTTON_SIZE, 1);
		menuB = new URMButton(menuX, bY, URM_BUTTON_SIZE, URM_BUTTON_SIZE, 2);
	}

	private void createSoundButton() {
		int soundX = (int)(450 * Game.SCALE);
		int musicY = (int)(140 * Game.SCALE);
		int sfxY = (int)(186 * Game.SCALE);

		musicButton = new SoundButton(soundX, musicY, SOUND_BUTTON_SIZE, SOUND_BUTTON_SIZE);
		sfxButton = new SoundButton(soundX, sfxY, SOUND_BUTTON_SIZE, SOUND_BUTTON_SIZE);
	}

	private void loadBackground() {
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
		bgWidth = (int)(backgroundImg.getWidth() * Game.SCALE);
		bgHeight = (int)(backgroundImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgWidth / 2;
		bgY = (int)(25 * Game.SCALE);
	}

	public void update(){
		musicButton.update();
		sfxButton.update();

		menuB.update();
		replayB.update();
		unpauseB.update();

		volumeButton.update();
	}

	public void draw(Graphics g){
		//+	BackGround
		g.drawImage(backgroundImg, bgX, bgY, bgWidth, bgHeight, null);

		//+	SoundButtons
		musicButton.draw(g);
		sfxButton.draw(g);

		//+ URM Buttons
		menuB.draw(g);
		replayB.draw(g);
		unpauseB.draw(g);

		//+ VolumeButton
		volumeButton.draw(g);
	}
	
	public void mouseDragged(MouseEvent e){
		if(volumeButton.isMousePressed()){
			volumeButton.changeX(e.getX());
		}
	}

	public void mousePressed(MouseEvent e){
		//+ Sound Buttons
		if(IsIn(e, musicButton)){
			musicButton.setMousePressed(true);
		}
		else if(IsIn(e, sfxButton)){
			sfxButton.setMousePressed(true);
		}

		//+ URM Buttons

		else if (IsIn(e, menuB)){
			menuB.setMousePressed(true);
		}

		else if (IsIn(e, replayB)){
			replayB.setMousePressed(true);
		}

		else if (IsIn(e, unpauseB)){
			unpauseB.setMousePressed(true);
		}

		//+ Volume Button

		else if (IsIn(e, volumeButton)){
			volumeButton.setMousePressed(true);
		}
		

	}

	public void mouseMoved(MouseEvent e){
		musicButton.setMouseOver(false);
		sfxButton.setMouseOver(false);
		menuB.setMouseOver(false);
		replayB.setMouseOver(false);
		unpauseB.setMouseOver(false);
		volumeButton.setMouseOver(false);

		//+ SoundButtons
		if(IsIn(e, musicButton)){
			musicButton.setMouseOver(true);
		}
		else if(IsIn(e, sfxButton)){
			sfxButton.setMouseOver(true);
		}

		//+ URMButtons
		else if(IsIn(e, menuB)){
			menuB.setMouseOver(true);
		}
		else if(IsIn(e, replayB)){
			replayB.setMouseOver(true);
		}
		else if(IsIn(e, unpauseB)){
			unpauseB.setMouseOver(true);
		}

		//+ Volume Buttons
		else if(IsIn(e, volumeButton)){
			volumeButton.setMouseOver(true);
		}
		
	}

	public void mouseReleased(MouseEvent e){
		//+ SoundButtons
		if (IsIn(e, musicButton)){
			if (musicButton.isMousePressed()){
				musicButton.setMuted(!(musicButton.isMuted()));
			}
		}

		else if (IsIn(e, sfxButton)){
			if (sfxButton.isMousePressed()){
				sfxButton.setMuted(!(sfxButton.isMuted()));
			}
		}

		//+ URMButtons

		else if (IsIn(e, menuB)){
			if(menuB.isMousePressed()){
				Gamestate.state = Gamestate.MENU;
				playing.unpauseGame();
			}
		}

		else if (IsIn(e, replayB)){
			if(replayB.isMousePressed()){
				//TODO: Replay Level
				System.out.println("Replay Lvl");
			}
		}

		else if (IsIn(e, unpauseB)){
			if(unpauseB.isMousePressed()){
				playing.unpauseGame();
			}
		}


		musicButton.resetBools();
		sfxButton.resetBools();
		menuB.resetBools();
		replayB.resetBools();
		unpauseB.resetBools();
		//*Faltaria el Volume Button, pero como no pasa nada el soltarlo (NoAnimacion) pues da igual, aun asi sesetear por si acaso */
		volumeButton.resetBools();
	}

	private boolean IsIn(MouseEvent e, PauseButton b){	//usamos la SuperClass, para poder chekear tambien el slider, no solo el SoundButton
		return b.getBounds().contains(e.getX(), e.getY());		//Se ve raro, pero el "contains" ya hace la comparacion
	}

}
