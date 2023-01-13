package Bro_Serialization.Bro_DeSerializer;

import java.io.Serializable;

public class User implements Serializable{
    String username;
    String password;

    public void sayHello(){
        System.out.println("Hello " + username);
    }
}
