import java.awt.*;
import javax.swing.*;

public class maine {    //Jpanel posee un "Float LayOut Manager" osea ira añadiendo comps al centro y arriba hasta que llene la liena de arriba
    public static void main(String[] args) {

        JLabel greenlbl = new JLabel("Green");
        JLabel bluelbl = new JLabel("Blue");
        JLabel Orangelbl = new JLabel("Mandarina");
        JLabel Redlbl = new JLabel("Apple sued");
        Redlbl.setVerticalAlignment(JLabel.BOTTOM); //*Sirven solamete, porque le cambiamos el LayOut al rojo
        Redlbl.setHorizontalAlignment(JLabel.RIGHT);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);
        redPanel.setLayout(new BorderLayout());
        
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,500,250);
        
        
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,250,500);
        //* Pa cambiar el LayOut Manager, podemos hacer loo siguiente, vamos a cambiar el
        //* Float_LayOut (JPnale) por el Border_LayOut (JLabel)
            greenPanel.setLayout(new BorderLayout());
        
        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(Color.orange);
        orangePanel.setBounds(250,250,500,500);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);
            redPanel.add(Redlbl);   // Añadiendo texto
            bluePanel.add(bluelbl);
            orangePanel.add(Orangelbl);
            greenPanel.add(greenlbl);

        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.add(orangePanel);
    }
}
