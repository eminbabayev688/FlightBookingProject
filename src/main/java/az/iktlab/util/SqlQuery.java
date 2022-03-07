package az.iktlab.util;

import java.sql.Date;

public class SqlQuery {

    public static String createFlightTables() {
        return "CREATE TABLE fb_sc.flights(\n" +
                "    flightId serial PRIMARY KEY,\n" +
                "    destinationFrom varchar(150) NOT NULL ,\n" +
                "    destinationTo varchar(150) NOT NULL ,\n" +
                "    date date NOT NULL,\n" +
                "    seats int NOT NULL,\n" +
                "    fullSeats int\n" +
                ")";
    }

    public static String showSearchingFlight(String destinationFrom, String destinationTo, Date sqlDate, int numberOfPeople) {
        return String.format(
                "select * from fb_sc.flights " +
                        "where destinationfrom='%s' " +
                        "and destinationto='%s' and" +
                        "  date='%s' and emptyseats>%s",
                destinationFrom, destinationTo, sqlDate, numberOfPeople
        );
    }

    public static String getAllFlights() {
        return "Select * from fb_sc.flights";
    }

    public static String getMyBookings(String username) {
        return String.format("select * from fb_sc.bookings\n" +
                "where username = '%s'",
                username);
    }

    public static String showInfoFlight(Long flightId) {
        return String.format(
                "select * from fb_sc.flights " +
                        "where flightid=%s",flightId);
    }

    public static String bookingFlight(Long flightId,String username,
                                       String passengerName,String passengerSurname) {
        return String.format(
                "insert into fb_sc.bookings " +
                        "(flightid, username, passengername, passengersurname)\n" +
                        "values (%s,'%s','%s','%s')",
                flightId,username,passengerName,passengerSurname);
    }

    public static String emptySeatsDecrease(long flightId){
        return String.format("update fb_sc.flights set emptyseats = emptyseats-1\n" +
                "where flightid = %s",flightId);
    }

    public static String checkLogin(String username,String password){
        return String.format("select count(username) from fb_sc.users where\n" +
                "username='%s' and password ='%s'", username,password);
    }
}
