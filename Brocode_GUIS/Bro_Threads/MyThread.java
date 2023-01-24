package Bro_Threads;

public class MyThread extends Thread {
	
	@Override
	public void run() {		//* La Clase Thread(Hilo) de normal ya tiene esta funcion pero la vamos a
							//* Sobreescribir para la demostracion
		

		if(this.isDaemon()){
			System.out.println("This is a Daemon Thread that is Running");
		}	else	{
			System.out.println("This is a User Thread that is Running");
		}
	}
}
