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


        System.out.println("\"Date example: 12-25-2103 (dd-MM-yyyy)\":");
        System.out.print("Enter date:");
        String date = sc.nextLine();
        Date sqlDate = Date.valueOf(date);

        System.out.print("Enter the number of people:");
        int numberOfPeople = sc.nextInt();

        return service.searchFlight(destinationFrom, destinationTo, sqlDate, numberOfPeople);

    }

    public List<Flight> getAllFlights() throws SQLException {
        System.out.println("All data are coming...");
        return service.getAllFlights();
    }

    public List<Flight> showInfoFlight() throws SQLException {
        System.out.print("Fill in the fields to search for flights:\n");

        System.out.print("Enter fight id:");
        Long flightId = sc.nextLong();

        System.out.println("Result corresponding to the entered id:");
        return service.showInfoFlight(flightId);
    }

    public void emptySeatsDecrease(long flightId){
        service.emptySeatsDecrease(flightId);
    }
}
