package Bro_DialogBoxes;
import javax.swing.*;

/* 
 * 7:06:00
 * JOptionPane = Una caja de dialogo
 */
public class maine {
    public static void main(String[] args) {
        //* El mas basico, comonente al que pertenece, mensaje, Titulo, estilo del titulo, y luego deja un icono para el PopUp
        JOptionPane.showMessageDialog(null, "Useless Info", "Titulo", JOptionPane.PLAIN_MESSAGE);
        //* Cada uno de esos de abajo, es un "Estilo Diferente", solo cambia el Icono de cada uno de ellos, al darle aceptar desaparece
        // JOptionPane.showMessageDialog(null, "Useless Info", "Titulo", JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Useless Info", "Titulo", JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Useless Info", "Titulo", JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Useless Info", "Titulo", JOptionPane.ERROR_MESSAGE);

        //! Otro tipo de caja, deepndiendo del estilo realemnte es que le da funcionalidad, la de abajo retorna valores dependiendo de que se escogio
        int answer = JOptionPane.showConfirmDialog(null, "Bro, do you even code?", "A tittle_bro", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(answer);


        //! Input
        String name = JOptionPane.showInputDialog(null, "Your Name please");
        System.out.println("Hello "+name);


        //! Tambien existe uno que combina to lo de arriba
        ImageIcon icon = new ImageIcon("Imagenes/logo.png");
        String[] responses = {"No, Youre Awesome!", "Thx bro", "Kinda gay ngl"};
        //! Componente padre, mensaje, titulo, tipo de opcion, tipo de mensaje, icono, un array para cambiar las opciones, valor que incialmente esta seleccionado
        JOptionPane.showOptionDialog(null, "You Are Awesome",
         "Shhh", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
          icon, responses, 1);
    }
}
