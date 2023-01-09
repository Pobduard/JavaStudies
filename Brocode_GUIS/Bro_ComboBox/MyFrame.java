package Bro_ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JComboBox comboBox;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[]animals= {"Dog", "Cat", "Bird"};
        //! Para la comboBox, toca pasarle una lista de Objetos, osea los primitivos como int, no agarra, toca que sea Integer
        comboBox = new JComboBox<>(animals);    //! Puede ser un array de varios tipos de objeto,de ahi el tipo Generico
        comboBox.addActionListener(this);
        comboBox.setEditable(true);     //! Permitimos que el usuario busque por la lista, o typee directamente lo que busca y se acepte
        comboBox.getItemCount();        //* Self Explanatory
        comboBox.addItem("Horse");      //! Pa añadir,tenemos que pasar unobjeto del tipo de data correspondiente
        comboBox.insertItemAt("Pig", 0);    //*Objeto, index donde se mete,Self Explanatory */
        comboBox.setSelectedIndex(0);   //* Self Explanatory again, que aparezca preseleciconado , como el Pig lo metemos despues, pero ahroa es 0, no aparece preseleccionado de por si
        comboBox.removeItem("cat");     //*Eliminar objeto especifico
        comboBox.removeItemAt(2);       //* Lo de arriba pero por Index */
        // comboBox.removeAll();        //* Self Explanatory */

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==comboBox){
            System.out.println(comboBox.getSelectedItem());
            //*Se puede usar SelectedIndex para solamente la posicion del objeto
            //*O SelectedObject para un array, por si es un array de cosas supongo
            System.out.println(comboBox.getSelectedIndex());
        }
    }
    
}
