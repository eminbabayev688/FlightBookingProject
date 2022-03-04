package az.iktlab.dao;

import java.sql.*;

public class PgSql implements JdbcConnection{

    private static final String url = "jdbc:postgresql://localhost:5432/group_j4";
    private static final String user = "postgres";
    private static final String pass = "00000000";

    @Override
    public Statement getStatement() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,pass);
        return con.createStatement();
    }
}
