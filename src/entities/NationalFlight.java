package entities;

public class NationalFlight extends Flight {

    private double estimatedDuration;
    private boolean includesMeal;

    public NationalFlight(String code, String origin, String destination,
                          String date, String departureTime,
                          String arrivalTime, int totalSeats,
                          double basePrice, String status,
                          double estimatedDuration, boolean includesMeal) {

        super(code, origin, destination, date, departureTime, arrivalTime, totalSeats, basePrice, status);
        this.estimatedDuration = estimatedDuration;
        this.includesMeal = includesMeal;
    }

    public double calculateFinalPrice(){
        return basePrice;
    }

    @Override
    public String toString() {
        return "NationalFlight{" +
                "estimatedDuration=" + estimatedDuration +
                ", includesMeal=" + includesMeal +
                '}';
    }
}