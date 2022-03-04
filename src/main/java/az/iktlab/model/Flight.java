package az.iktlab.model;

import java.sql.Date;
import java.util.Objects;

public class Flight {
    private String destinationFrom;
    private String destinationTO;
    private Date date;
    private int seats;
    private int EmptySeats;

    public Flight() {
    }

    public Flight(String destinationFrom, String destinationTO, Date date, int seats) {
        this.destinationFrom = destinationFrom;
        this.destinationTO = destinationTO;
        this.date = date;
        this.seats = seats;
    }

    public Flight(String destinationFrom, String destinationTO,
                  Date date, int seats, int emptySeats) {
        this.destinationFrom = destinationFrom;
        this.destinationTO = destinationTO;
        this.date = date;
        this.seats = seats;
        EmptySeats = emptySeats;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public String getDestinationTO() {
        return destinationTO;
    }

    public void setDestinationTO(String destinationTO) {
        this.destinationTO = destinationTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getEmptySeats() {
        return EmptySeats;
    }

    public void setEmptySeats(int emptySeats) {
        EmptySeats = emptySeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return seats == flight.seats && EmptySeats == flight.EmptySeats && Objects.equals(destinationFrom, flight.destinationFrom) && Objects.equals(destinationTO, flight.destinationTO) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationFrom, destinationTO, date, seats, EmptySeats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "destinationFrom='" + destinationFrom + '\'' +
                ", destinationTO='" + destinationTO + '\'' +
                ", date=" + date +
                ", seats=" + seats +
                ", EmptySeats=" + EmptySeats +
                '}';
    }
}