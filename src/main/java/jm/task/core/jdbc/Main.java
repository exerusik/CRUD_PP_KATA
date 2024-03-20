package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserServiceImpl();

        service.dropUsersTable();
        service.createUsersTable();

        System.out.println();
        service.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println(service.getAllUsers().get(0).getName());
        service.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println(service.getAllUsers().get(1).getName());
        service.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println(service.getAllUsers().get(2).getName());
        service.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println(service.getAllUsers().get(3).getName());

        service.removeUserById(1);
        service.getAllUsers().forEach(System.out::println);

        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
