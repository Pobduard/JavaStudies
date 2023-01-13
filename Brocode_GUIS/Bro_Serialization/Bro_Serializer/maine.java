package Bro_Serialization.Bro_Serializer;

import java.io.*;

/* 
* 10:37:00      Serializacion y Deserializacion
 * Lo importante de esto, es que un objeto ya instanciado lo podemos enviar a byte Code, porque importa?
 * porque si recordamos en lo de leer Files y eso, ese ByteCode lo podemos guardar en un documento aparte (".ser" tipo de archivo), permitiendo asi
 * Que prevalezca luego de que el programa "Muera" (Cierre), cuando vuelva a abrir podemos "Importarlo" y seguira igual que como estaba (el.ser es independientedela plataforma)
 * Asi podemos guardar estados de configuracion, o mas importante, enviar ese ByteCode a otras maquinas, en las cuales se puede abrir y seguira igual
 * Which . . . i mean . . . if you have a SO (Significant Other) . .  can be quite Entretaining/Fun/Kinky if you know what i mean (/// ͡° ͜ʖ ͡° ///)
 */

public class maine {
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
    FileOutputStream fileOut = new FileOutputStream("Bro_Serialization/Bro_Serializer/UserInfo.ser") ;    /* [Paso 3] */ //!Crear el Objeto a salir, se le mete el nombre y direccion que deseemos+ el .ser
    ObjectOutputStream out = new ObjectOutputStream(fileOut);                  /* [Paso 4] */ //! La forma se sacar el archivo + definir a donde va a salir (El Archivo de arriba)
    out.writeObject(user);      /* [Paso 5] */      //! Con la forma y a donde definido(2 lineas de arriba), procedemos a sacar el objeto deseado
    out.close();                /* [Paso 6] */      //! Cerrar lo abierto arriba
    fileOut.close();            /* [Paso 6] */


    System.out.println("ObjectInfo Saved! :D");
    }
}
// ! Este obejto guardado ira al DeSerializer