package Bro_Threads;

/* 
 * 11:08:00
 * 	
    *	thread =	A thread of execution in a program (kind of like a virtual CPU)
    *				The JVM allows an application to have multiple threads running concurrently
    *				Each thread can execute parts of you code in parallel with the main thread
    *				Each thread has a priority.
    *				Threads with higher priority are executed in preference compared to threads with a lower priority
    
	!![Basicamente podemos usar los Hilos para correr partes del programa, lo destacable de estos es que podemos tener multiples hilos al mismo tiempo
	!! causando asi que podamos correr diferentes partes del codigo al mismo tiempo,a cada parte le podemos asignar un nivel de "Prioridad", osease que
	!! es mas importante que X parte se ejecute a que y parte se ejecute antes]

    *			    The Java Virtual Machine continues to execute threads until either of the following occurs
    *					1. The exit method of class Runtime has been called
    *					2. All user threads have died

	!![La maquina virtual de java ejecutara los hilos hasta que:
	!! 1.- se llama el metodo "Exit" de la clase "Runtime"
	!! 2.-Todos los hilos del usuario hallan muerto/acabado]
    					
    *				When a JVM starts up, there is a thread which calls the main method
    *				This thread is called “main”

	!![El main ensi es un hilo,que se llama main]
    						
	!!				Las Deamon Thread No Son creadas por usuarios por defaut, pero una creada la podemo convertir a una Daemon
    *				Daemon thread is a low priority thread that runs in background to perform tasks such as garbage collection 
	*			JVM terminates itself when all user threads (non-daemon threads) finish their execution
 */
public class maine {

	public static void main(String[] args) {
/* 		
		System.out.println(Thread.activeCount());	//* Para ver todos los hilos activos 
		System.out.println(Thread.currentThread().getName());	//*Obtener El nombre del hilo actual 
		Thread.currentThread().setName("MAINNNNNN");				//*Pa Cambair elnombre del Hilo 
		System.out.println(Thread.currentThread().getName());	//*Obtener El nombre del hilo actual 
	
		System.out.println(Thread.currentThread().getPriority());	//* Ver la Prioridad del hilo actual 
		Thread.currentThread().setPriority(10);		//* La Prioridad Del Hilo,  10 es el maximo, 1 es el minimo 
		System.out.println(Thread.currentThread().getPriority());	//* Ver la Prioridad del hilo actual 
	
		System.out.println(Thread.currentThread().isAlive());		//*Verdadero/Falso de si el hilo esta activo/"Vivo" 
	

		//! Tambien podemos "Dormir" los hilos, osease tenerlos en "Pausa" y activarlos despues, o delay tambien
		for (int i = 3; i >0; i--) {	//!Estamos Metiendo un delay para cada vez que pase por el loop
			System.out.println(i);
			try {	//!Podria dar error, tons o usamos try, o "throws"
				Thread.sleep(1000, 0);	//*Milisegundos, Nanosegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	 */
	//!Hay 2 formas de crear hilos, aqui vamos a ver 1, en la clase de "Multi-Hilos" vamos a ver la otra forma
	
	MyThread Hilo2 = new MyThread();	//* Hilo Creado, pero como hereda de thread, puede usar sus metodos
	Hilo2.isAlive();

	Hilo2.setDaemon(false);		//!Podemos asinar si sera Daemon o no (Desconozco si pasa algo si la asignamos como tal despues)

	//! Si bien creamos el hilo, no lo hemos empezado, por eso la condicion anterior es falsa
	Hilo2.start();		//!!Empezamos, cuando el "start" es llamado, internamente el metodo "run" (que Sobreescribimos) tambien es llamado
	Hilo2.isAlive();

	System.out.println(Hilo2.getName());	//* nombre raro porque no le hemos asignado uno personalizado
	Hilo2.setName("Segundo Hilo");
	System.out.println(Hilo2.getName());
	System.out.println(Hilo2.getPriority());	//*Obtener la Prioridad, la prioridad default es "5"

	//! Es importante que la prioridad de los Hilos, viene de:	Cada Hilo hereda la prioridad del hilo donde se creo, como mainves de prioridad "5" tambien lo es nuestro hilo
	Hilo2.setPriority(1);
	System.out.println(Hilo2.getPriority());

	System.out.println("Los Hilos Activos ahora son: " + Thread.activeCount());

	System.out.println(Hilo2.isDaemon());		//*Verificando si es daemon o no


	}
}	//*	Quede En 11:24:00	MultiThreading */