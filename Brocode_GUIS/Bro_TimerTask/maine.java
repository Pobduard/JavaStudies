package Bro_TimerTask;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* 
 * 10:58:00
 * Timer = 		A facility for threads to schedule tasks 		// Basicamente Guarda el tiempo en un
 *				for future execution in a background thread		// Hilo de Fondo
		
 *TimerTask = 	A task that can be scheduled for one-time 		// Una Clase que contiene un metodo "run"
* 				or repeated execution by a Timer				//	Y cuando pase X tiempo (del timer) se va a llevar a cabo la accion del run
*/
public class maine {
    public static void main(String[] args) {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			//!! Es Sencillo usarlos y/o separarlos es usar una clase Interna Anonima, asi:
			int counter = 10;
			@Override
			public void run() {
				if(counter > 0){
					System.out.println(counter+ " Seconds");
					counter--;
				} else {
					System.out.println("Happy New Year! XoXo");
					timer.cancel(); //* Asi Cerramos el Timer
				}
				
			}
		};
	//! Hay mas variaciones de esta funcion, esta es la mas sencilla, le damos una task (accion/tarea), un periodo de tiempo en que se ejecute (Milisegundos)
	// timer.schedule(task, 3000);

	//! Tambien en vez de un delay le podriamos pasar unafecha especifica, pa eso usamos la clase "Calendar" (Calendario)
	Calendar date = Calendar.getInstance();	//* Listener pa meterle valores poco a poco
	date.set(Calendar.YEAR, 2023);	//* Se Define el tipo de valor, y cual se le mete 
	date.set(Calendar.MONTH, Calendar.JANUARY);
	date.set(Calendar.DAY_OF_MONTH, 22);
	date.set(Calendar.HOUR_OF_DAY, 23);		//* El Tiempo es tipo Militar
	date.set(Calendar.MINUTE, 33);		//* El Tiempo es tipo Militar
	date.set(Calendar.SECOND, 0);		//* El Tiempo es tipo Militar
	date.set(Calendar.MILLISECOND, 0);		//* El Tiempo es tipo Militar

	//! Luego se Añade:
	// timer.schedule(task, date.getTime());	//*Asi se ejecuta en el tiempo indicado

		//!Con este,la accion se va a llevar a cabo cada X tiempo que le metamos
		//!Para este es, task/Accion, "Delay" de la 1ra vez que se lleva a cabo, y "Periodo" (Que delay queremos entre las veces)
		// timer.scheduleAtFixedRate(task, 0, 1000);

		//!Tambien en vez de tener un delay inicial, podemos meterle un valor de Calendar ahi, entonces empezara a llevar a cabo la accion
		//!UnaVez que la fecha del Calendar ocurra
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);	//* Asi se lleva a cabo una vez llega la fecha, y como es un contador, cuenta 10 seg despues de eso
	}
}
//*Quede en */