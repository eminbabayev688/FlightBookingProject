package az.iktlab.service;

import az.iktlab.dao.repo.UserDao;

import java.sql.SQLException;

public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public String login(String username, String password) {
    int count = 0;
        try {
            count = dao.login(username, password);
        } catch (SQLException e) {
            System.out.println("An error occurred while logging in");
            System.out.println("Error message: " + e.getMessage());
        }
        if(count>0){
            System.out.println("You have successfully logged in");
            return username;
        }else{
            System.out.println("username or password is incorrect");
            return null;
        }
    }

}
