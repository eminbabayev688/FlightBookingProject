package az.iktlab;

import az.iktlab.util.Validator;

import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/flights";
         final String user = "postgres";
        final String pass = "root1234";

        Connection con = DriverManager.getConnection(url,user,pass);
        Statement stmt = con.createStatement();

        String username="emin_babayev";
        String pass1 = "emin1234";
        String password = Validator.doHashPassword(pass1);


        String query=String.format("select count(username) from fb_sc.users where\n" +
                "username='%s' and password ='%s'", username,password);


//        ResultSet rs = DatabaseService.statementDataBase().executeQuery(query);
//        while(rs.next())
//            count=rs.getInt(1);
        ResultSet rs = stmt.executeQuery(query);
        int count = 0;
        while(rs.next())
            count=rs.getInt(1);

        System.out.println("count="+count);
    }
}
