package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();
        UserService userService = new UserServiceImpl();

        userService.dropUsersTable();
        userService.createUsersTable();
        System.out.println();
        userService.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println(userService.getAllUsers().get(0).getName());
        userService.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println(userService.getAllUsers().get(1).getName());
        userService.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println(userService.getAllUsers().get(2).getName());
        userService.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println(userService.getAllUsers().get(3).getName());

        userService.removeUserById(1);
        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
