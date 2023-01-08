package Bro_JButtun;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener{
// public class MyFrame extends JFrame{
    JButton button; //* Un Boton Global de la clase para poder usarlo mas abajo
    JLabel label;   //* Pa cambiar el texto del boton

    public MyFrame() {
        ImageIcon icon = new ImageIcon("Imagenes/beefaloicon.png");
        ImageIcon icon2 = new ImageIcon("Imagenes/mogus.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(0, 0, 750, 750);
        label.setVisible(false);    // pa que no aparezca de una

        button = new JButton();
        button.setBounds(50, 100, 350, 200); // x inicial, y inicial, x final, y final
       button.addActionListener(this); //! Se le puede pasar this, porque es esta clase misma la que mete el Action Listener
        
        // button.addActionListener(e -> System.out.println("LamBda")); // La expresion lambba qu no necesita Implementar na
        
        button.setText("Lambda Button");   //* Texto al boton */
        button.setFocusable(false); // Quitar un borde alrededor del boton
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.setIconTextGap(-5);
        button.setForeground(Color.ORANGE);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        // button.setEnabled(false);    //! Para deshabilitar un Boton
                                        //! Para hacer mas, podemos meter eso de arriba, lo de deshabilitar, dentro del ActionListener y asi se clikea 1 vez y se deshabilita

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setSize(500, 500);
            this.setVisible(true);
            this.add(button);
            this.add(label);
    }

    @Override   
                //! Esto es para detectar la accion del boton, y en caso de que sea, de que lo que causo el evento sea el boton 
                //! Entonces hara una accion, lo que pusimos despues basicamente, pero ese evento se le tiee que declarar al boton tambien
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            // System.out.println("Poo");
            this.setSize(750, 750);
            label.setVisible(true); //* Asi entonces el label sera "Sorpresa" luego de pulsar el botin 1 vez almenos
        }
    }
     //! Muy bonito y todo, pero podemos hacerlo mas corto y mejor con una expresion lambda, si lo hacemis, no necesitamos implementar el ActionListener
}
