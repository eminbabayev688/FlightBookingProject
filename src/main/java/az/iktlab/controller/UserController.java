package az.iktlab.controller;

import az.iktlab.service.UserService;
import az.iktlab.util.Validator;

import java.util.Scanner;

public class UserController {
    private final Scanner sc = new Scanner(System.in);
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public String login(){
        System.out.print("Fill in the fields to showing your flights:\n");

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        String password = Validator.doHashPassword(pass);

        return service.login(username,password);
    }
}
