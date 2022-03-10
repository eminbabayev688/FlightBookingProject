package az.iktlab.service;

import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.dao.entity.UserEntity;
import az.iktlab.dao.repo.FlightDao;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.mapper.UserMapper;
import az.iktlab.model.Flight;
import az.iktlab.util.ConsoleColors;
import az.iktlab.util.Validator;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static az.iktlab.util.SqlQuery.showSearchingFlight;

public class FlightService {

    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    List<FlightEntity> flights = new ArrayList<>();

    public List<Flight> searchFlight(Flight flight) {

        if (Validator.getCountSearchResult(flight) == false)
            return new ArrayList<>();

        FlightEntity flightEntity = FlightMapper.mapToEntity(flight);

        try {
            flights = flightDao.showSearchingFlight(flightEntity);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED +
                    "Error occurred when searching flights.");
            System.out.printf("Error message: %s", e.getMessage() + "\n");
        }
        return FlightMapper.mapToDto(flights);
    }

    public List<Flight> getAllNext24Flights(LocalDate date, LocalDate nextDate) {
        List<FlightEntity> flights = new ArrayList<>();

        try {
            flights = flightDao.getAllNext24Flights(date, nextDate);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED +
                    "Error occurred when searching flights.");
            System.out.printf(ConsoleColors.RED + "Error message: %s", e.getMessage() + "\n");
        }

        return FlightMapper.mapToDto(flights);

    }

    public List<Flight> showInfoFlight(Long flightId) {
        List<FlightEntity> flights = new ArrayList<>();
        try {
            flights = flightDao.showInfoFlight(flightId);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED +
                    "Error occurred while showing flight info.");
            System.out.printf(ConsoleColors.RED + "Error message: %s", e.getMessage() + "\n");
        }

        return FlightMapper.mapToDto(flights);
    }

    public void emptySeatsDecrease(long flightId) {
        try {
            flightDao.emptySeatsDecrease(flightId);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "Error occurred while booking flight.");
            System.out.printf(ConsoleColors.RED + "Error message: %s", e.getMessage() + "\n");
        }
    }

    public void emptySeatsIncrease(long flightId) {
        try {
            flightDao.emptySeatsIncrease(flightId);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "Error occurred while booking flight.");
            System.out.printf(ConsoleColors.RED + "Error message: %s", e.getMessage() + "\n");
        }
    }

    public long checkFlightIdInDatabase(long flightId) {
        int count = 0;
        try {
            count = flightDao.checkFlightIdInDatabase(flightId);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED +
                    "Error occurred while checking flight id.");
            System.out.printf(ConsoleColors.RED + "Error message: %s", e.getMessage() + "\n");
        }
        if (count > 0) {
            return flightId;
        } else {
            return 0;
        }
    }

    public int getCountSearchResult(Flight flight) {
        if (Validator.checkCityFirstLetter(flight.getDestinationFrom()) == false) return -1;
        if (Validator.checkCityFirstLetter(flight.getDestinationTO()) == false) return -1;

        FlightEntity flightEntity = FlightMapper.mapToEntity(flight);

        int count = 0;
        try {
            count = flightDao.getCountSearchResult(flightEntity);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "An error occurred while get search count flight.");
            System.out.println(ConsoleColors.RED + "Error message: %s" + e.getMessage() + "\n");
        }
        return count;
    }
}
