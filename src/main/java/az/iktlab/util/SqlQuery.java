package az.iktlab.util;

import java.sql.Date;

public class SqlQuery {

    public static String createFlightTables(){
        return  "CREATE TABLE fb_sc.flights(\n" +
                "    flightId serial PRIMARY KEY,\n" +
                "    destinationFrom varchar(150) NOT NULL ,\n" +
                "    destinationTo varchar(150) NOT NULL ,\n" +
                "    date date NOT NULL,\n" +
                "    seats int NOT NULL,\n" +
                "    fullSeats int\n" +
                ")";
    }

    public static String showSearchingFlight(String destinationFrom, String destinationTo, Date sqlDate, int numberOfPeople){
        return String.format(
                "select * from fb_sc.flights " +
                        "where destinationfrom='%s' " +
                        "and destinationto='%s' and" +
                        "  date='%s' and emptyseats>%s",
                destinationFrom,destinationTo,sqlDate,numberOfPeople
        );
    }
}
