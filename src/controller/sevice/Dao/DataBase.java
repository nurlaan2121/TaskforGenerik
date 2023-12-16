package controller.sevice.Dao;

import controller.User;

import java.util.LinkedList;

public class DataBase {
    public LinkedList<User> users;

    public DataBase(LinkedList<User> users) {
        this.users = users;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
