package Bro_Generics.Generic_Classes;

//! Pa hacerla generica, luego del nombre de la clase, es que ponemos el < >
public class MyGenericClass <Thing>{

    Thing x;

    MyGenericClass(Thing y){
        this.x = y; //* Constructor con la clase Generica */
    }
    
    //* Obtener le objeto que se encuentre ahi */
    public Thing getValue(){
        return x;
    }
}
