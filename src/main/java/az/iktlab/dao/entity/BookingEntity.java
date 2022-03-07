package az.iktlab.dao.entity;

import java.util.Objects;

public class BookingEntity {
    private long bookingId;
    private long flightId;
    private String username;
    private String passengerName;
    private String getPassengerSurname;

    public BookingEntity() {
    }

    public BookingEntity(long bookingId, long flightId, String username,
                         String passengerName, String getPassengerSurname) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.username = username;
        this.passengerName = passengerName;
        this.getPassengerSurname = getPassengerSurname;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getGetPassengerSurname() {
        return getPassengerSurname;
    }

    public void setGetPassengerSurname(String getPassengerSurname) {
        this.getPassengerSurname = getPassengerSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return bookingId == that.bookingId && flightId == that.flightId && Objects.equals(username, that.username) && Objects.equals(passengerName, that.passengerName) && Objects.equals(getPassengerSurname, that.getPassengerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flightId, username, passengerName, getPassengerSurname);
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "bookingId=" + bookingId +
                ", flightId=" + flightId +
                ", username='" + username + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", getPassengerSurname='" + getPassengerSurname + '\'' +
                '}';
    }
}
