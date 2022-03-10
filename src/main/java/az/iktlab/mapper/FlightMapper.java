package az.iktlab.mapper;

import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.entity.UserEntity;
import az.iktlab.model.Flight;
import az.iktlab.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {

    public static List<FlightEntity> mapFromRsToEntity(ResultSet rs) throws SQLException {
        List<FlightEntity> flights = new ArrayList<>();
        while (rs.next()) {
            flights.add(new FlightEntity(rs.getLong("flightid"),
                    rs.getString("destinationfrom"),
                    rs.getString("destinationto"),
                    rs.getDate("date"),
                    rs.getTime("time"),
                    rs.getInt("seats"),
                    rs.getInt("emptyseats")));
        }
        return flights;
    }

    public static List<Flight> mapToDto(List<FlightEntity> flights) {
        return flights.stream()
                .map(flight -> new Flight(flight.getFlightId(), flight.getDestinationFrom(), flight.getDestinationTO(), flight.getDate(), flight.getTime(), flight.getSeats(), flight.getEmptySeats()))
                .collect(Collectors.toList());
    }

    public static int mapFromRsToCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static FlightEntity mapToEntity(Flight flight) {
        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setFlightId(flight.getFlightId());
        flightEntity.setDestinationFrom(flight.getDestinationFrom());
        flightEntity.setDestinationTO(flight.getDestinationTO());
        flightEntity.setDate(flight.getDate());
        flightEntity.setSeats(flight.getSeats());
        flightEntity.setEmptySeats(flight.getEmptySeats());
        flightEntity.setTime(flight.getTime());

        return flightEntity;
    }
}
