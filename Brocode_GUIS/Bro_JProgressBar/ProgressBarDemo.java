package Bro_JProgressBar;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ProgressBarDemo {
    JFrame frame = new JFrame("Progress Bar");
    JProgressBar bar = new JProgressBar();      //! En El contructor se le puede pasar de una el valor maximo y minimo


    ProgressBarDemo(){
        bar.setValue(0);    //! Valor Inicial
        bar.setBounds(0,0,420,50);   //Sin LayOutManager, toca ponerle tamaño
        bar.setStringPainted(true);     //! Asi hay un porcentaje en la barra
        bar.setFont(new Font("Mv Boli", Font.BOLD, 25));
        bar.setForeground(Color.RED);       //! El Color que llena
        bar.setBackground(Color.BLACK);     //! El Color del fondo

        frame.add(bar);
        frame.setDefaultCloseOperation(3);  //* JFrame.EXIT_ON_CLOSE == int 3
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    private void fill(){
        int counter = 0;
        while(counter <= 100){
            bar.setValue(counter);
            try {
                Thread.sleep(100);     //! Asi hacemos que el programa, o mejor dicho este hilo espere un poco, pa que la barra tarde un poco en llenarse, lo que pasamos son milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //* Try/catch porque puede dar error, usualmente usario al trwo, pero como es una funcion (constructor) que llama a otra (fill) se va a ir propagando el trwo */
            counter += 1;
        }
        bar.setString("Done! :D");      //! Pa que salga una vez se que termino de llenar la barra
        
    }
}
