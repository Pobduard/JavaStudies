package Bro_KeyBindings_Swing_Components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {

    JFrame frame;
    JLabel label;

    Action upAction;    //! Objeto de la clase Accion para poder meterlo mejor
    Action downAction;
    Action leftAction;
    Action rightAction;

    Game(){

        frame = new JFrame("Key Binding Demo");
        frame.setDefaultCloseOperation(3);
        frame.setSize(420,420);
        frame.setLayout(null);

        label = new JLabel();
        label.setBackground(Color.BLUE);
        label.setBounds(100,100,100,100);
        label.setOpaque(true);
        

        //! Las Acciones las declaramos peor no Instanciamos, vamos a eso

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        //! Añadir los Keybinds al componente de Swing en este caso el label
//* Up */
        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");  
        //* Mapa para añadirle la accion,relacionada co0n un nombre ("UP" indica la flecha de arriba, lo siguiente es un nombre pa eso, no id, nombre) */
        label.getActionMap().put("upAction", upAction); //! La referencia al nombre de arriba, y la accion en si ya creada
//* Down */
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "dwAction");  //*Nombre raro aporpsito para notar diferencia */
        label.getActionMap().put("dwAction", downAction); 

//* Left */
        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "lfAction");  
        label.getActionMap().put("lfAction", leftAction); 
//* Right */
        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rgAction");  
        label.getActionMap().put("rgAction", rightAction); 

        //! Misma funcionalidad, pero con wasd pa probar
//* Up */
    label.getInputMap().put(KeyStroke.getKeyStroke('w'), "wAction");  //! Al ser le tecla w, es en 'w' solos, no en " "
    label.getActionMap().put("wAction", upAction); 
//* Down */
    label.getInputMap().put(KeyStroke.getKeyStroke('s'), "sAction");    //! Demostrando que este nombre no importa
    label.getActionMap().put("sAction", downAction);    //! La Funcionalidad el KeyBinding esta ahi, en esa Accion

//* Left */
    label.getInputMap().put(KeyStroke.getKeyStroke('a'), "aAction");  
    label.getActionMap().put("aAction", leftAction); 
//* Right */
    label.getInputMap().put(KeyStroke.getKeyStroke('d'), "dAction");  
    label.getActionMap().put("dAction", rightAction); 


        frame.add(label);
        frame.setVisible(true);

    }

    public class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()    -   10);    //* Asi lo movemos Arriba */
            
        }
    }

    public class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()    +   10);    //* Asi lo movemos Abajo */
            
        }
    }
    
    public class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()  -   10, label.getY());    //* Asi lo movemos Izquierda */
            
        }
    }


    public class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()  +   10, label.getY());    //* Asi lo movemos Derecha */
            
        }
    }
}
