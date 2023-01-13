package Bro_Serialization.Bro_DeSerializer;
import java.io.*;

public class maine {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /* 
         * Pasos para De-Serializar, un "ByteStream" devuelta a un Objeto:
         * -------------------------------------------------------------------------------------
         * 1.-  Declarar el Objeto (No Instanciar Aun), tipo: Class objectNam;
         * 2.-  Implementar la Interface del Serializable en la Clase
         * 3.-  Importar la Interface
         * 4.-  FileInputStream fileIn = new FileInputStream(Direccion del Archivo a Importar);
         * 5.-  ObjectInputStream in = new ObjectInputStream(fileIn);
         * 6.-  objectNam = (Class) in.readObject();
         * 7.-  in.close();     fileIn.close();
         * -------------------------------------------------------------------------------------
         ! Basicamente el mismo proceso pero en reversa y ademas declarar el objeto, y lueeego de todo lo demas, ya lo instanciamos, porque ya tenemos la info para ello
         ! Ademas todo esto puede dar error, tons rodearlo por try/catch, o meterlo throws que es mas sencillo
         ! Importante tambien recordar, que si es un tipo Creado, como "User" en este caso, Debemosde usar la misma clase, o una clase "Igual (Equals)" para que no falle
         ! Desconozco si sirve una clase con los mismo tipos de datos pero diferente nombre para ellos, lo dudo porque estos se pueden medio "Ver" en el Propio ByteCode pero eso
         */

        User nombreObjeto;    /* [Paso 1] */  //* Declarar, pero no instanciamos porque no poseemos la info aun */
        FileInputStream fileIn = new FileInputStream("C:\\Users\\JAIBER A\\Desktop\\Pob\\Code Related\\Java\\JavaPractice\\Brocode_GUIS\\Bro_Serialization\\Bro_Serializer\\UserInfo.ser");  /* [Paso 4] */ //* Declarar e Instanciarel Objetoa donde ira la ifno, y definir de que archivo entrara la info tambien, en este caso tiene una direccion relativa del proyecto */
        ObjectInputStream in = new ObjectInputStream(fileIn);        /* [Paso 5] */      //* Definir conque va a entrar la info de arriba */
        Object obj = (in.readObject());
        nombreObjeto = (User) (obj);        /* [Paso 6] */                  //*Proceder a llenar el objeto con su info respectiva, usando el "in.readObject", pero como lo queretornaes tipo "Object" (Objeto), lo transformamos al tipo indicado (Tons ya instanciamos el Objeto) */
        in.close();     fileIn.close();             /* [Paso 7] */      //* Cerrar todo */

        System.out.println("El Nombre De-Serializado es: "+nombreObjeto.username);
        System.out.println("Con la Contraseña de: " +nombreObjeto.password);
        System.out.print("Sirvio?, Yey!, tons ");
        nombreObjeto.sayHello();

        //! En Si el Codigo es ese, pero como que da errores con las carpetas y eso, aqui sale que hay un Error de Casting Porque no se reconoce
        //! La clase, ninguna de ellas para la "app" que lee, tonsnpi, esta en el TryFiles_same_Folder carpeta, ahi agarra, es el mismo codigo, npi, java y sus cosas


/* 
 * 	   // Notas Importantes     1.- Hijos de Clases que implemneten el Serializable, tambien lo van a implementar
 *	   //					    2.- Partes Estaticas, no sonserializables (Despues de todo Pertenecenala clase, no aun objeto Especifico)
 *	   //					    3.- Partes declaradas como "transient" no son serializables,son ignoradas
 *	   //					    4.- La definicion de la clase (el archivo .class ) ensi no seguarda, se debe de castear el tipo de objeto (No se guarda que tipo era Originalmente en si)
 *	   //					    5.- serialVersionUID es una version unica de ID
 */
    }
}
