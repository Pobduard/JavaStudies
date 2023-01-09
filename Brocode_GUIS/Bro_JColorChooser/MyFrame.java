package Bro_JColorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;
    JLabel label;


    MyFrame(){
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick a Color");
        button.addActionListener(this);

        label = new JLabel("This is Some Text");
        label.setFont(new Font("Comic Sans", Font.BOLD, 100));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);  //*Pa que se vea el color de fondo */


        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            JColorChooser colorChooser = new JColorChooser();   // Creado, pero solo eso, no se pa que le damos valor, quizas sea como un listener a cuando se le llame?

            Color color = JColorChooser.showDialog(null, "Pick a Color . . .", Color.white);  //Implememtado ya, padre, titulo, y el color default/inicial
            label.setForeground(color);     //* Asi se cambia el color del texto con lo que elegimos */
        }
    }
}
