package Bro_MultiThreading;

/* 
 * 10:24:00		MultiThreading
 * 				Es el proceso de ejecutar multiples hilos simultaneamente
 * 					de esta forma ayuda a utilizar el maximo de ma CPU (aprovecharla).
 * 				Los Hilos son independientes, osease no afectan a la ejecucion de otros hilos
 * 					Lo que quiere decir, si sucede un fallo en uno de los hilos,los demas no seran interrumpidos
 * 					esto termina siendo util en servir a diferentes clientes, juegos multijugador, u otras tareas mutuamente-independientes.
 */
public class maine {
	public static void main(String[] args) throws InterruptedException {
		/* 
		 * Vamos a crear 2 Hilos, 1 que cuenta hacia arriba, y otro hacia abajo, simultaneamente
		 */

		 MyThread hilo1 = new MyThread();
		 hilo1.setName("Hilo1");

		 MyRunnable runnbale1 = new MyRunnable();	//!Instanciamos el objeto de la clase que implemneta la interfaz "Runnable"
		 Thread hilo2 = new Thread(runnbale1);		//! instanciamos un Hilo, pasandole el Runnable creado arriba
		hilo2.setName("Hilo2");

/* 		
		hilo1.setDaemon(true);	//! Solo para recordar que el JVM (Java Virtual Machine)
		hilo2.setDaemon(true);	//! No va a esperar a que se finalicen los Daemon Threads para finalizar el programa
								//! Tons como hay un error abajo, el programa terminaria ahi
 */


		hilo1.start();
		hilo1.join();		//! Este Metodo es poderoso, basicamente donde lo llamemos, va a parar ese hilo, hasta que el hilo que indicamos
							//! 	(Este caso el "hilo1") se complete, osease, lo llamamos en main, entonces el mainno va a continuar de 
							//! 	esta linea, hasta que el hilo1 se complete/Muera
							//*		en este caso, causando que el hilo2 no se ejecute hasta que el hilo1 se complete
							//! O Tambie al join le podemos pasar un delay, causando que espere ese delay (del otro Therad) antes de seguir con el codigo donde se llamo
		hilo2.start();		//! porque agarra si la interface no tiene start?, porque la interface se paso al constructor del hilo, ya es otro objeto
	
		System.out.println(1/0);	//!Incluso si hay error en la main, las demas van a continuar
	
		}
}
