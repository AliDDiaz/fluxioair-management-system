package entities;

public class Reservation {

    private String reservationCode;
    private Passenger passenger;
    private Flight flight;
    private int reservedSeats;
    private String reservationDate;
    private double totalPrice;
    private String status;

    public Reservation(String reservationCode, Passenger passenger,
                       Flight flight, int reservedSeats,
                       String reservationDate, double totalPrice, String status) {

        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.flight = flight;
        this.reservedSeats = reservedSeats;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationCode='" + reservationCode + '\'' +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", reservedSeats=" + reservedSeats +
                ", reservationDate='" + reservationDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
