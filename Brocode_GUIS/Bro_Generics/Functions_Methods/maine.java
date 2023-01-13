package Bro_Generics.Functions_Methods;

/* 
 * 10:15:00     /* Basicamenteesta permite que los tipo de datos tambien sean parametros al momento de 
 *                 Definirfunciones, pero mejor, nos permite hacer funciones de tipo "Generico" osea que nosoltros le pasemos el tipo de dato
 *                 Su Beneficio es que nos permite que la misma funcion, sirva para varios tipos de data (Si esa data puede hacer lo que esa funcion intenta claro esta)
 */
public class maine {
    public static void main(String[] args) {
        //! Ejemplo para este tipo de utilidad:
    
        Integer[] intArray = {1, 2, 3, 4, 5,};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"B", "Y", "E"};

        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(stringArray);
        //! Asi con la misma funcion, nos sirve para todos los tipos, sean Basicos, o clases nuevas propias

        System.out.println("-------");
        System.out.println(getFirst(intArray));
        System.out.println(getFirst(doubleArray));
        System.out.println(getFirst(charArray));
        System.out.println(getFirst(stringArray));
    }






    //! Para crear la funcion de tipo Generico, se hace de esa forma:
    //! Poniendo el "Tipo Generico" entre < >, con cualquier nombre (Comunmente "T")
    //! Y Ese mismo tipo es lo que se mete dentro de los parametros, en este caso como esperamos Arrays, pues T[]
    public static <Thing> void displayArray(Thing[] array){
        for(Thing x: array){
            System.out.println(x+" ");
        }
    }

    public static <Thing> Thing getFirst(Thing[] array){
        //! La cuestion de esta funcion, es para poder etornar algo, pero como no sabemmos que tipo retornamos, usmos el tipo generico, en este caso "Thing"
        //! "Thing" que significa "cosa", al bro le ayuda recordar mas facilmente asi
        return array[0];
    }
}


