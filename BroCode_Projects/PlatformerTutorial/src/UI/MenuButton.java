package UI;

import gamestates.Gamestate;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.*;
import static utilz.Constants.UI.Buttons.*;

public class MenuButton {


	//& [Variables]
	private int xPos, yPos, rowIndex, index;
	private int xOffsetCenter = B_WIDTH / 2;
	private boolean mouseOver, mousePressed; 
	
	private Rectangle bounds;		//NoRectangleFloat porque solo va a guardar posicion de ints
	private Gamestate state;
	private BufferedImage[] imgs;


//& [Constructor]
	public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		initBounds();
	}

//& Functions/Methods


	private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
	}

	private void loadImgs() {
		imgs = new BufferedImage[3];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = temp.getSubimage((i * B_WIDTH_DEFAULT) , (rowIndex * B_HEIGHT_DEFAULT) , B_WIDTH_DEFAULT , B_HEIGHT_DEFAULT);
		}
	}

	public void draw(Graphics g){
		g.drawImage(imgs[index], (xPos - xOffsetCenter) , yPos, B_WIDTH, B_HEIGHT, null);
	}

	public void update(){
		index = 0;
		if(mouseOver)
			index = 1;
		if(mousePressed)
			index = 2;
	}

//& Getters/Setters
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

	public Rectangle GetBounds(){
		return this.bounds;
	}

	public void applyGamestate(){
		Gamestate.state = state;
	}

	public void resetBools(){
		mouseOver = false;
		mousePressed = false;

	}


}
