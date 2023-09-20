package jm.task.core.jdbc;

import com.mysql.jdbc.Driver;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Jeck","Sparrow", (byte) 35);
        userService.saveUser("Hector", "Barbosa", (byte) 55);
        userService.saveUser("William", "Turner ||", (byte) 27);
        userService.saveUser("Tia", "Dalma", (byte) 99);
        try {
            for (User allUser : userService.getAllUsers()) {
                System.out.println(allUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();




    }
}
