package UI;

import java.awt.*;
import java.awt.image.*;

import utilz.LoadSave;
import static utilz.Constants.UI.VolumeButtons.*;

public class VolumeButton extends PauseButton {

	private BufferedImage[] imgs;
	private BufferedImage slider;
	private int index = 0;
	private boolean mouseOver, mousePressed;
	private int buttonX, minX, maxX;			//min y max es la posicion(pixel) minima del slider, mismo pal max pero la maxima

	public VolumeButton(int x, int y, int width, int height) {
		super(x + width/2, y, VOLUME_BUTTON_WIDTH, height);		// + width/2 es pa que x este en el centro del slider
		bounds.x -= VOLUME_BUTTON_WIDTH/2;
		buttonX = x + width/2;
		this.x = x;
		this.width = width;
		minX = x + VOLUME_BUTTON_WIDTH / 2;
		maxX = x + width - + VOLUME_BUTTON_WIDTH / 2;
		loadImgs();
	}

	private void loadImgs() {
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.VOLUME_BUTTONS);
		imgs = new BufferedImage[3];
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = temp.getSubimage((i * VOLUME_BUTTON_DEFAULT_WIDTH) , 0 , VOLUME_BUTTON_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);
		}

		slider = temp.getSubimage((3 * VOLUME_BUTTON_DEFAULT_WIDTH), 0, SLIDER_DEFAULT_WIDTH, VOLUME_BUTTON_DEFAULT_HEIGHT);	//Ese 3 es para salir de los "botones" y agarrar el slider en si
	}

	public void update(){
		index = 0;
		if(mouseOver)
			index = 1;
		if(mousePressed)
			index= 2;
	}

	public void draw(Graphics g){
		g.drawImage(slider, x, y, width, height, null);
		g.drawImage(imgs[index], (buttonX - VOLUME_BUTTON_WIDTH/ 2) , y, VOLUME_BUTTON_WIDTH, height, null);
	}

	public void changeX(int x){
		if(x < minX)
			buttonX = minX;
		else if (x > maxX)
			buttonX = maxX;
		else
			buttonX = x;

		bounds.x = buttonX - VOLUME_BUTTON_WIDTH / 2;
	}

	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	
}
