package Bro_Packages;

/* 
 * 11:39:00
 * 			Paquetes, basicamente en la realidad son como carpetas con muchas clases adentro, "Paquetes de Funcionalidad"
 * 				por asi decirlo, pero la forma apropiada es crearlos con las opciones de java (el "Java Proyects" en VsCode
 * 				no crear la carpeta uno a lo animal, porque asi el Intelisense lo agarra de una y no hay peos, ademas donde sean necesarios cambios
 * 				como por ejemplo la direccion y demas del paquete, los implementara de una si le decimos que "si" cuando nos avise al respecto)
 * 			Esos paquetes "Personalizados" luego los podemos Importar a nuestros proyectos (Como importamos todo de Normal)
 *			Ej:		import [Paquete donde se encuentra].[Clase que deseamos importar]
 */
// import Tools.Toolbox;

/* 
 ! En este caso especifico no es necesario hacer el import de arriba, mas bien, nos da error, porque el Tools esta dentro del paquete del proyecto 
 !		"Bro_Packages", si estuviese afuera, osease al mismo lvl que "Bro_Packages", si seria necesario, Ej si queremos importar el "MyRunnable"
 import Bro_MultiThreading.MyRunnable;		//! Seria de esta forma
 ! Tons por eso abajo en vez de usar Import, solo indicamos que esta en una carpeta/Paquete dentro del propio Proyecto
 */
 
/* 
 * Todos estos paquetes que usamos de normal, no creamos, los podemos verificar nostros mismos cuando vemos el coso de proyectos
 * 		Cada uno de esos paquete/librerias tipicas, se instalaron al instalar java
 */
public class maine {
	public static void main(String[] args) {
		Bro_Packages.Tools.Toolbox toolbox = new Bro_Packages.Tools.Toolbox(); 
	}
}
