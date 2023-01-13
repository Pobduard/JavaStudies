package Bro_Generics.Generic_Classes;

    //! Estas clases tambien pueden llevar + de 1 parametro, usualmente luego de la <T> tiendena usar <V>
    //! Cuando se hace, al momento de crear la clase, se tiene que pasar 2 tipos de datos, y evidentememte cuando lo instanciamos, poner ambos tipos
    //* Y Si, es poner los tipos de datos dentrodel mismo < , >, no en < > diferentes seguidos */
    public class MyGenericClass2 <Thing, Thing2>{   //* A Bro en vez de usar V, le gusta usar Thing2 y asi, nuevamente para no olvidarse que es un tipo Generico */
        
        Thing x;
        Thing2 y;

    MyGenericClass2(Thing x, Thing2 y){
        this.x = x;
        this.y = y;
    }
    
    public Thing2 getValue(){
        return y;
    }
}
