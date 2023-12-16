package controller.sevice.Dao;

import controller.User;

import java.util.LinkedList;

public interface UserInterface<T extends User>{
    String createUSer (LinkedList<T> users);
    void read (LinkedList<T> users);
    String update(LinkedList<T> users);
    String delete (LinkedList<T> users);
}
