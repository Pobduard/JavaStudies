package Bro_DragPanel;

import javax.swing.*;


public class MyFrame extends JFrame{

    DragPanel dragPanel = new DragPanel();

    MyFrame(){

        this.add(dragPanel);
        this.setTitle("Drag & Drop Demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(3);


        this.setVisible(true);
    }
    
}
