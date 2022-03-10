package az.iktlab.util;

import az.iktlab.dao.entity.BookingEntity;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.entity.UserEntity;
import az.iktlab.model.Gender;
import az.iktlab.model.User;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public static String showSearchingFlight(FlightEntity flightEntity) {
        return String.format(
                "select * from fb_sc.flights " +
                        "where destinationfrom='%s' " +
                        "and destinationto='%s' and" +
                        "  date='%s' and emptyseats>%s and time = '%s'",
                flightEntity.getDestinationFrom(),
                flightEntity.getDestinationTO(),
                flightEntity.getDate(),
                flightEntity.getEmptySeats(),
                flightEntity.getTime()
        );
    }

    public static String getAllNext24Flights(LocalDate date, LocalDate nextDate) {
        return String.format("Select * from fb_sc.flights " +
                "where date between '%s' and '%s'", date, nextDate);
    }

    public static String getMyBookings(String username) {
        return String.format("select * from fb_sc.bookings\n" +
                        "where username = '%s'",
                username);
    }

    public static String showInfoFlight(Long flightId) {
        return String.format(
                "select * from fb_sc.flights " +
                        "where flightid=%s", flightId);
    }

    public static String bookingFlight(BookingEntity bookingEntity) {
        return String.format(
                "insert into fb_sc.bookings " +
                        "(flightid, username, passengername, passengersurname,gender)\n" +
                        "values (%s,'%s','%s','%s','%s')",
                bookingEntity.getFlightId(),
                bookingEntity.getUsername(),
                bookingEntity.getPassengerName(),
                bookingEntity.getPassengerSurname(),
                bookingEntity.getGender());
    }

    public static String emptySeatsDecrease(long flightId) {
        return String.format("update fb_sc.flights set emptyseats = emptyseats-1\n" +
                "where flightid = %s", flightId);
    }

    public static String emptySeatsIncrease(long flightId) {
        return String.format("update fb_sc.flights set emptyseats = emptyseats+1\n" +
                "where flightid = %s", flightId);
    }

    public static String checkLogin(String username, String password) {
        return String.format("select count(username) from fb_sc.users where\n" +
                "username='%s' and password ='%s'", username, password);
    }

    public static String checkUsername(String username) {
        return String.format("select count(username) from fb_sc.users where\n" +
                "username='%s'", username);
    }

    public static String saveUser(UserEntity userEntity) {
        return String.format("INSERT INTO fb_sc.users (username, password,firstname, lastname, age, gender) " +
                        "VALUES ('%s', '%s', '%s','%s', %s, '%s')",
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAge(),
                userEntity.getGender());
    }

    public static String checkMyBookings(String username) {
        return String.format("select count(username) from fb_sc.bookings where\n" +
                "username='%s'", username);
    }


    public static String checkPassengerBookingTable(BookingEntity bookingEntity) {
        return String.format("select count(bookingid) from fb_sc.bookings where\n" +
                        "flightid='%s' and username= '%s'\n" +
                        " and passengername = '%s' and passengersurname = '%s'\n" +
                        "and gender = '%s'",
                bookingEntity.getFlightId(),
                bookingEntity.getUsername(),
                bookingEntity.getPassengerName(),
                bookingEntity.getPassengerSurname(),
                bookingEntity.getGender());
    }

    public static String checkBookingIdInDatabase(long bookingId) {
        return String.format("select count(bookingid) from fb_sc.bookings where\n" +
                "bookingid='%s'", bookingId);
    }

    public static String getFlightIdCancelBooking(long bookingId) {
        return String.format("select * from fb_sc.bookings where\n" +
                "bookingid='%s'", bookingId);
    }

    public static String cancelBooking(long bookingId) {
        return String.format("DELETE FROM fb_sc.bookings WHERE bookingid=%s;", bookingId);
    }

    public static String checkFlightId(long flightId) {
        return String.format("select count(flightid) from fb_sc.flights where\n" +
                "flightid='%s'", flightId);
    }

    public static String getCountSearchResult(FlightEntity flightEntity) {
        return String.format("select count(flightid) from fb_sc.flights where\n" +
                        " destinationfrom = '%s'\n" +
                        " and destinationto = '%s'\n" +
                        " and date = '%s'\n" +
                        " and emptyseats > '%s'\n" +
                        " and time = '%s'\n",
                flightEntity.getDestinationFrom(),
                flightEntity.getDestinationTO(),
                flightEntity.getDate(),
                flightEntity.getEmptySeats(),
                flightEntity.getTime());
    }

}
