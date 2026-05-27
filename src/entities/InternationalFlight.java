package entities;

public class InternationalFlight extends Flight {

    private String destinationCountry;
    private boolean requiresVisa;
    private double internationalFee;

    public InternationalFlight(String code, String origin, String destination,
                               String date, String departureTime,
                               String arrivalTime, int totalSeats,
                               double basePrice, String status,
                               String destinationCountry, boolean requiresVisa,
                               double internationalFee) {

        super(code, origin, destination, date,
                departureTime, arrivalTime,
                totalSeats, basePrice, status);

        this.destinationCountry = destinationCountry;
        this.requiresVisa = requiresVisa;
        this.internationalFee = internationalFee;
    }

    public double calculateFinalPrice(){

        return basePrice + internationalFee;

    }

    @Override
    public String toString() {
        return "InternationalFlight{" +
                "destinationCountry='" + destinationCountry + '\'' +
                ", requiresVisa=" + requiresVisa +
                ", internationalFee=" + internationalFee +
                '}';
    }
}


