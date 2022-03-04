package az.iktlab.controller;

import az.iktlab.model.Flight;
import az.iktlab.service.FlightService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FlightController {
    private final Scanner sc = new Scanner(System.in);

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    public List<Flight> searchFlight() throws SQLException {
        System.out.print("Fill in the fields to search for flights:\n");

        System.out.print("Enter Destination From: ");
        String destinationFrom = sc.nextLine();

        System.out.print("Enter Destination TO: ");
        String destinationTo = sc.nextLine();

        System.out.print("Enter date:\n");
        System.out.print("\"Date example: 12-25-2103 (dd-MM-yyyy)\":");
        String date = sc.nextLine();
        Date sqlDate = Date.valueOf(date);

        System.out.print("Enter the number of people:\n");
        int numberOfPeople = sc.nextInt();

        return service.searchFlight(destinationFrom,destinationTo,sqlDate,numberOfPeople);

    }
}
