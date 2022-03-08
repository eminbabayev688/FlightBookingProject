package az.iktlab.dao.repo;

import az.iktlab.dao.JdbcConnection;
import az.iktlab.dao.PgSql;
import az.iktlab.dao.entity.BookingEntity;
import az.iktlab.dao.entity.FlightEntity;
import az.iktlab.mapper.BookingMapper;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.mapper.UserMapper;
import az.iktlab.model.Booking;
import az.iktlab.util.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookingDao {
    JdbcConnection jdbcConnection = new PgSql();

    public int checkMyBookings(String username) throws SQLException{
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(SqlQuery.checkMyBookings(username));
        return BookingMapper.mapFromRsToCount(rs);
    }
    public List<BookingEntity> showMyBookings(String username) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs = stmt.executeQuery(SqlQuery.getMyBookings(username));
        return BookingMapper.mapFromRsToEntity(rs);
    }

    public void bookingFlight(
            Long flightId,String username,String passengerName,String passengerSurname)
            throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        stmt.execute(SqlQuery.bookingFlight(flightId,username,passengerName,passengerSurname));
    }
}
