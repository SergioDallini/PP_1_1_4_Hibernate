package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Robinson", "Crusoe", (byte) 22);
//        userService.saveUser("Agent", "Smith", (byte) 35);
//        userService.saveUser("Bruce", "Lee", (byte) 33);
//        userService.saveUser("Chuck", "Norris", (byte) 55);
//        userService.saveUser("Ivan", "Petrov", (byte) 10);
//        userService.dropUsersTable();
//        userService.cleanUsersTable();
//        userService.removeUserById(1);
        userService.getAllUsers();

    }
}