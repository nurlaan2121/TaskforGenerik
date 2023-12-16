package controller.sevice;

import controller.User;

import java.util.LinkedList;

abstract class Proverki extends User {

    static boolean priverka(String name) {
        if (name.length() > 2) {
            return true;
        }
        return false;
    }
    static boolean email(String email, LinkedList<User> users){
        if (!users.isEmpty()){
            for (User emaill:
                    users) {
                if (!emaill.getEmail().equalsIgnoreCase(email)&&email.endsWith("@gmail.com")&&email.length()>10){
                    return true;
                }
            }
        }else{
            if (email.endsWith("@gmail.com")&&email.length()>10){
                return true;
            }
        }
        return false;
    }
}
