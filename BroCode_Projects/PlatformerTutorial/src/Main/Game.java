package Main;
import gamestates.Gamestate;
import gamestates.Playing;
import gamestates.Menu;

import java.awt.*;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameTherad;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	private Playing playing;
	private Menu menu;

	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.2f;				//Intentar que la multiplicacion siempre sea un numero entero
	public final static int TILES_IN_WIDTH = 26;		//Cuantos cuadrados queremos que sea de ancho, Los Visibles almenos
	public final static int TILES_IN_HEIGHT = 14;		//Cuantos cuadrados queremos que sea de alto, Los Visibles almenos
	public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH ;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT ;

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
		menu = new Menu(this);
		playing = new Playing(this);
	}

	private void startGameLoop(){
		gameTherad = new Thread(this);
		gameTherad.start();
	}

	private void update(){
	switch (Gamestate.state) {
			case MENU:
				menu.update();
				break;
			case PLAYING:
				playing.update();
				// levelManager.update();
				// player.update();		//lvl detras del jugador
				break;
			case OPTIONS:
			case QUIT:
			default:
				System.exit(0);							//! va a terminar el Programa
				break;

	}
}

	public void render(Graphics g){
		switch (Gamestate.state) {
			case MENU:
				menu.draw(g);
				break;
			case PLAYING:
				playing.draw(g);
				// levelManager.draw(g);
				// player.render(g);			//lvl detras del jugador
				break;
			default:
				break;
		}
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;		//! Vamos a usar nanosegundos, 9 Ceros = 1 Billon de Nanosegundos= 1 Segundo
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

	public void windowFocusLost() {
		if(Gamestate.state == Gamestate.PLAYING){
			playing.getPlayer().resetDirBooleans();
		}
	}

	public Menu GetMenu(){
		return this.menu;
	}

	public Playing GetPlaying(){
		return this.playing;
	}
}
