package entities;

import java.awt.*;
import java.awt.image.*;

import Main.Game;
import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;

public class Player extends Entity{
	private BufferedImage[][] Sprites;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private boolean left, up, right, down, jump;
	private boolean moving = false, attacking = false;


	private float playerSpeed = 1.5f * Game.SCALE;
	private int[][]	lvlData;

	private float xDrawOffSet = 21 * Game.SCALE;	//Los pixels extra del "Hitbox" normal, a la "real" del jugador
	private float yDrawOffSet = 4 * Game.SCALE;		//Los pixels extra del "Hitbox" normal, a la "real" del jugador
	//& Jumping / Gravity
	private float airSpeed = 0f;
	private float gravity = 0.02f * Game.SCALE;		//Mientras menor sea, mas alto saltara el jugador
	private float jumpSpeed = -2.25f * Game.SCALE;	// Menor porque en la Y queremos ir hacia arriba, tons le restamos a la Y
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;		// En caso de que se toque el techo
	private boolean inAir = false;



	//! No es necesario poner variables para x y Y porque ya se guardan en la clase "Abstracta"
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.width = width;
		this.height = height;
		loadAnimations();
		initHitBox(x, y, (int)(20*Game.SCALE) , (int)(27*Game.SCALE));
	}

	public void update(){
		updatePos();
		updateAnimationTick();
		setAnimation();
	}

	public void render(Graphics g, int lvlOffSet){
		g.drawImage(Sprites[playerAction][aniIndex], (int)(hitBox.x - xDrawOffSet) - (lvlOffSet), (int)(hitBox.y - yDrawOffSet), width, height, null);
		drawHitBox(g, lvlOffSet);
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

			if(inAir){
				if(airSpeed < 0)	//Vamos hacia arriba
					playerAction = JUMP;
				else
					playerAction = FALLING;
			}

			if(attacking)
				playerAction = ATTACK_1;
				
			if(startAni != playerAction)	// !		!= porque buscamos cambios, para que le permita a toda la animacion reproducirse
				resetAniTick();
	}

	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos() {
		moving = false;        //Pasara y se quedara solo si uno de los de abajo no es verdad
		if(jump){
			jump();}
		// if (!left && !right && !inAir) {    //Que no pulsemos nada de nada
		// 	return;
		// }
		if(!inAir)
			if((!left && !right) || left && right)
				return;


		float xSpeed = 0;

		if (left) {                    //Si ambos son verdaderos, de todas formas la velocidad seria 0
			xSpeed -= playerSpeed;
		}
		if (right) {
			xSpeed += playerSpeed;
		}

		if(!inAir){		//Si no estamos saltando, pero tampoco en el suelo (salimos fuera de la plataforma)
			if(!IsEntityOnFloor(hitBox,lvlData)){
				inAir = true;
			}
		}

		if (inAir) {    //+ Accion en Y
			if(CanMoveHere(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height, lvlData)){
				hitBox.y += airSpeed;
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else
				{	//Si aqui no nos podemos mover, entonces es porque estamos en el piso, o colisionando con el techo
				hitBox.y = GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
				if(airSpeed > 0)	//osease vamos abajo, por lo que tocamos el suelo
					resetInAir();
				else				//Si no tocamos el suelo, tons el techo
					airSpeed = fallSpeedAfterCollision;
				updateXPos(xSpeed);
				}
		} else{    //+ Accion en X si no estamos en el aire
			updateXPos(xSpeed);}
		moving = true;
	}

	private void jump() {
		if(inAir){		//Si ya estamos en el aire, tons que no se pueda, por eso no retorna nada de nada
			return;}
		inAir = true;
		airSpeed = jumpSpeed;
	}

	private void resetInAir() {
		inAir = false;
		airSpeed = 0;
	}


	private void updateXPos(float xSpeed) {
			if(CanMoveHere(hitBox.x+xSpeed, hitBox.y, hitBox.width, hitBox.height, lvlData)){	//+ Chequea por lo que seria la sig Posicion, siguiente por la velocidad que lleve
				hitBox.x += xSpeed;
		}	else {
				hitBox.x = GetEntityXPosNextToWall(hitBox, xSpeed);
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
		if(!IsEntityOnFloor(hitBox, lvlData));
			inAir = true;
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
	
	public void setAttacking(boolean attacking){
		this.attacking = attacking;
	}

	public void setJump(boolean jump){
		this.jump = jump;
	}
}


