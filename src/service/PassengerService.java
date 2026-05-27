package service;

import entities.Passenger;
import exceptions.DuplicatePassengerException;
import exceptions.InvalidEmailException;
import repository.PassengerRepository;

public class PassengerService {

    private PassengerRepository passengerRepository;

    public PassengerService(){
        passengerRepository = new PassengerRepository();
    }

    public void registerPassenger(Passenger passenger)
        throws DuplicatePassengerException,
            InvalidEmailException{

        if(passengerRepository.findPassengerById(passenger.getId()) != null){

            throw new DuplicatePassengerException("Ya existe un pasajero con esa cédula.");

        }

        if(passengerRepository.findPassengerByPassport(passenger.getPassportNumber()) != null){

            throw new DuplicatePassengerException("Ya existe un pasajero con ese pasaporte.");
        }

        if(!passenger.getEmail().contains("@")){

            throw new InvalidEmailException("El email debe contener el símbolo @");
        }

        passengerRepository.savePassenger(passenger);
    }

    public Passenger findPassengerById(String id){
        return passengerRepository.findPassengerById(id);
    }

    public int getTotalPassengers(){
        return passengerRepository.getTotalPassengers();
    }
}
