package Bro_2DGraphics;

import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel{

    Image img;
    MyPanel(){
        //*Por Bro, el .getImage() convierte el ImageIcon en una imagen de una */
        //*Gracias a Willy, el .getScaledInstance(), nos da una imagen escalada, a las dimensiones que metamos, y como queremos que lo escale con propiedades del Image.[Algo] */
        // img = new ImageIcon("Imagenes/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img = new ImageIcon("Imagenes/wall.jpg").getImage();    //! Lo de Arriba "No Agarra" ya que eso usa una funcion asincrona, ya que usa un Algoritmo para la Escala, y este puede tardar mas o menos, osease, imagenes grandes + Escala "Smooth" (Calidad antes de Velocidad) puede ser muy tardado
        img = img.getScaledInstance(100, 100, Image.SCALE_FAST);
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g){ //! Vamos a "Sobreescribir" una de las funciones normales de la clase abstracta "Componentes" (Usada en todo lo de ahora)
                                    //! Ya que esta por defecto usa la clase "Graphics" y ya esta desactualizada, tons lo vamos a castera a una mas actual, la 2D
    Graphics2D g2D = (Graphics2D) g; //*Casteandolo pa hacerlo en la mas actual, ya que esta tiene mas funciones utiles*/                                

    g2D.setPaint(Color.BLUE);   //* Color del "Trazo" */
    g2D.setStroke(new BasicStroke(5));         //* Grosor del "Trazo" */
    
    //* Linea */
    // g2D.drawLine(0, 0, 500, 500);   //* Una Linea, x y Iniciales, x y Finales de la linea */
    /* 
    ! El Problema de eso de atras, es que esta clase tambien cuenta la barra de "Titulo, Minimizar, cerrar" y eso, como parte de ese cuadro de 500x500
    ! Tons si corremos eso, la 2 no sera totalmente diagonal con el origen, no pa nosotros, de ahi que sea mejor meter eso en un panel, 
    ! en panel al frame, y en el panel ya estara bien
     */

    //* Rectangulo */
    g2D.setPaint(Color.PINK);
    // g2D.drawRect(0, 0, 100, 200);   //* Dibujando un Rectangulo
    // g2D.fillRect(0, 0,100,200); //* Mismo de antes, pero un rectangulo Lleno, las formas llenas son diferente funcion
//! Algo que recordar, que es que cualquier Grafico nuevo que pongamos, va a estar por encima de los que ya estaban creados
//* Circulo */
    g2D.setPaint(Color.ORANGE);
    // g2D.drawOval(0,0,100,100);
    // g2D.fillOval(0,0,100,100);

    //! Intentando hacer una pokebola
    // g2D.setStroke(new BasicStroke(1));
    // g2D.setPaint(Color.RED);
    // g2D.fillArc(0,0,100,100,0,180); //* Un poco diferente, xy Inicial xy Final, Angulo inicial, angulo que hace el arco */
    // g2D.setPaint(Color.WHITE);
    // g2D.fillArc(0,0,100,100,180,180); //* Un poco diferente, xy Inicial xy Final, Angulo inicial, angulo que hace el arco */
    
    //* Triangulo */

    // int[] XPoints = {150,250,350};  //! Puntos de los vertices en X
    // int[] YPoints = {300,150,300};  //! Puntos de los vertices en Y, por eso el 150, mas arriba que los demas
    // g2D.setPaint(Color.YELLOW);
    // g2D.drawPolygon(XPoints, YPoints, 3); //* Toca pasar Arrays de X y Y, y luego cuantos punto/esquinas posee el triangulo, ya que estamos dibujando un polygono realmente */
    // g2D.fillPolygon(XPoints, YPoints, 3); //* Toca pasar Arrays de X y Y, y luego cuantos punto/esquinas posee el triangulo, ya que estamos dibujando un polygono realmente */
    
    //* Texto */

    // g2D.drawString("You Are a Winner", 0, 0);   //*Este no se ve, porque curiosamente, en el String, la Coordenada empieza es en la esquina inferior Izquierda, osea se encuentra por encima del 00 que le metimos */
    // g2D.setPaint(Color.MAGENTA);
    // g2D.setFont(new Font("Ink Free", Font.BOLD, 50));
    // g2D.drawString("You Are a Winner", 50, 50); //* Este ahora si se ve al estar por debajo de 0 0 */

    //* Añadiendo Imagen Externa */
    //! Hay varios metofos diferentes, pa este ejemplo se uso el que lleva un "ImageObserver", pero como no sabemos que es, se puso en null
    g2D.drawImage(img, 0, 0, null);     //*La Imagen esta creada desde el Constructor */
}   
    //! Todo lo de arriba estaba Originalmente en el frame, al meterlo aqui en el panel, ya nos agarra bien
}
