package Bro_NewWindow_Javax_swing;
import javax.swing.*;
import java.awt.*;
public class NewWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello");
    
    
    public NewWindow() {
        label.setFont(new Font(null,Font.BOLD, 25));    // Si al font le pasamos null en el tipo de letra, no cambia el tipo

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }
    
}
