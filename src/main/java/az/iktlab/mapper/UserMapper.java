package az.iktlab.mapper;

import az.iktlab.dao.entity.FlightEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static int mapFromRsToCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
                count=rs.getInt(1);
        }
        return count;
    }
}
