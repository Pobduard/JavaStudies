package Bro_MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements MouseListener{
    
    JLabel label;
    ImageIcon icon;

    MyFrame(){
        this.setDefaultCloseOperation(3);
        this.setSize(500,500);
        this.setLayout(null);

        //! Icono creado a partir de otro icono que se convierte en imagen, para poder Re-Definir sus dimensiones al tamaño deseado
        icon = new ImageIcon(new ImageIcon("Imagenes/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setIcon(icon);
        label.setOpaque(true);      //* Para Demostrar las funciones al cambiar el color de fondo con las acciones del mouse */
        label.addMouseListener(this);   //! Le estamos poniendo el Listener al Label, o al Icono mejor dicho, por ello solo la Zona del Icono Reaccionara

        // this.addMouseListener(this);     //* Pendientes de a que se le pone el listener, puesto a eso respondera despues de todo */
        this.add(label);   
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //! Invocada cuando el mouse se ha clokeado (presionado y liberado, osa completo click) en un componente
        //! Tambien sera invocada si las 2 de abajo se invocan tambien
        System.out.println("You Clicked the Mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //! Invocada cuando el mouse se ha presionado en un componente
        System.out.println("You Pressed the Mouse");
        label.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //! Invocada cuando el mouse se ha liberado (dejar de presionar) en un componente
        System.out.println("You Released the Mouse");
        label.setBackground(Color.GREEN);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //! Invocada cuando el mouse entra en la area de un componente
        System.out.println("You Ehtered the Mouse Area");
        label.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //! Invocada cuando el mouse sale en la area de un componente
        System.out.println("You Exited the Mouse Area");
        label.setBackground(Color.gray);
    }
}
