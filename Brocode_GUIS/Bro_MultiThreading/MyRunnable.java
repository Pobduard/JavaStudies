package Bro_MultiThreading;

public class MyRunnable implements Runnable{
	/* 
	 * Esta es la otra forma de crear un Hilo/Thread, implementar la interface "Runnable" dentro de la clase
	 * y para usarlo/Pasarlo a un Therad, le metemos esta clase al contrusctor del Thread
	 * 
	 ! Esto puede ser una clase o subclase, a diferencia de la creacion de Hilos con Thread (y no implementando el Runnable)
	 ! Este aun nos permite extender cosas (Hacerlo Subclase/ponerle Padre)
	 */

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Up Counter is at number: " + i);

			try {
				Thread.sleep(1000, 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		System.out.println("El Hilo2 ha Finalizado!");
		
	}
	
}
