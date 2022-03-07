package az.iktlab.mapper;

import az.iktlab.dao.entity.BookingEntity;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.model.Booking;
import az.iktlab.model.Flight;

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
}
