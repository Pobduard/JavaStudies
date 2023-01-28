package Main;

import entities.Player;
import java.awt.*;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameTherad;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	private Player player;

	public Game(){
		initClasses();		//Inicializar las clases de todo (Enemigos, Objestos, Jugador etc)

		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		//gameWindow.requestFocus();					//! PON AMBOS POR Si ACASO
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();					//!Para que los Inputs de Normal venga aca
		
		
		
		startGameLoop();
	}

	private void initClasses() {
		player = new Player(200, 200);
	}

	private void startGameLoop(){
		gameTherad = new Thread(this);
		gameTherad.start();
	}

	private void update(){
		player.update();
	}

	public void render(Graphics g){
		player.render(g);
	}

	@Override
	public void run() {
		double timePerFrame = 1_000_000_000.0 / FPS_SET;		//! Vamos a usar nanosegundos, 9 Ceros = 1 Billon de Nanosegundos= 1 Segundo
		double timePerUpdate = 1_000_000_000.0 / UPS_SET;		//! Un Numero con 1_0 es igual a decir 10, el compilador ingora el _ en numeros, pero nos permite ver mejor a nosotros
		
		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;	//Tiempo de las Updates que ira cambiando
		double deltaF = 0;	//Tiempo de los Frames que ira cambiando
		
		while(true){

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;


			if(deltaU >= 1){	//Como decir 100% por la division
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1){	//Como decir 100% por la division
				gamePanel.repaint();
				frames++;
				deltaF--;
			}


			if( (System.currentTimeMillis() - lastCheck)  >= 1000){		//*Chequeamos los Fps Si 1 sehgundo ah pasado desde el ultimo chequeo
				lastCheck = System.currentTimeMillis();
				System.out.println("Fps: " + frames + " Ups: "+ updates);
				frames =  0;								//* Reiniciamos para hacer bein el conteo
				updates = 0;
			}
		}
		
	}

	public Player getPlayer(){
		return this.player;
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

}
