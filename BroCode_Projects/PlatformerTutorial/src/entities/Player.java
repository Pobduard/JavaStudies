package entities;

import java.awt.*;
import java.awt.image.*;

import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{
	private BufferedImage[][] Sprites;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private boolean left, up, right, down;
	private boolean moving = false, attacking = false;


	private float playerSpeed = 2.0f;



	//! No es necesario poner variables para x y Y porque ya se guardan en la clase "Abstracta"
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.width = height;
		this.height = height;
		loadAnimations();
	}

	public void update(){
		updateAnimationTick();
		setAnimation();
		updatePos();
	}

	public void render(Graphics g){
		g.drawImage(Sprites[playerAction][aniIndex], (int)x, (int)y, width, height, null);
	} 

	private void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed){
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)){
				aniIndex = 0;
				attacking = false;
			}
		}
	}

	private void setAnimation() {
		int startAni =playerAction;

			if(moving)
				playerAction = RUNNING;
			else 
				playerAction = IDLE;
			
			if(attacking)
				playerAction = ATTACK_1;
				
			if(startAni != playerAction)	// !		!= porque buscamos cambios, para que le permita a toda la animacion reproducirse
				resetAniTick();
	}

	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos(){
		moving = false;		//Pasara y se quedara solo si uno de los de abajo no es verdad

		if(left && !right){
			x-=playerSpeed;
			moving = true;
		} else if(right && !left){
			x+=playerSpeed;
			moving = true;
		}

		if(down && !up){
			y+=playerSpeed;
			moving = true;
		} else if(up && !down){
			y-=playerSpeed;
			moving = true;
		}
	}

	private void loadAnimations() {

		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

		Sprites = new BufferedImage[9][6];
		for (int j = 0; j < Sprites.length; j++) {
			for (int i = 0; i < Sprites[j].length; i++) {
				Sprites[j][i] = img.getSubimage(i*64, j*40, 64, 40);
				}
			}
		}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void resetDirBooleans() {
		left = false;
		right = false;
		down = false;
		up = false;
	}
	
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
}
