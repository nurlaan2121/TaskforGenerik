package controller;

import controller.sevice.Dao.DataBase;
import controller.sevice.UserImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<User> users = new LinkedList<>();
        DataBase dataBase = new DataBase(users);
        UserImpl user = new UserImpl();
        LOOPNAIN:
        while (true) {
            System.out.println("""
                    Choose command 
                    1.Add user
                    2.Get all users
                    3.Update user
                    4.Delete user
                    0.Exit
                    """);
            try {
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1 -> {
                        System.out.println(user.createUSer(dataBase.getUsers()));
                    }
                    case 2 -> {
                        user.read(dataBase.getUsers());
                    }
                    case 3 -> {
                        System.out.println(user.update(dataBase.getUsers()));
                    }
                    case 4 -> {
                        System.out.println(user.delete(dataBase.getUsers()));
                    }
                    case 0->{
                        break LOOPNAIN;
                    }

                }
            }catch (InputMismatchException exception){
                System.out.println("Writee number! ");
            }
        }
    }
}

