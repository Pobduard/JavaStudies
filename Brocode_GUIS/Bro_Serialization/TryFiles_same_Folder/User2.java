package Bro_Serialization.TryFiles_same_Folder;

import java.io.Serializable;

//! Intente pero na, parece que el La Clase de Objeto tiene que ser EXACTAMENTE Igual pa que agarre, da igaul que este en la misma carpeta, sea copia o demas, sino es EXACTO EN todo
//! Entonces NO VA A AGARRAR, por lo que veo aunque tenga Carpetas Diferentes (package), o Nombres Diferentes (User y User2), si tiene algo de eso diferente NO AGARRARÁ
public class User2 implements Serializable{
    String username;
    transient String password;  //Como ahora es transient, se ignoraria
     

    public void sayHello(){
        System.out.println("Hello " + username);
    }
}
