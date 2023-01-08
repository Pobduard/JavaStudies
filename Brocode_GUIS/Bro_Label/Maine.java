import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
/**
 * Main [5:40:00]
 */
public class Maine {
    

    public static void main(String[] args) {
    ImageIcon img = new ImageIcon("Imagenes/logo.png");
    Border border = BorderFactory.createLineBorder(Color.CYAN, 2, true); // Ese metodo tiene muchas opciones internas de parametros

    JLabel label = new JLabel(); //* Crear label // Se le puede meter aqui de una el texto y el constructor se encarga
    label.setText("Bro do you even Code?");  //* Insertar Texto 
    label.setIcon(img); //Podemos meterle imagen si es de tipo Icon
    label.setHorizontalTextPosition(JLabel.CENTER);   //Pa darle orientacion al texto
    label.setVerticalTextPosition(JLabel.TOP);      // Relativo a la imagen
    label.setForeground(new Color(0xffabcf)); //RGB o Hex
    label.setFont(new Font("MV Boli", Font.ITALIC, 25));    //Letra, estilo, tamaño
    label.setIconTextGap(-5);  //* Determina Espacio entre el texto y la imagen, (+ lejos), (- cerca)
    label.setBackground(new Color(0xafcfbf));   //* De por si no se nota, porque se tiene que poner con otra propiedad
    label.setOpaque(true);  //* Ahora si se va a noyar el Bg Color
    // !Denotar que de por si el Label agarra Todo el espacio posible, se ahi que pinte del Bg Color toda la ventana
    label.setBorder(border);    //Borde añadido, podemos comprobar que se va cambiando el espacio del label en si
    label.setVerticalAlignment(JLabel.CENTER);  //Despues de creado, au  podemos cambiar su justificacion
    label.setHorizontalAlignment(JLabel.CENTER);    // Con ambos, siempre tara al centro

    /* 
    ! De base, esto viene conun "LayOut Manager", luego lo cambiaremos pero de momento lo podemos desactivar
    ! por ese coso es que agarra todo el espacio posible, 
    * se cambia en el Frame 
    */

    // label.setBounds(100, 0, 250, 250); //Inicio x, Inicio y, Final x, Final y

    /* Si le quitamos el Bound al label, y el Layout al fvrame, podemos usar algo mejor "frame.pack" */

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    frame.setSize(500, 500);
    //    frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();   //* Con esto se pone al tamaño necesario para todos los componentes del frame
        //*¨El Frame se tiene que poner al Final, osea luego de procesar los componenteso no los agarrara
    }
}