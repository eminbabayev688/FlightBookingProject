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

    public static void runApplication(String username) throws SQLException {
        final Scanner sc = new Scanner(System.in);
        System.out.print(username+" welcome to the application menu:\n\n");

        FlightDao flightDao = new FlightDao();
        FlightService flightService = new FlightService(flightDao);
        FlightController flightController = new FlightController(flightService);

        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingDao);
        BookingController bookingController = new BookingController(bookingService);


        while (true) {

            CommandLineHelper.showAppMenuBar();

            System.out.print("Select command: ");

            String command = sc.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Online Board");

                    flightController.getAllFlights().forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("\nInformation about the flight whose ID is entered:\n");
                    System.out.println(flightController.showInfoFlight()+"\n");
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
                    System.out.print("A list of all bookings in which the user is a passenger:\n");
                        int count = bookingController.checkMyBookings(username);
                        if (count>0){
                            bookingController.showMyBookings(username)
                                    .forEach(System.out::println);
                            System.out.print("\n\n");
                        }else{
                            System.out.print("There are no flights you have booked\n\n");
                        }

                    break;
                case "6":
                    return;
            }
        }
    }
}
