package az.iktlab;

import az.iktlab.controller.FlightController;
import az.iktlab.dao.repo.FlightDao;
import az.iktlab.service.FlightService;
import az.iktlab.util.CommandLineHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

    public static void runApp() throws SQLException {
        final Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the application:\n\n");
        FlightDao flightDao = new FlightDao();
        FlightService flightService = new FlightService(flightDao);
        FlightController flightController = new FlightController(flightService);
        while(true){

            CommandLineHelper.showMenuBar();

            System.out.print("Select command: ");

            String command = sc.nextLine();
            System.out.println();

            switch (command){
                case "SearchBooking":
                    System.out.println("Serach and Booking flights:\n\n");
                    System.out.println(flightController.searchFlight());
                    break;
                case "exit":
                    System.out.println("Goodbye, see you again");
                    return;
            }
        }
    }
}
