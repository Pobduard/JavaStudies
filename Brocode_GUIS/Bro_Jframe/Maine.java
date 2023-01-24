/* import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
 */
/**
 * Main 5:27:00 [BroCode]
 */
public class Maine {
    /**
     * @param args
     */
    public static void main(String[] args) {
//!.
    /* 
        //Jframe es la ventana GUI la cual se le meten los componentes
        JFrame frame = new JFrame(); //crearlo, pero sigue siendo inivisble

        this.setDefaultCloseOperation(Jthis.EXIT_ON_CLOSE);   // si no se pone eso, al darle a la X de cerrar, solo se oculta y sigue corriendo en el fondo
                                                                // Osea por default tiene "HIDE_ON_CLOSE"
                                                                //Tambien se puede poner "DO_NOTHING_ON_CLOSE" para que no haga nada al pulsar la X
        this.setResizable(false);                   // se le quita el rezise, pero tabien entonces la pantalla comleta
        this.setTitle("Jaframe Title");    // titulo de la ventana;
        this.setSize(420, 420);    // meterle tamaño, si se le pasa un objeto de "Dimension" se le hace la D en x y y de una con es valor
        this.setVisible(true);     // ahora visible
        ImageIcon this_image_icon = new ImageIcon("Imagenes/logo.png"); //Se le puede pasar un Image de una, pero si no, direccion dir tambien sirve
        this.setIconImage(this_image_icon.getImage());     // Se uso una direccion relativa al proyecto
        this.getContentPane().setBackground(Color.lightGray);      // Cambiar color del fondo, con un color pre-hecho
        this.getContentPane().setBackground(new Color(123,50,250));  // Se le puede pasar Hexa o RGB, en RGB si ponemos decimales de 0.0 a 1.0 indicamos su trasnparencia
        this.getContentPane().setBackground(new Color(0x0a7e8c));            //Para hexa toca poner 0xFFFFFF osease con eluqe quiero 0x0a7e8c
     */
// !. 
/* 
! Todo eso esta bonito y todo, pero podemos mejor crear todo el frame en una clase aparte, y controlarlo desde ahi
! [Mirar Myframe]
! */

    new MyFrame(); //Si no vamos a usar el frame poa nada, no es necesario darle nombre, dejarlo anonima pues
    }
}