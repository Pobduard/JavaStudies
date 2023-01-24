package Bro_Executable;

/* 
 * 11:51:00
 * Las intrucciones tab bien para los IDE, pero en VSCode como es? bueno, es usar la extension de java "Project Manager"
 * 		ya viene por Default con las Extensiones de java, tons nos vamos a esa parte (Abajo del Todo en el Explorer)
 * 		lo abrimos y ahi tenemos muchas opciones, de ahi podemos crear paquetes y clases a lo bien (no lo tipico de VSCode pues, por todos los peos de java)
 * 		pero si nos fijamos en el propio titulo, Tenemos las opciones del	[Create New Project]	[Export Jar]	[Rebuild All]	[Collapse All]	[More Actions]
 * 
 * El "Export Jar"	es lo que vamos a usar nosotros estando en VSCode, en mi experiemcia, automaticamente busca en nuestro proyecto (y los paquetes/SubCarpetas del mismo)
 * 		Donde se que halla un metodo "main" parala clase (donde empieza el programa), y nos da la opcion de elegir cual de todos esos proyectos con "main" es el que vamos a construir/exportar
 * 		a mi se me exporto/contruyo automaticamente a la misma carpeta total del proyecto "Brocode_GUIS"
 * 		lo importante es que ese ".jar" ya es un ejecutable
 */
public class maine {
	/* 
	 * Ahora ya con el .jar hecho,siempre va a tener el icono por default del JVM
	 * 		Si se lo deseamos cambiar necesitaremos una imagen de tipo ".ico"
	 * 		 por eso Bro nos recomienda una pagina ahi
	 https://icoconvert.com/ (this is a decent site)
	* Luego de tenerel .ico , usa otro software de 3ra persona (Launch4J), que va a ser como un "Wrapper" (Envoltorio)
	* para que convierta el .jar (que YA es Ejecutable) e un .exe con icono personalizado
	* Necesario? NO. pero al que le interese pues eso, pilasque el Launch4J Tuvo un error en su codigo hae no demasiado (Exploit Bestial 
	*que permitia tomar posesion de otras pcs y todo, correr codigo de Java pues de forma remota)
	*	Para usar el Launch4J basicamente le pasamos la direccion a donde salga/se guarde el ".exe"
	*	le pasamos pa direccion absoluta de nuestro ".jar" a convertir
	*	Le pasamos el ".ico"	que deseamos
	*	y finalmente tambien le pasamos la direccion del JDK	(C:\Program Files\Java\jdk-14.0.1	(ó Quizas el)		C:\Program Files\Eclipse Adoptium\jdk-17.0.5.8-hotspot)
	*	Luego de pasar todo eso le damos al botonde "Build Wrapper"		(Construir Envoltorio)
	 */
}
