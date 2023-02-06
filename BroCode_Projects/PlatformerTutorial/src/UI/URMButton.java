package UI;

import java.awt.*;
import java.awt.image.*;

import static utilz.Constants.UI.URMButtons.*;

import utilz.LoadSave;
public class URMButton extends PauseButton{

	private BufferedImage[] imgs;
	private int rowIndex, index;
	private boolean mouseOver, mousePressed;

	public URMButton(int x, int y, int width, int height, int rowIndex) {
		super(x, y, width, height);
		this.rowIndex = rowIndex;
		loadImgs();
	}
	
	private void loadImgs() {
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.URM_BUTTONS);
		imgs = new BufferedImage[3];
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = temp.getSubimage((i * URM_BUTTON_SIZE_DEFAULT), (rowIndex * URM_BUTTON_SIZE_DEFAULT) , URM_BUTTON_SIZE_DEFAULT, URM_BUTTON_SIZE_DEFAULT);
		}
	}

	public void update(){
		index = 0;
		if(mouseOver)
			index = 1;
		if(mousePressed)
			index= 2;
	}

	public void draw(Graphics g){
		g.drawImage(imgs[index], x, y, URM_BUTTON_SIZE, URM_BUTTON_SIZE, null);
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
