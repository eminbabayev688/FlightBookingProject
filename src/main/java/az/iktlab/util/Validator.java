package az.iktlab.util;

import az.iktlab.controller.UserController;
import az.iktlab.dao.repo.UserDao;
import az.iktlab.model.Gender;
import az.iktlab.service.UserService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Validator {



    public static String doHashPassword(String password) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] resultArr = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte c : resultArr) {
                sb.append(String.format("%02x", c));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Gender validateGender(String gender) {
        try {
            if (gender.equals("male"))
                return Gender.Male;
            else if (gender.equals("female"))
                return Gender.Female;
            else throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Enter valid gender name. (example: male/female)");
        }
        return null;
    }

    public static boolean checkUsername(String username) {
        boolean checker = true;
        String s = Character.toString(username.charAt(0));
        if (username.length() < 8) {
            System.out.println("Username cannot be less than 8 digits\n");
            checker = false;
        } else if (Pattern.matches("[a-z]", s) == false) {
            System.out.println("Username can only start with a lowercase letter\n");
            checker = false;
        }
        return checker;
    }

    public static boolean checkUsernamePattern(String username) {
        int n = username.length();
        boolean checker = true;
        for (int j = 0; j < n; j++) {
            String s = Character.toString(username.charAt(j));
            if (Pattern.matches("[ ]", s) == true) {
                System.out.println("You cannot use spaces in the username\n");
                checker = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            String s = Character.toString(username.charAt(i));
            if (Pattern.matches("[a-z0-9_.]", s) == false) {
                System.out.println("Only lowercase letters, numbers, underscores(_) and dot(.)" +
                        " can be used in the username\n");
                checker = false;
                break;
            }
        }
        return checker;
    }

    public static boolean checkAge(int age) {
        boolean checker = true;
        if (age < 18) {
            System.out.println("Persons under the age of 18 cannot register\n");
            checker = false;
        }
        return checker;
    }

    public static boolean checkFirstAndLastName(String name) {
        String s = Character.toString(name.charAt(0));
        boolean checker = true;
        if (Pattern.matches("[a-z]", s) == true) {
            System.out.println("First name or last name can only start with a Uppercase letter\n");
            checker = false;
        } else {
            int n = name.length();
            for (int j = 0; j < n; j++) {
                String str = Character.toString(name.charAt(j));
                if (Pattern.matches("[ ]", str) == true) {
                    System.out.println("You cannot use spaces in the last name and first name\n");
                    checker = false;
                    break;
                }
            }
        }
        return checker;
    }

    public static boolean checkPassword(String password) {
        String s = Character.toString(password.charAt(0));
        boolean checker = true;
        if (password.length() < 8) {
            System.out.println("Password cannot be less than 8 digits\n");
            checker = false;
        } else if (Pattern.matches("[A-Z]", s) == false) {
            System.out.println("Password can only start with a Uppercase letter\n");
            checker = false;
        }
        return checker;
    }

    public static boolean checkPasswordPattern(String password) {
        int n = password.length();
        boolean checker = true;
        for (int j = 0; j < n; j++) {
            String s = Character.toString(password.charAt(j));
            if (Pattern.matches("[ ]", s) == true) {
                System.out.println("You cannot use spaces in the password\n");
                checker = false;
            }
        }

//        for (int i = 0; i < n; i++) {
//            String s = Character.toString(password.charAt(i));
//            if (Pattern.matches("[0-9]", s)== true) {
//                break;
//            }
//        }
        return checker;
    }

    public static boolean  checkUsernameInDatabase(String username){
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);
        boolean checker = false;
        int count = userController.checkUsernameInDatabase(username);
        if(count>0){
            System.out.println("Username '"+username+"' is used," +
                    "you cannot get this name\n");
        }else{
            checker = true;
        }
        return checker;
    }
}
