package Bro_FlowLayoutManager;
import java.awt.*;
import javax.swing.*;

/* 
 * 6:35:36
 */
public class maine {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.TRAILING, 5,10));  //Uno que no es tipico de frames, * lo otro es su alineacion, la alineacion default es CENTER
        //! Esteframe va por lineas, si el componente se queda sin espacio en la linea, lo pasa a la siguiente columna
        //* Silemetemos intsluego deesoenelconstructor, es espacio enytre los botones, 1ro espacio en x, 2do espacio en y
        frame.setSize(500, 500);
        
        // JButton button = new JButton();  // Como el boton no lo vamos a meter la gran cosa, lo podemos meter de una en el add
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        //* Todos esos botones los podemos meter en un panel */
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9")); 

        frame.add(panel);
        frame.setVisible(true);// Puede haber porblemas con eso, si la visibilidad la habilitanos antes decrearlo,mejordejarla al final
    }
}
// Quede en 6:42:28 en el GridLayout