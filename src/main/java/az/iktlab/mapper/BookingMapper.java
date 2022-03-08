package az.iktlab.mapper;

import az.iktlab.dao.entity.BookingEntity;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.entity.UserEntity;
import az.iktlab.model.Booking;
import az.iktlab.model.Flight;
import az.iktlab.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {

    public static List<BookingEntity> mapFromRsToEntity(ResultSet rs) throws SQLException {
        List<BookingEntity> bookings = new ArrayList<>();
        while (rs.next()) {
            bookings.add(new BookingEntity(rs.getLong("bookingid"),
                    rs.getLong("flightid"),
                    rs.getString("username"),
                    rs.getString("passengername"),
                    rs.getString("passengersurname")));
        }
        return bookings;
    }

    public static List<Booking> mapToDto(List<BookingEntity> bookings) {
        return bookings.stream()
                .map(booking -> new Booking(booking.getBookingId(),booking.getFlightId(), booking.getUsername(), booking.getPassengerName(), booking.getGetPassengerSurname()))
                .collect(Collectors.toList());
    }

    public static int mapFromRsToCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count=rs.getInt(1);
        }
        return count;
    }
}
