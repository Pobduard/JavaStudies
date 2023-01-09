package Bro_JCheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;
    JCheckBox checkBox;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        checkIcon = new ImageIcon("Imagenes/logo.png");
        xIcon = new ImageIcon("beefaloicon");

        button = new JButton("Submit");
        button.addActionListener(this);     //! Recordar que el this sirve porque se le implimento el ActionListener a la clase


        checkBox = new JCheckBox("I'm Not a Robot");  // podemos usar el setText o el constructor
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Comic Sans", Font.PLAIN, 25));

        //* Pa cambiar las imagenes de la checkBox (Ambas imagenes super grandes, por eso no se ve)
        checkBox.setIcon(xIcon);    //*El default, el de no marcado
        checkBox.setSelectedIcon(checkIcon);    //*El Marcado

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println(checkBox.isSelected());  //! Con esto podemos verificar el estadpo de la checkbox
        }
        
    }
    
}
