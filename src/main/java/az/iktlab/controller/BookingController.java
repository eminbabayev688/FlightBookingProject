package az.iktlab.controller;

import az.iktlab.model.Booking;
import az.iktlab.service.BookingService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    private final Scanner sc = new Scanner(System.in);

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    public int checkMyBookings(String username){
        return service.checkMyBookings(username);
    }
    public List<Booking> showMyBookings(String username) throws SQLException {

        System.out.println("all flights you have booked:");
        return service.showMyBookings(username);
    }

    public Long bookingFlight(){
        System.out.print("Fill in the fields to booking for flights:\n");
        System.out.print("Enter flight id:");
        Long flightId = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter passenger name: ");
        String passengerName = sc.nextLine();

        System.out.print("Enter passenger surname: ");
        String passengerSurname = sc.nextLine();


        return service.bookingFlight(flightId,username,passengerName,passengerSurname);
    }
}
