package Bro_Collisions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
//&======[Globales]======

	Image image;
	Graphics graphics;
	Box player;
	Box enemy;
	boolean gameOver;

//&======[Constructor]======

	MyFrame(){
	//+======[Creacion de Datos]
		player = new Box(100,100,50,50, Color.blue);	//*X_Inicial, Y_Inicial, Ancho, Alto, Color*/
		enemy = new Box(400,300,50,50, Color.red);
		gameOver = false;

	//+======[Frame]
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setVisible(true);
		this.addKeyListener(new Al());
	}

//&======[Metodos/Funciones]======

	public void paint(Graphics g){
	//+===[Datos]
		//* Esta Image sera toda la pantalla del juego */
		image = createImage(this.getWidth(), this.getHeight());		//*Metodos de la Clase Component */
		graphics = image.getGraphics();
		
	//+===[Draws]
		g.drawImage(image, 0,0,this);							//*Imagen, X_Inicial, Y_Inicial, Frame */
		player.draw(g);
		enemy.draw(g);

	//+===[GameOver]
		if(gameOver){
			g.setColor(Color.red);
			g.setFont(new Font("Mv Boli", Font.PLAIN, 45));
			g.drawString("Game Over Bozo!", 150, 100);
		}
	}

	public void chechCollision(){
		//*Metodo Heredado de la Clase Rectangle, si el jugador se intercepta con el enemigo */
		//* Verifica si lo que lo llamo, se intercepta con un Objeto tipo Rectangle */
		if(player.intersects(enemy)){	
			gameOver = true;
			System.out.println("GameOver");
		}
	}

//&======[Clase Interna]======

	public class Al extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			//*Usamos el keyPressed del frame, para llamar y usar el del Box, en este caso el jugador */
			player.keyPressed(e);
			chechCollision();
			repaint();					//*Metodo del Componente */
		}
	}
}
