package Bro_JLayeredPanes;
import java.awt.*;
import javax.swing.*;
/* 
 * 6:47:28
 ! Basicamente, es igual que un panel, pero que posee la 3ra dimension para sus componentes, osease profundidad
 */
public class maine {
    public static void main(String[] args) {
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50,50,200,200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100,100,200,200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150,150,200,200);



        JLayeredPane layeredpane = new JLayeredPane();  
        layeredpane.setBounds(0,0,500,500);
        
        
        //* Si no le ponemos una profundidad especifica a cada elemento, el que vaya de 1ro sera el de mas arriba
        //* Podemos aprendernos los nombres (JLayeredPane.algo), o solo darle un numero cuando lo añadimos, que sera su profundidad
        //! EL Numero que le pasemos, tine que se un objeto de la clase Integer por lo que veo, usar el Integer.valueOf() o no agarra
        layeredpane.add(label1, JLayeredPane.DEFAULT_LAYER);    
        layeredpane.add(label2, Integer.valueOf(2));
        layeredpane.add(label3, JLayeredPane.DEFAULT_LAYER);

        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setLayout(null); 

        frame.add(layeredpane);

        frame.setVisible(true);
    }
}
