package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();
        UserServiceImpl userDao = new UserServiceImpl();

        userDao.dropUsersTable();
        userDao.createUsersTable();
        System.out.println();
        userDao.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println(userDao.getAllUsers().get(0).getName());
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println(userDao.getAllUsers().get(1).getName());
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println(userDao.getAllUsers().get(2).getName());
        userDao.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println(userDao.getAllUsers().get(3).getName());

        userDao.removeUserById(1);
        System.out.println( userDao.getAllUsers().toString());

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
