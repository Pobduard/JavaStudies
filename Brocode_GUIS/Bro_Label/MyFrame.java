import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false); 
        this.setTitle("Jaframe Title"); 
        this.setSize(420, 420); 
        this.setVisible(true); 
        ImageIcon this_image_icon = new ImageIcon("Imagenes/logo.png");
        this.setIconImage(this_image_icon.getImage()); 

        this.getContentPane().setBackground(new Color(0x0a7e8c));
    }
}