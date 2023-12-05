package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    Connection connection = util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS user (ID BIGINT auto_increment primary key ,NAME VARCHAR(45) not null,LASTNAME VARCHAR(45) not null, AGE INT(3) not null);";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Table was successfully created!");
        } catch (SQLException e) {
            System.out.println("Table was NOT created!");
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS user";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Table was successfully deleted!");
        } catch (SQLException e) {
            System.out.println("Table was NOT deleted!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO user (NAME, LASTNAME, AGE) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User "+name+" was SUCCESSFULLY added into the table!");
        } catch (SQLException e) {
            System.out.println("User was NOT added into the table!");
        }
    }

    public void removeUserById(long id) {
        final String query = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User was SUCCESSFULLY deleted from table!");
        } catch (SQLException e) {
            System.out.println("User with id = "+id+" was NOT deleted from table!");
        }
    }
    public void cleanUsersTable() {
        String query = "DELETE FROM user";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("All users were SUCCESSFULLY deleted from table!");
        } catch (SQLException e) {
            System.out.println("All users were NOT deleted from table!");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Table doesn't exist!");
        }
        System.out.println("List of all users -> " + users);
        return users;
    }

}
