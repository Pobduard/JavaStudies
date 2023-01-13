package Bro_Serialization.Bro_Serializer;

import java.io.Serializable;

public class User implements Serializable{
    String username;
    String password;

    public void sayHello(){
        System.out.println("Hello " + username);
    }
}
