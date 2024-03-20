package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable()  {
       try (Statement statement = connection.createStatement();) {
           String sql = "CREATE TABLE IF NOT EXISTS User (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `name` VARCHAR(45) NOT NULL,\n" +
                   "  `lastname` VARCHAR(45) NOT NULL,\n" +
                   "  `age` TINYINT ,\n" +
                   "  PRIMARY KEY (`id`));\n";

           statement.executeUpdate(sql);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }

    public void dropUsersTable(){
        try (Statement statement = connection.createStatement();) {
            String sql = "DROP TABLE IF EXISTS User;";
            statement.execute(sql);

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement();) {
            String sql = "INSERT INTO User (name, lastname, age) VALUES (\'" + name + "\', \'" + lastName + "\', " + age + ");";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement();) {
            String sql = "DELETE FROM User where id=" + id + ";";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement();) {
            String sql = "SELECT id, name, lastname, age FROM User";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement();) {
            String sql = "TRUNCATE User";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
