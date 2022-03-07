package az.iktlab;

import az.iktlab.controller.BookingController;
import az.iktlab.controller.FlightController;
import az.iktlab.controller.UserController;
import az.iktlab.dao.repo.BookingDao;
import az.iktlab.dao.repo.FlightDao;
import az.iktlab.dao.repo.UserDao;
import az.iktlab.service.BookingService;
import az.iktlab.service.FlightService;
import az.iktlab.service.UserService;
import az.iktlab.util.CommandLineHelper;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    public static void runApp() throws SQLException {
        final Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the application:\n\n");
        FlightDao flightDao = new FlightDao();
        FlightService flightService = new FlightService(flightDao);
        FlightController flightController = new FlightController(flightService);

        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingDao);
        BookingController bookingController = new BookingController(bookingService);

        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        while (true) {

            CommandLineHelper.showMenuBar();

            System.out.print("Select command: ");

            String command = sc.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Online Board");

                    flightController.getAllFlights().forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Information about the flight whose ID is entered:\n\n");
                    System.out.println(flightController.showInfoFlight());
                    break;
                case "3":
                    System.out.println("Serach and Booking flights:\n");
                    System.out.println(flightController.searchFlight());
                    System.out.println();
                    flightController.emptySeatsDecrease(bookingController.bookingFlight());
                    break;
                case "4":
                    break;
                case "5":
                    System.out.print("A list of all bookings in which the user is a passenger:\n\n");
                    String username = null;
                    username = userController.login();
                    if (username != null) {
                        bookingController.showMyBookings(username)
                                .forEach(System.out::println);
                    }

                    break;
                case "6":
                    System.out.println("Goodbye, see you again");
                    return;
            }
        }
    }
}
