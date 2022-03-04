package az.iktlab.mapper;

import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.model.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {

    public static List<FlightEntity> mapFromRsToEntity(ResultSet rs) throws SQLException {
        List<FlightEntity> flights = new ArrayList<>();
        while(rs.next()){
            flights.add(new FlightEntity(rs.getLong("flightid"),
                    rs.getString("destinationfrom"),
                    rs.getString("destinationto"),
                    rs.getDate("date"),
                    rs.getInt("seats"),
                    rs.getInt("emptyseats")));
        }
        return flights;
    }

    public static List<Flight> mapToDto(List<FlightEntity> flights) {
        return flights.stream()
                .map(flight -> new Flight(flight.getDestinationFrom(), flight.getDestinationTO(), flight.getDate(), flight.getSeats(), flight.getEmptySeats()))
                .collect(Collectors.toList());
    }

}
