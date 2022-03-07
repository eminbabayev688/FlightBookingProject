package az.iktlab.util;

public class CommandLineHelper {
    public static void showMenuBar(){
        System.out.println("Commands:\n"+
                "1.OnlineBoard - Shows information about all flights in the next 24 hours.\n" +
                "2.ShowFlightInfo - Information about the flight whose ID is entered.\n" +
                "3.SearchAndBooking - Search and book a flight.\n" +
                "4.CancelBooking - Cancellation of reservations made by the user\n" +
                "5.MyFlights - A list of all bookings in which the user is a passenger.\n" +
                "6.Exit - Shuts down the application.\n");
    }
}
