package az.iktlab.service;

import az.iktlab.dao.entity.BookingEntity;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.repo.BookingDao;
import az.iktlab.mapper.BookingMapper;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.model.Booking;
import az.iktlab.model.Flight;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingMXBean;

public class BookingService {

    private final BookingDao dao;

    public BookingService(BookingDao dao) {
        this.dao = dao;
    }

    public int checkMyBookings(String username){
        int count = 0;
        try {
            count = dao.checkMyBookings(username);
        } catch (SQLException e) {
            System.out.println("Error occurred while count bookings");
            System.out.printf("Error message: %s", e.getMessage());
        }
        return count;
    }
    public List<Booking> showMyBookings(String username) {
        List<BookingEntity> bookings = new ArrayList<>();

        try {
            bookings = dao.showMyBookings(username);
        } catch (SQLException e) {
            System.out.println("Error occurred while show bookings");
            System.out.printf("Error message: %s", e.getMessage());
        }

        return BookingMapper.mapToDto(bookings);
    }

    public Long bookingFlight(
            Long flightId,String username,String passengerName,String passengerSurname){

        try {
            dao.bookingFlight(flightId,username,passengerName,passengerSurname);
            System.out.println("Booking successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while show bookings");
            System.out.printf("Error message: %s", e.getMessage());
        }

        return flightId;
    }
}
