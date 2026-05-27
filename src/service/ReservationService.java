package service;

import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import exceptions.FlightNotFoundException;
import exceptions.InvalidReservationException;
import exceptions.NoSeatsAvailableException;
import exceptions.ReservationNotFoundException;
import repository.ReservationRepository;

import java.util.ArrayList;

public class ReservationService {

    private ReservationRepository reservationRepository;
    private PassengerService passengerService;
    private FlightService flightService;

    public  ReservationService(PassengerService passengerService,
                               FlightService flightService){

        this.passengerService = passengerService;
        this.flightService = flightService;

        reservationRepository = new ReservationRepository();
    }

    public void createReservation(String reservationCode, String passengerId,
                                  String flightCode, int reservedSeats, String reservationDate)

        throws FlightNotFoundException, NoSeatsAvailableException, InvalidReservationException{

        Passenger passenger = passengerService.findPassengerById(passengerId);

        if(passenger == null){

            throw new InvalidReservationException("No se encontró el pasajero con esa cédula");
        }

        Flight flight = flightService.findFlightByCode(flightCode);

        if(flight == null){

            throw new FlightNotFoundException("No se encontró el vuelo");
        }

        if(!flight.getStatus().equalsIgnoreCase("Programado")){

            throw new InvalidReservationException("No se puede reservar en un vuelo no programado.");
        }

        if(reservedSeats < 1 || reservedSeats > 5){

            throw new InvalidReservationException("No se pueden reservar más de 5 asientos por reserva.");
        }

        if(flight.getAvailableSeats() < reservedSeats){

            throw new NoSeatsAvailableException("No hay asientos disponibles para este vuelo.");
        }

        double totalPrice = flight.calculateFinalPrice() * reservedSeats;

        Reservation reservation = new Reservation(reservationCode, passenger, flight, reservedSeats,
                reservationDate, totalPrice, "Confirmada");

        flight.setAvailableSeats(flight.getAvailableSeats() - reservedSeats);

        reservationRepository.saveReservation(reservation);
    }

    public void cancelReservation(String reservationCode)

        throws ReservationNotFoundException{

        Reservation reservation = reservationRepository.findReservationByCode(reservationCode);

        if(reservation == null){

            throw new ReservationNotFoundException("No se encontró la reserva con ese código.");
        }

        reservation.setStatus("Cancelada");

        Flight flight = reservation.getFlight();

        flight.setAvailableSeats(flight.getAvailableSeats() + reservation.getReservedSeats());
    }

    public Reservation findReservationByCode(String code){

        return reservationRepository.findReservationByCode(code);
    }

    public ArrayList<Reservation> getReservationsByPassenger(String passengerId){

        ArrayList<Reservation> result = new ArrayList<>();

        for (Reservation reservation : reservationRepository.getAllReservations()){

            if(reservation.getPassenger().getId().equals(passengerId)){

                result.add(reservation);
            }
        }

        return result;
    }
}
