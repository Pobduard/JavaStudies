package Bro_JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotdogButton;
    

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaButton = new JRadioButton("Pizza");
        hamburgerButton = new JRadioButton("Hamburger");
        hotdogButton = new JRadioButton("HotDog");

        ButtonGroup group = new ButtonGroup();  // Para poder limitar los botones, toca meterlos en un grupo
        group.add(pizzaButton);
        group.add(hamburgerButton);     //! Como todos pertenecenal mismo grupo, solo se puede seleccionar de a 1 a la vez
        group.add(hotdogButton);        //! pero como cadavez que seleccionamos creamos un evento, lo podemos detectar

        //!!!!!Les faltaba los ActionListener
        pizzaButton.addActionListener(this);
        hamburgerButton.addActionListener(this);
        hotdogButton.addActionListener(this);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {    //!Lo Hice inicialmente,pero aun les faltaba ActionListener a cada uno de ellos
        if(e.getSource() == pizzaButton){
            System.out.println("Pizza!");
        }else if(e.getSource() == hamburgerButton){
            System.out.println("Hamburger!");
        } else if(e.getSource() == hotdogButton){
            System.out.println("HotDog!");
        }
        
    }
    
}
