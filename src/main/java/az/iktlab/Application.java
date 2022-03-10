package az.iktlab;

import az.iktlab.controller.BookingController;
import az.iktlab.controller.FlightController;
import az.iktlab.controller.UserController;
import az.iktlab.dao.repo.BookingDao;
import az.iktlab.dao.repo.FlightDao;
import az.iktlab.dao.repo.UserDao;
import az.iktlab.model.Flight;
import az.iktlab.service.BookingService;
import az.iktlab.service.FlightService;
import az.iktlab.service.UserService;
import az.iktlab.util.CommandLineHelper;
import az.iktlab.util.ConsoleColors;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    public static void runApplication(String strUsername) throws SQLException {
        final Scanner sc = new Scanner(System.in);
        final String username = strUsername;
        System.out.printf(ConsoleColors.RESET + "\"%s\" welcome to the application menu:\n\n",
                username);

        FlightDao flightDao = new FlightDao();
        FlightService flightService = new FlightService(flightDao);
        FlightController flightController = new FlightController(flightService);

        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingDao);
        BookingController bookingController = new BookingController(bookingService);


        while (true) {

            CommandLineHelper.showAppMenuBar();

            System.out.print(ConsoleColors.RESET + "Select command:");

            String command = sc.nextLine();

            switch (command) {
                case "1":
                    flightController.getAllNext24Flights().forEach(System.out::println);
                    System.out.println();
                    break;
                case "2":
                    System.out.print("\nInformation about the flight whose ID is entered:\n");
                    long flightId = flightController.checkFlightIdInDatabase();
                    if (flightId > 0) {
                        System.out.println(ConsoleColors.GREEN +
                                "Result corresponding to the entered id:");
                        System.out.println(ConsoleColors.RESET +
                                flightController.showInfoFlight(flightId) + "\n");
                    } else {
                        System.out.println(ConsoleColors.RED +
                                "No flight found matching the ID entered.\n");
                    }
                    break;
                case "3":
                    System.out.println("\nSearch and Booking flights menu:");
                    CommandLineHelper.showSearchAndBookingMenuBar();
                    System.out.print(ConsoleColors.RESET + "Select command:");
                    String commandSB = sc.nextLine();
                    switch (commandSB) {
                        case "1":
                            List<Flight> checkList = flightController.searchFlight();
                            if (checkList.isEmpty() == true) {
                                break;
                            } else {
                                checkList.forEach(System.out::println);
                                System.out.println();
                            }
                            break;
                        case "2":
                            flightController.emptySeatsDecrease(bookingController.bookingFlight(username));
                            break;
                    }
                    break;
                case "4":
                    flightController.emptySeatsIncrease(bookingController.cancelBooking());
                    break;
                case "5":
                    System.out.print(ConsoleColors.RESET +
                            "A list of all flights booked by the user:\n");
                    int countUserFlight = bookingController.checkMyBookings(username);
                    if (countUserFlight > 0) {
                        System.out.print(ConsoleColors.GREEN);
                        bookingController.showMyBookings(username)
                                .forEach(System.out::println);
                        System.out.print("\n\n");
                    } else {
                        System.out.println(ConsoleColors.RED +
                                "There are no flights you have booked\n");
                    }
                    break;
                case "6":
                    return;
            }
        }
    }
}
