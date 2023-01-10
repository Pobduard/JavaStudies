package Bro_DragPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragPanel extends JPanel{

    ImageIcon image = new ImageIcon(new ImageIcon("Imagenes/beefaloicon.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    final int WIDTH = image.getIconWidth(); //*Finals porque no planeamos en cambiar el tamaño de la imagen */
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;   //*Previos Point, punto previo */

    DragPanel(){

        imageCorner = new Point (0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListeer = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListeer);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);    //Es Super de la clase JComponent
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        //* Componente (en este caso el Jpanel) -- Graphic  -- int de posicion en X -- int de posicion en Y */
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();  //* Para ir actualizando el punto
        }
    }

    private class DragListener extends MouseMotionAdapter{
        //! Esto es lo que va a mover la imagen mietas movamos el mouse

        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            imageCorner.translate(
                (int)(currentPt.getX() - prevPt.getX()),    //! Traduce a Point la dimension
                (int)(currentPt.getY() - prevPt.getY())     //! Dimension que en si son int, int en X y en y
                                                            //! Lo Demas es para el calculo de donde se encuentra
            );
            prevPt = currentPt; //* Actualizarlo */
            repaint();  //! De la clase Component, dezconozco porque se puede usar
        }
    }
}
