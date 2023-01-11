package Bro_2DGraphics;
import javax.swing.*;

public class MyFrame extends JFrame{
    MyPanel panel;

    MyFrame(){
    
    panel = new MyPanel();
    
    this.setDefaultCloseOperation(3);
        
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);    //! Con esto aparece en el medio de todo, no es relativo al 0 0 usual
    this.setVisible(true);
    }

    
}
