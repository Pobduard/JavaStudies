package entities;

import java.awt.*;
import java.awt.image.*;

import Main.Game;
import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.CanMoveHere;

public class Player extends Entity{
	private BufferedImage[][] Sprites;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private boolean left, up, right, down;
	private boolean moving = false, attacking = false;


	private float playerSpeed = 2.0f;
	private int[][]	lvlData;

	private float xDrawOffSet = 21 * Game.SCALE;	//Los pixels extra del "Hitbox" normal, a la "real" del jugador
	private float yDrawOffSet = 4 * Game.SCALE;		//Los pixels extra del "Hitbox" normal, a la "real" del jugador



	//! No es necesario poner variables para x y Y porque ya se guardan en la clase "Abstracta"
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.width = width;
		this.height = height;
		loadAnimations();
		initHitBox(x, y, 20*Game.SCALE, 28*Game.SCALE);
	}

	public void update(){
		updatePos();
		updateAnimationTick();
		setAnimation();
	}

	public void render(Graphics g){
		g.drawImage(Sprites[playerAction][aniIndex], (int)(hitBox.x - xDrawOffSet), (int)(hitBox.y - yDrawOffSet), width, height, null);
		drawHitBox(g);
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
		if(!left && !right && !up && !down){	//Que no pulsemos nada de nada
			return;
		}

		float xSpeed = 0, ySpeed = 0;

		if(left && !right){
			xSpeed = -playerSpeed;}
		else if(right && !left){
			xSpeed = playerSpeed;}

		if(up && !down){
			ySpeed = -playerSpeed;}
		else if(down && !up){
			ySpeed = playerSpeed;}

		// if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData)){	//+ Chequea por lo que seria la sig Posicion, siguiente por la velocidad que lleve
		// 	this.x += xSpeed;
		// 	this.y += ySpeed;
		// 	moving = true;
		// }

		if(CanMoveHere(hitBox.x+xSpeed, hitBox.y+ySpeed, hitBox.width, hitBox.height, lvlData)){	//+ Chequea por lo que seria la sig Posicion, siguiente por la velocidad que lleve
			hitBox.x += xSpeed;
			hitBox.y += ySpeed;
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

	public void loadLvlData(int[][] lvlData){
		this.lvlData = lvlData;
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
