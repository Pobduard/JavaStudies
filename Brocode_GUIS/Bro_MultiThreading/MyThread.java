	package Bro_MultiThreading;
	
	public class MyThread extends Thread{
		//! Recordar que cada vez que creemos una instancia de esta clase,
		//! se va a llamar internamente al run, que sobreescribimos abajo

/* 		
		! Esto es una subclase de la Clase "Thread" Problema?
		! Java solo nos permite tener 1 padre, osease solo podemos extender Thread y nada mas
		* Podriamos intentar implementar algo pero eso
*/
		@Override
		public void run(){
			for(int i = 10; i>0;i--){
				System.out.println("Down Counter is at number: " + i);

				try {
					Thread.sleep(1000, 0);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
				//! Vamos a causar un error aproposito para demostrar que los hilos son independientes
				// System.out.println(1/0);
			}
			System.out.println("EL Hilo1 ha Finalizado!");
		}
	}
	