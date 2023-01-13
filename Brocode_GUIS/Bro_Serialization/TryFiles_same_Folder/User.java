package Bro_Serialization.TryFiles_same_Folder;

import java.io.Serializable;

public class User implements Serializable{
    String username;
    String password;

    public void sayHello(){
        System.out.println("Hello " + username);
    }
}
