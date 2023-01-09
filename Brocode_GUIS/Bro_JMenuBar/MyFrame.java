package Bro_JMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JMenuBar menuBar;   //* */ La creamos, pero originalmente no aparece nada, porque aja ta la barra, pero no tiene sus menus aun
    JMenu fileMenu;  //* Esto ya es cada menu */
    JMenu editMenu;  //* Pero ninguno tiene Items */
    JMenu helpMenu; 
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    MyFrame(){
        this.setDefaultCloseOperation(3);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("load");
        saveItem = new JMenuItem("save");
        exitItem = new JMenuItem("exit");

        loadItem.addActionListener(this);       //! Pa que se registren las acciones de cada item
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

/*
*        loadItem.setIcon(icon);           //*Tambien se le puede poner iconos a cada, no lo hare por pereza
*        saveItem.setIcon(icon);           //* Pero es como siempre, ImageIcon, seleccionar, y listo, usarla
*        exitItem.setIcon(icon); 
*/

        //! Algo que ta,bien podemos hacer, es añadir KeyBoard Shortcuts, osease atajos de teclado a cada item del menu:
        loadItem.setMnemonic(KeyEvent.VK_L);        //! Asi entonces es la l minuscula o mayuscula, supongo el VK indica cada Key del Keyboard
        saveItem.setMnemonic(KeyEvent.VK_S);        //! s para save
        exitItem.setMnemonic(KeyEvent.VK_E);        //! e para exit
        //! Lamentablemente pa que agarre aun debemos darle 1ro a su menu, osea "Bajarlo" y entonces ya nos agarraria
        //! Imagino que quizas se podria arreglar añadiendoselo despues al menu igualito que arriba, pa que quizas agarre el menu e inmediato agarre el Item pero eso
        
        //! Parece que los de menu siempre van con el alt de una, sin ese no agarra
        fileMenu.setMnemonic(KeyEvent.VK_F);        //*Alt + f; File menu*/
        editMenu.setMnemonic(KeyEvent.VK_E);        //*Alt + e; Edit menu */
        helpMenu.setMnemonic(KeyEvent.VK_H);        //*Alt + h; Help menu*/
        
        fileMenu.add(loadItem); //* Toca irlos añadiendo en su jerarquia respectiva, items a menus, y menus al la barra de menu
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        

        this.setJMenuBar(menuBar);  
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadItem){
            System.out.println("Beep Boop, you Loaded a file");
        }
        else if(e.getSource() == saveItem){
            System.out.println("Beep Boop, you Saved a file");
        }
        else if(e.getSource() == exitItem){
            System.out.println("Beep Boop, you Exit a file");
            System.exit(0);     //! Con Eso salee del Runtime, osea cierra la Ventana, la termina Ya
        }
    }
    
}
