package az.iktlab;

import az.iktlab.dao.repo.UserDao;
import az.iktlab.service.UserService;
import az.iktlab.controller.UserController;
import az.iktlab.util.CommandLineHelper;
import az.iktlab.util.ConsoleColors;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginPage {
    public static void runLoginPage() throws SQLException {
        final Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.RESET +
                "Welcome to the application:\n");

        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        while (true) {
            CommandLineHelper.showLoginMenuBar();
            System.out.print(ConsoleColors.RESET + "Select command:");
            String command = sc.nextLine();

            switch (command) {
                case "1":
                    String username = null;
                    username = userController.loginUser();
                    if (username != null) {
                        Application.runApplication(username);
                    }
                    break;
                case "2":
                    userController.registrationUser();
                    break;
                case "3":
                    System.out.println(ConsoleColors.RESET + "Goodbye, see you again");
                    return;
            }
        }
    }
}
