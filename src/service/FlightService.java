package service;

import entities.Flight;
import repository.FlightRepository;

public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(){
        flightRepository = new FlightRepository();
    }

    public void registerFlight(Flight flight) throws Exception{

        if(flightRepository.findFlightByCode(flight.getCode()) != null){

            throw new Exception("Ya existe un vuelo con ese código");
        }

        if(flight.getAvailableSeats() <= 0){

            throw new Exception("La capacidad del vuelo debe ser mayor a cero");
        }

        if(flight.getBasePrice() <= 0){

            throw new Exception("El precio del vuelo debe ser mayor a cero.");
        }

        flightRepository.saveFlight(flight);
    }

    public Flight findFlightByCode(String code){
        return flightRepository.findFlightByCode(code);
    }
}
