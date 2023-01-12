package Bro_2DAnimation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyPanel extends JPanel implements ActionListener{
    
    final int PANEL_WIDTH = 500;    //* No queremos se modifique el Tamaño Total */
    final int PANEL_HEIGHT = 500;
    Image enemy;                    //* Diferentes Imagenes que vamos a usar */
    Image backgroundImage;
    Timer timer;                    //* IDk Yet */
    int xVelocity = 5;              //* Velocidad con la que va a ir mooviendose en la X-axes */
    int yVelocity = 1;              //* Velocidad con la que va a ir mooviendose en la Y-axes */
    int x = 0;                      //* Posicion Inicial en X */
    int y = 0;                      //* Posicion Inicial en Y */

    MyPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        enemy = new ImageIcon("Imagenes/beefaloicon.png").getImage().getScaledInstance(100, 100, Image.SCALE_FAST);
        backgroundImage = new ImageIcon("Imagenes/wall.jpg").getImage().getScaledInstance(500, 500, Image.SCALE_FAST);
        timer = new Timer(10, this);      //! Necesita un delay en Milisegundos, y un ActionListener, hay mejores formas de hacerlo, pero de momento, solo lo implementamos y usamos this
        timer.start();                             //! Luego de 1 seg, va a llevar acabo la accion del Listener, en este caso el de abajo "actionPerformed"
    }

    public void paint(Graphics g){  //! Funciona porque el paint se llama de fondo al usar la clase Swing, no se porque no es Overrride pero bueno 
        
        super.paint(g);     //! Lo hacemos porque sin esto, el background no se pone, ya que el Graphics lo reemplazamos mas abajo, ton usamos el 
                            //! Super para poder pintarlo antes de
        
        Graphics2D g2D = (Graphics2D) g;    //* 2D Porque nos da mas opciones asi */
        g2D.drawImage(backgroundImage, 0, 0, null); //* queremos que siempre este presente, y siempre anclada, por eso esta aquie que se repinte, y harcodeada las coordenadas */
        g2D.drawImage(enemy, x, y, null); //* Imagen, posicion en x y, observer que no hemos visto tons null */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= PANEL_WIDTH-enemy.getWidth(null) || x < 0){  //* El Width del panel + el de la imagen, el getWidth pide un oberver, peor lo pasamos en null*/
            xVelocity = xVelocity * -1; //* Le cambiamos la direccion haciendo el numero negativo , cuando llegue al limite de X, o a ser poco menos de x*/
        }
        if(y >= PANEL_HEIGHT-enemy.getHeight(null) || y < 0){
            yVelocity = yVelocity * -1;
        }
        x = x + xVelocity;
        y = y + yVelocity;
        repaint();          //! Si no lo ponemos, no se va a actualizar la pantalla, tenemos que llamar nuavamente al paint
                            //! No lo llamamos directo porque dice que no lo hagamos, y mejor lo hagamos a traves del repaint como hicimos
        
    }
}
