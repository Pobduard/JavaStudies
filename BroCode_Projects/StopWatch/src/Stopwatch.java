import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
//!--------------------------[Global Variables]---------

	JFrame frame = new JFrame();
	JButton startButton= new JButton("Start");
	JButton resetButton= new JButton("Reset");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;	//* Milisegundos luego de que empezemos el Cronometro, basicamente el tiempo el mismo */
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;	//*Si ha empezado o no */
	String seconds_string = String.format("%02d", seconds);		//*String con formato, que se llena con 00 si no posee nada */
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	//! Timer
	Timer timer = new Timer(1000, new ActionListener(){	//! Timer al cual se le pasa un delay de frecuencia, y un ActionListener que vamos a definir aqui mismo
		public void actionPerformed(ActionEvent e){
			//! Aqui van las acciones que va ahacer el timer cada X Delay que el hallamos puesto
			//*---[Actualizar Datos]---*/
				elapsedTime+=1000;	//*Que los Milisegundos vayan subiendo de a 1 segundo */
				hours = (elapsedTime/3600000);		//*Transformacion de Milisegundos a Horas, 3Millones600Mil */
				minutes = (elapsedTime/60000) % 60;		//*Mismo de arriba, pero el Restante de la division, pa que sea en "base 60", osease, el resultado jamas pase de 60 */	
				seconds = (elapsedTime/1000) % 60;
				seconds_string = String.format("%02d", seconds);	//*Actualizamos Valores */
				minutes_string = String.format("%02d", minutes);
				hours_string = String.format("%02d", hours);

			//*---[Actualizar Frame]---*/
				timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			}
		}
	);

//!--------------------------[Constructor]---------
	Stopwatch(){
//*-----[timeLabel]----- */
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);	//*Como estara estructurado el tiempo */
		timeLabel.setBounds(100,100,200,100);							//*Posicion del Texto*/
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));					//*Font/Tipo de Texto */
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));						//*Borde */
		timeLabel.setOpaque(true);												//*Para que se vea mejor */
		timeLabel.setHorizontalAlignment(JTextField.CENTER);


//*-----[startButton]----- */
		startButton.setBounds(100,200,100,50);		//*Tamaño/Dimension */
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));					//*Font/Tipo de Texto */
		startButton.setFocusable(false);			//*Asi nose nos va a ir para este la seleccion */
		startButton.addActionListener(this);				//*Listener, que esta implementado en la misma clase */


//*-----[resetButton]----- */
		resetButton.setBounds(200,200,100,50);		//*Tamaño/Dimension */
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));					//*Font/Tipo de Texto */
		resetButton.setFocusable(false);			//*Asi nose nos va a ir para este la seleccion */
		resetButton.addActionListener(this);				//*Listener, que esta implementado en la misma clase */


//*-----[Frame]----- */
	//*+++[Adds]+++
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);

	//*+++[Frame Itself]+++
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);




		frame.setVisible(true);
	}

//!--------------------------[Methods/Functions/Overrrides]---------


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){		//! Verificando de donde viene la Accion Detectada para su Funcionalidad Correspondiente
	//*Start/Stop Button */
			if(started == false){		//! Vamos a hacer que el mismo boton sea de iniciar y parar
				started = true;			//*Cambiamos el Chequeo */
				startButton.setText("Stop");
				start();
			} else {
				started = false;
				startButton.setText("Start");
				stop();
			}

	//*Reset Button */
		}	else if (e.getSource() == resetButton){
			started = false;		//*Lo Estamos reiniciando, entonces no ah empezado */
			startButton.setText("Start");
			reset();
		}
	}

	void start(){
		timer.start();		//*Que Empezemos el timer */
	}

	void stop(){
		timer.stop();		//*Detengamos el Timer */
	}

	void reset(){		//*Parar Datos, Reiniciarlos a sus Valores Originales, Actualizar */
		timer.stop();
		elapsedTime = 0;
		seconds = 0; 
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", seconds);	//*Actualizamos Valores */
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
	}
	
}
