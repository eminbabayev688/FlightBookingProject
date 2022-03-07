package az.iktlab.dao.repo;

import az.iktlab.dao.JdbcConnection;
import az.iktlab.dao.PgSql;
import az.iktlab.mapper.UserMapper;
import az.iktlab.util.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

    JdbcConnection jdbcConnection = new PgSql();

    public int login(String username,String password) throws SQLException {
        Statement stmt = jdbcConnection.getStatement();
        ResultSet rs =stmt.executeQuery(SqlQuery.checkLogin(username,password));
        return UserMapper.mapFromRsToCount(rs);
    }
}
