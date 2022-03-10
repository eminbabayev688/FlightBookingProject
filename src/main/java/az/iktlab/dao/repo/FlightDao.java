package az.iktlab.dao.repo;

import az.iktlab.dao.JdbcConnection;
import az.iktlab.dao.PgSql;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.mapper.UserMapper;
import az.iktlab.model.Flight;
import az.iktlab.util.SqlQuery;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class FlightDao {

    JdbcConnection jdbcConnection = new PgSql();

    public List<FlightEntity> showSearchingFlight(FlightEntity flightEntity)
            throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(
                String.valueOf(SqlQuery.showSearchingFlight(flightEntity)));
        return FlightMapper.mapFromRsToEntity(rs);

    }

    public List<FlightEntity> getAllNext24Flights(LocalDate date, LocalDate nextDate)
            throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(SqlQuery.getAllNext24Flights(date, nextDate));
        return FlightMapper.mapFromRsToEntity(rs);
    }

    public List<FlightEntity> showInfoFlight(Long flightId) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(String.valueOf(SqlQuery.showInfoFlight(flightId)));
        return FlightMapper.mapFromRsToEntity(rs);

    }

    public void emptySeatsDecrease(long flightId) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        stmt.execute(SqlQuery.emptySeatsDecrease(flightId));
    }

    public void emptySeatsIncrease(long flightId) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        stmt.execute(SqlQuery.emptySeatsIncrease(flightId));
    }

    public int checkFlightIdInDatabase(long flightId) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(SqlQuery.checkFlightId(flightId));
        return FlightMapper.mapFromRsToCount(rs);
    }

    public int getCountSearchResult(FlightEntity flightEntity) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(SqlQuery.getCountSearchResult(flightEntity));

        return FlightMapper.mapFromRsToCount(rs);
    }
}
