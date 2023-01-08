package Bro_GridLayout;
import java.awt.*;
import javax.swing.*;
/* 
 * 6:42:28
 */
public class maine {
    
public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
    frame.setLayout(new GridLayout(3, 3, 5, 3));  //! Como es un grid, 1ro lepasamos cant de lineas, y luego de columnas que deseamos
    //* Luego de eso, la 3ra posicion, es "gap" entre elementos en la x, y el 4to es en la y
    //! lo importante en estos, es que si hay mas elementos de los que el grid puede balancear de normal, lo intentara balancear con el nuevo (Como se ve con los 10 elemetos que inteto balancear)
    
    
    frame.add(new JButton("1"));
    frame.add(new JButton("2"));
    frame.add(new JButton("3"));
    frame.add(new JButton("4"));
    frame.add(new JButton("5"));
    frame.add(new JButton("6"));
    frame.add(new JButton("7"));
    frame.add(new JButton("8"));
    frame.add(new JButton("9")); 
    frame.add(new JButton("10")); 
    
    frame.setVisible(true);
}
}
