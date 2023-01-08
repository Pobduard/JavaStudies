package Bro_BorderLayOutManager;
import java.awt.*;
import javax.swing.*;
/*
 *6:24:44 
 */
public class maine {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 10));    //* el Default de frame, pero de todas formas por si acaso */
                                            //! Usualmente seria hasta ahi, pero el el BorderLayout le podemos pasar un margen x y para los componentes
        frame.setSize(500, 500);
        frame.setVisible(true);

// -------[Main Panels] -------->
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3  = new JPanel();
        JPanel panel4  = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.blue);

        panel5.setLayout(new BorderLayout());

        panel1.setPreferredSize(new Dimension(100, 100));   //Tamaño Preferido
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

// -------[Sub Panels] -------->
JPanel panel6 = new JPanel();
JPanel panel7 = new JPanel();
JPanel panel8  = new JPanel();
JPanel panel9  = new JPanel();
JPanel panel10 = new JPanel();

panel6.setBackground(Color.black);
panel7.setBackground(Color.darkGray);
panel8.setBackground(Color.gray);
panel9.setBackground(Color.lightGray);
panel10.setBackground(Color.white);

panel5.setLayout(new BorderLayout());   // El que va a ser el contenedor de todo

panel6.setPreferredSize(new Dimension(50, 50));   //Tamaño Preferido
panel7.setPreferredSize(new Dimension(50, 50));
panel8.setPreferredSize(new Dimension(50, 50));
panel9.setPreferredSize(new Dimension(50, 50));
panel10.setPreferredSize(new Dimension(50, 50));

panel5.add(panel6, BorderLayout.NORTH);
panel5.add(panel7, BorderLayout.SOUTH);
panel5.add(panel8, BorderLayout.WEST);
panel5.add(panel9, BorderLayout.EAST);
panel5.add(panel10, BorderLayout.CENTER);

// -------[###] -------->

        frame.add(panel1, BorderLayout.NORTH);  // Que añadimos, y con que manager
        frame.add(panel2, BorderLayout.WEST);  // Que añadimos, y con que manager
        frame.add(panel3, BorderLayout.EAST);  // Que añadimos, y con que manager
        frame.add(panel4, BorderLayout.SOUTH);  // Que añadimos, y con que manager
        frame.add(panel5, BorderLayout.CENTER);  // Que añadimos, y con que manager
    }
}
