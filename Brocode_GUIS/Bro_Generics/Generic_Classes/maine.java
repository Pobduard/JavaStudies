package Bro_Generics.Generic_Classes;
import java.util.ArrayList;
import java.util.HashMap;

public class maine {
    public static void main(String[] args) {
        //! Si lo creamis asi ya agarra y esta bien
        MyGenericClass myInt = new MyGenericClass(1);   //* Pasamos el 1 pa activar el constructor y que se guarde */
        //! Pero para el IDE, deberiamos tambien de pasaar el tipo de data que estamos mandando, pa reemplazar el <Thing> pues
        MyGenericClass<Double> myDouble = new MyGenericClass<Double>(2.2);  //* Tecnicamente asi se deberia usar, pero ya cada quien supongo, para demostrar el ejemplo no lo hare mas */
        MyGenericClass<Character> myChar = new MyGenericClass<>('H');     //* Tambien se le puede pasarsolo del lado de la definicion, y en el otro solo <>  */
        MyGenericClass myString = new MyGenericClass("You're Awesome :D "); //* Recordar tambien, que como es una clase, si vamos a instanciar objetos, el tipo del coso debe ser de objetos, tons no primitivo, Integer, no int*/


        System.out.println(myInt.getValue());   // *Estamos usando la clase Generica para crera objetos,recordar eso
        System.out.println(myDouble.getValue());
        System.out.println(myChar.getValue());
        System.out.println(myString.getValue());

        //! Si recordamos/nos Fijamos, esd la misma Sintaxis de los Array List, porque esos son de tipo Genericos
        ArrayList<String> stringArr = new ArrayList<>();

        //! A las que son multiples como esta, le podemos pasar del mismo tipo de dato (2 Integer por ejemplo)
        MyGenericClass2<Integer, Integer> My2ndInteger = new MyGenericClass2<>(1, 9);
        //! O Objetos de varios tipos
        MyGenericClass2<String, Character> My2ndString = new MyGenericClass2<>("Hello", 'K');

        System.out.println(My2ndInteger.getValue());
        System.out.println(My2ndString.getValue());

        //! Los Tipos Genericos asi dobles, son parte d elos HashMaps tambien
        HashMap<Integer, String> users = new HashMap<>();   //* Por poner un Ejemplo, que los Hash son una collecion de pares de valores importantes  */
        //* Aqui podria ser la ID, y el Username */

        //! Aqui es para los Tipos Genericos "Anclados", basicamente lo podemos Anclar a un tipo de Data/Objetos, y cualquier Hijo de este (Subclase) podra entrar tambiencomo parametro
        MyBoundedGenericClass<Integer, Double>  bounded = new MyBoundedGenericClass<>(1, 1.1);
        System.out.println(bounded.getValue());
    
    }
}
// Quede en 10:37:00 Serialization