package az.iktlab.service;

import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.repo.FlightDao;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.model.Flight;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static az.iktlab.util.SqlQuery.showSearchingFlight;

public class FlightService {

    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public List<Flight> searchFlight(String destinationFrom,String destinationTo,Date sqlDate,int numberOfPeople){

        List<FlightEntity> flights = new ArrayList<>();


        try {
            flights = flightDao.showSearchingFlight(destinationFrom,destinationTo,sqlDate,numberOfPeople);
        } catch (SQLException e) {
            System.out.println("Error occurred when searching flights");
            System.out.printf("Error message: %s", e.getMessage());
        }

        return FlightMapper.mapToDto(flights);
    }

}
