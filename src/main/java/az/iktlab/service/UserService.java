package az.iktlab.service;

import az.iktlab.dao.entity.UserEntity;
import az.iktlab.dao.repo.UserDao;
import az.iktlab.mapper.UserMapper;
import az.iktlab.model.User;
import az.iktlab.util.Validator;

import java.sql.SQLException;

public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public String loginUser(String username, String pass) {
        if (username.equals("") || pass.equals("")) {
            System.out.println("Username and password field must be filled");
            return null;
        }
        String password = Validator.doHashPassword(pass);

        int count = 0;
        try {
            count = dao.loginUser(username, password);
        } catch (SQLException e) {
            System.out.println("An error occurred while logging in");
            System.out.println("Error message: " + e.getMessage());
        }
        if (count > 0) {
            System.out.println("You have successfully logged in");
            return username;
        } else {
            System.out.println("username or password is incorrect");
            return null;
        }
    }

    public int checkUsernameInDatabase(String username) {
        int count = 0;
        try {
            count = dao.checkUsernameInDatabase(username);
        } catch (SQLException e) {
            System.out.println("An error occurred while registration");
            System.out.println("Error message: " + e.getMessage());
        }
        return count;
    }

    public void registrationUser(User user) {
        //check that the username is set correctly
        if (Validator.checkUsername(user.getUsername()) == false) return;
        if (Validator.checkUsernamePattern(user.getUsername()) == false) return;
        if (Validator.checkUsernameInDatabase(user.getUsername()) == false) return;

        //check that the username is set correctly
        if (Validator.checkPassword(user.getPassword()) == false) return;
        if (Validator.checkPasswordPattern(user.getPassword()) == false) return;

        //convert password to md5 format
        user.setPassword(Validator.doHashPassword(user.getPassword()));

        if (Validator.checkFirstAndLastName(user.getFirstName()) == false) return;
        if (Validator.checkFirstAndLastName(user.getLastName()) == false) return;
        if (Validator.checkAge(user.getAge()) == false) return;


        UserEntity entity = UserMapper.mapToEntity(user);

        try {
            boolean flag = dao.registrationUser(entity);
            if (flag) System.out.println("You have successfully registered");
            else System.out.println("registration failed");
        } catch (SQLException e) {
            System.out.println("An error occurred while registration");
            System.out.println("Error message: " + e.getMessage());
        }

    }

}
