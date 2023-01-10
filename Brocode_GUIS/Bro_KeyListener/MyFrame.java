package Bro_KeyListener;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MyFrame extends JFrame implements KeyListener{
    //! Notar que el KeyListener parece tener un Cooldown pequeño
    
    JLabel label;
    Image icon;

    MyFrame(){
        this.setDefaultCloseOperation(3);
        this.setSize(500,500);
        this.setLayout(null);       //!Vamos a mover componentes manualmente,tonsporeso el mejor el null
        this.addKeyListener(this);
        
        icon = new ImageIcon("Imagenes/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        //! Esto es para poder Re-Size it

        ImageIcon imageicon = new ImageIcon(icon);
        label = new JLabel();
        label.setBounds(0,0,100,100);
        // label.setBackground(Color.red);
        // label.setOpaque(true);

        label.setIcon(imageicon);
        
        this.getContentPane().setBackground(Color.BLACK);   //Pa hacer el Background del Frame
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //!     Se Llama cuando se tipea una Key, usa un KeyChar y devuelve un char
        switch (e.getKeyChar()){
            //* Recordar que todo empieza en 0 y nos moveremos respecto a esa coordenada, por eso el +- que pusimos */
            case 'w':
                label.setLocation(label.getX(), label.getY()-10);
                break;
            case 's':
                label.setLocation(label.getX(), label.getY()+10);
                break;
            case 'a':
                label.setLocation(label.getX()-10, label.getY());
                break;
            case 'd':
                label.setLocation(label.getX()+10, label.getY());
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //!     Se Llama cuando una Key fisica es presionada, usa "KeyCode" y devuelve un int reacionado al boton en la teclado (Cada boton tiene un numero asignado a este)
        switch (e.getKeyCode()){
            //* Las flechas de teclado no dan Char, por ello toca ponerlas aqui */
            case 38:    //Arriba
                label.setLocation(label.getX(), label.getY()-10);
                break;
            case 40:    //Derecha
                label.setLocation(label.getX(), label.getY()+10);
                break;
            case 37:    //Izquierda
                label.setLocation(label.getX()-10, label.getY());
                break;
            case 39:    //Abajo
                label.setLocation(label.getX()+10, label.getY());
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //!     Se Llama cuando sea que una Key es libereada/ya no presionada.
        //* Pa ver la diferencia de el KeyChar y el KeyCode */
        System.out.println("You Released KeyChar: " + e.getKeyChar() + " Or KeyCode: " +  e.getKeyCode());
    }
    
}
