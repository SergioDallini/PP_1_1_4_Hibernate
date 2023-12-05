package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
//    UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
//    Util util = new Util();
//    Connection connection = util.getConnection();
UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
//        daoJDBC.createUsersTable();
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
//        daoJDBC.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        daoJDBC.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        daoJDBC.removeUserById(id);
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return daoJDBC.getAllUsers();
        return userDaoHibernate.getAllUsers();
    }


    public void cleanUsersTable() {
//        daoJDBC.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}