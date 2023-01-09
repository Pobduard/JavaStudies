package Bro_JSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;


public class SliderDemo implements ChangeListener{
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    SliderDemo(){

        frame = new JFrame("Slider Demo");

        panel = new JPanel();

        label = new JLabel();

        slider = new JSlider(0, 100, 50); //! Podemos pasar los valores de aqui, tons le damos valor minimo, maximo, y donde empieza
        slider.setPreferredSize(new Dimension(400,200));

        slider.setPaintTicks(true);         //! Las separaciones
        slider.setMinorTickSpacing(10);     //! cada cuanto una separacion aparece , pero aun no poseen numeros

        slider.setPaintTicks(true);         //! Las separaciones
        slider.setMajorTickSpacing(25);     //! Del valor "Grande"

        slider.setPaintLabels(true);    //! Que halla texto de los valores
        slider.setFont(new Font("Mv Boli", Font.BOLD, 15));

        slider.setOrientation(SwingConstants.VERTICAL);     //! Asi hacemos el Slider Vertical
        // slider.setOrientation(SwingConstants.HORIZONTAL);     //! Asi hacemos el Slider Horizontal

        label.setText("°C = " + slider.getValue());     //* Queremos hacer como un termometro, por eso la °C, ero interesante que podemos usar el + [Algo] en el texto del label */
        label.setFont(new Font("Mv Boli", Font.BOLD, 25));
//! Podemos haber puesto que sea el + la variable, pero sin cambiar el metodo de abajo
//! no se actualiza, tons a ello
        slider.addChangeListener(this);     //this porque ya se implementa

        panel.add(slider);
        panel.add(label);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.pack();

        frame.setVisible(true);
    }



    @Override
    public void stateChanged(ChangeEvent e) {
            label.setText("°C = " + slider.getValue());
        
    }
    
}
