package Bro_Serialization.TryFiles_same_Folder;

import java.io.Serializable;

public class User implements Serializable{

    String username;
    transient String password;  //Como ahora es transient, se ignoraria
    //private static final long serialVersionUID = 1; //* Nosotros mismos le podemos asignar este numero, es mas como para llevar versiones de cosas, es recomendado ponerlo pero bueno
     //* Creo es Mejor dejarlo quieto pa saber bien pero weno */

    public void sayHello(){
        System.out.println("Hello " + username);
    }
}
