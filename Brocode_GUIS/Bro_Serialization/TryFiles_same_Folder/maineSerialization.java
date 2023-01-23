package Bro_Serialization.TryFiles_same_Folder;
import java.io.*;
public class maineSerialization {
    
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.username = "Bro";
        user.password = "I<3Pizza";


/* 
 * Pasos para Serializar:
 * --------------------------------------------------------------------------------------
 * 1.- Tu Objeto de clase debe de Implementar la Interface "Serializable"
 * 2.- Importarlo ( import java.io.Serializable )
 * 3.- FileOutputStream fileOut = new FileOutputStream(nombre/direccion para el Archivo)
 * 4.- ObjectOutputStream out = new ObjectOutputStream(fileOut)
 * 5.- out.writeObject(objectName)
 * 6.- out.close();     fileOut.close();
 * --------------------------------------------------------------------------------------
 */

    //* Recordar que la direccion default es la del proyecto, tons si no se le pone carpetas ira al proyecto, no a la carpeta del mismo */
    //* Ademas todo esto puede dar error, tons rodearlo por try/catch, o meterlo throws que es mas sencillo */
    FileOutputStream fileOut = new FileOutputStream("Bro_Serialization\\TryFiles_same_Folder\\UserInfo.ser") ;    /* [Paso 3] */ //!Crear el Objeto a salir, se le mete el nombre y direccion que deseemos+ el .ser
    ObjectOutputStream out = new ObjectOutputStream(fileOut);                  /* [Paso 4] */ //! La forma se sacar el archivo + definir a donde va a salir (El Archivo de arriba)
    out.writeObject(user);      /* [Paso 5] */      //! Con la forma y a donde definido(2 lineas de arriba), procedemos a sacar el objeto deseado
    out.close();                /* [Paso 6] */      //! Cerrar lo abierto arriba
    fileOut.close();            /* [Paso 6] */


    System.out.println("ObjectInfo Saved on TryFolder! :D");

    //! Eso es para ver el SerialVersion, es de tipo long, y se saca con toda esa monda:
    long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
    System.out.println(serialVersionUID);       /* 6999954070042753286 Nos dio en el Serializer, el el DeSerialiazer da: 6999954070042753286 , tons iguales, Yay*/
    //! Ese Numero, debe ser igual en la Clase de Serializationy en la de DeSerialization, ya que la clase intermedi de ambas deberia ser igual, y como sale de ahi pues eso
    }
}
