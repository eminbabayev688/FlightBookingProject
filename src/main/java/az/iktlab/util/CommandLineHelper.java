package az.iktlab.util;

public class CommandLineHelper {
    public static void showAppMenuBar(){
        System.out.println("Commands:\n"+
                "1.OnlineBoard - Shows information about all flights in the next 24 hours.\n" +
                "2.ShowFlightInfo - Information about the flight whose ID is entered.\n" +
                "3.SearchAndBooking - Search and book a flight.\n" +
                "4.CancelBooking - Cancellation of reservations made by the user.\n" +
                "5.MyFlights - A list of all bookings in which the user is a passenger.\n" +
                "6.Exit - Shuts down the application.\n");
    }

    public static void showLoginMenuBar(){
        System.out.println("Commands:\n"+
                "1.Login - for log in if you have a user account.\n" +
                "2.Registration - for register to create a new account.\n" +
                "3.Exit - Shuts down the application.\n");
    }
}
