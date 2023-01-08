package Bro_JTextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;
    JTextField textField;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);     //! La clase ya implementa el action listener

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas", Font.ITALIC, 35));
        textField.setForeground(new Color(0x00ffab));
        textField.setBackground(new Color(0xa0f0));
        textField.setCaretColor(Color.WHITE);   //*Esta es la linea que parpadea, de espera detexto
        textField.setText("Type Username");
        textField.setEditable(true);        //*Si no queremos que el usuario edite la caja de texto */

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            button.setEnabled(false);   //* Asi solo funciona 1 vez */
            System.out.println("Welcome "+textField.getText());
        }
    }
    
}
