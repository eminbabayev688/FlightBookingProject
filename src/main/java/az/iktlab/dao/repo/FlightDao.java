package az.iktlab.dao.repo;

import az.iktlab.dao.JdbcConnection;
import az.iktlab.dao.PgSql;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.util.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

public class FlightDao {

    JdbcConnection jdbcConnection = new PgSql();

    public List<FlightEntity> showSearchingFlight(String destinationFrom, String destinationTo, Date sqlDate,int numberOfPeople
    ) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(String.valueOf(SqlQuery.showSearchingFlight(destinationFrom,destinationTo,sqlDate,numberOfPeople)));


            return FlightMapper.mapFromRsToEntity(rs);

    }
    public List<FlightEntity> showAllFlights() throws SQLException{
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rsOne = stmt.executeQuery(SqlQuery.getAllFlights());
        return FlightMapper.mapFromRsToEntity(rsOne);
    }
}
