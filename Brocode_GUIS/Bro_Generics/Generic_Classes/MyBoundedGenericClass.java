package Bro_Generics.Generic_Classes;

/* 
 ! Lo Especial de los tipos "Anclados" es que si bien puede ser "Generico", podemos limitar el tipo de data que entre
 ! lo HAcemos poniendo "extends" luego del tipo generico en la definicion de la clase
 ! Si lo hacemos con tipos Abstractos o "Madres" pues, todo tipo que sea hijo de este, o de ese tipo, puede entrar
 ! Ej si fuerade tipo Number, todo subtipo relacionadocon estos puede entrar (Integer, Dpuble, Long, AtomicLongetc . . )
 */
public class MyBoundedGenericClass <Thing extends Number, Thing2 extends Number>{

    Thing x;
    Thing2 y;

    MyBoundedGenericClass(Thing x, Thing2 y){
        this.x = x;
        this.y = y;
    }

    public Thing2 getValue(){
        return y;
    }
}
