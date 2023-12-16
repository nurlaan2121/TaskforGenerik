package controller.sevice;

import controller.User;
import controller.sevice.Dao.UserInterface;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class UserImpl implements UserInterface<User> {
    @Override
    public String createUSer(LinkedList<User> users) {
        User user = new User();
        while (true) {
            System.out.println("Write first name: ");
            String name = new Scanner(System.in).nextLine();
            if (Proverki.priverka(name)) {
                user.setFirstName(name);
                break;
            }
        }
        while (true) {
            System.out.println("Write last name: ");
            String name = new Scanner(System.in).nextLine();
            if (Proverki.priverka(name)) {
                user.setLastName(name);
                break;
            }
        }
        while (true) {
            System.out.println("Write user name: ");
            String name = new Scanner(System.in).nextLine();
            if (Proverki.priverka(name)) {
                user.setUsername(name);
                break;
            }
        }
        while (true) {
            System.out.println("Write age name: ");
            try {
                int name = new Scanner(System.in).nextInt();
                if (name > 18 && name < 70) {
                    user.setAge(name);
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Write number!");
                new Scanner(System.in).reset();
            }

        }
        while (true) {
            System.out.println("Write login: ");
            String name = new Scanner(System.in).nextLine();
            if (Proverki.email(name, users)) {
                user.setEmail(name);
                break;
            }
        }
        users.add(user);
        return "Success";
    }

    @Override
    public void read(LinkedList<User> users) {
        System.out.println(users);
    }

    @Override
    public String update(LinkedList<User> users) {
        System.out.println("Write email: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(name)) {
                System.out.println("""
                        Choose command: 
                        1.First Name
                        2.Last name
                        3.User Name
                        4.Email
                        5.Age
                                              
                        """);
                try {
                    int num = new Scanner(System.in).nextInt();
                    switch (num) {
                        case 1 -> {
                            while (true) {
                                System.out.println("Write first name: ");
                                String firstNAme = new Scanner(System.in).nextLine();
                                if (Proverki.priverka(firstNAme)) {
                                    users.get(i).setFirstName(firstNAme);
                                    return "Success";

                                }
                            }
                        }
                        case 2 -> {
                            while (true) {
                                System.out.println("Write last name: ");
                                String lastNAme = new Scanner(System.in).nextLine();
                                if (Proverki.priverka(lastNAme)) {
                                    users.get(i).setLastName(lastNAme);
                                    return "Success";

                                }
                            }

                        }
                        case 3 -> {
                            while (true) {
                                System.out.println("Write user name: ");
                                String username = new Scanner(System.in).nextLine();
                                if (Proverki.priverka(username)) {
                                    users.get(i).setUsername(username);
                                    return "Success";

                                }
                            }
                        }
                        case 4 -> {
                            while (true) {
                                System.out.println("Write login: ");
                                String login = new Scanner(System.in).nextLine();
                                if (Proverki.email(login, users)) {
                                    users.get(i).setEmail(login);
                                    return "Success";

                                }
                            }
                        }
                        case 5 -> {
                            while (true) {
                                System.out.println("Write age name: ");
                                int age = new Scanner(System.in).nextInt();
                                if (age > 18 && age < 70) {
                                    users.get(i).setAge(age);
                                    return "Success";
                                }
                            }
                        }
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Write number please! ");
                }
            }
        }
        try {
            throw new NOTFOUND("JOK EKEN");
        } catch (NOTFOUND e) {
            return e.getMessage();
        }
    }

    @Override
    public String delete(LinkedList<User> users) {
        System.out.println("Write email : ");
        String email = new Scanner(System.in).nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                users.remove(i);
                return "Success";
            }
        }try {
            throw new NOTFOUND("Not fount");
        }catch (NOTFOUND e){
            return e.getMessage();
        }
    }
}
