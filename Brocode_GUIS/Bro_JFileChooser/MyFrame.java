package Bro_JFileChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;


    MyFrame(){
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());

        button = new JButton("Select File");    //* Pa que el boton tenga texto
        button.addActionListener(this);
        
        this.add(button);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){

            JFileChooser fileChooser = new JFileChooser();      //Esto en si es lo que nos deja elegir, pero aqui solo lo creamos, no damos funcionalidad
                                                                //* El Constructor nos deja meterle de una, una direccion de directorio*/

            fileChooser.setCurrentDirectory(new File("."));     //! Recordar, si al file le pones solo el punto, agarra el Directoriodel proyecto, usualmente lo recomendado seria ir al Exritorio y lsito pero eso
            //* Si no metemos eso de arriba, se va al directorio "Por Defecto", en Windows es Documentos, en Lunix su "Home", que al parcer es el comun pa eso */

            //! Estos 2, retornan una respuesta de int, dependiendode la accion que se ejecuto, osea si se eleigiop algo, o si se cancelo, por eso mas abajo el JFileChooser.APPROVE_OPTION, osea la que si se aprovo
            int response = fileChooser.showOpenDialog(null);         //! Estos son la funcionalidad, este solo los muestra/Abre
            // int response = fileChooser.showSaveDialog(null);    //! Este si los guarda, o intenta, habria que hacer mas para realmente crearlo con la clase de File pero eso.

            if(response == JFileChooser.APPROVE_OPTION){    //* JFileChooser.APPROVE_OPTION == int o, osease setorna eso cuando algui si selecciono un archivo, y no salio o la cago*/
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());  //* Pa dar el File Objeto conla direccion Absoluta apropiada
                System.out.println(file);
            }
        }
        
    }
    
}
