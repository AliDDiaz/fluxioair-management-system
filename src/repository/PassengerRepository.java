package repository;

import entities.Passenger;

import java.util.ArrayList;

public class PassengerRepository {

    private ArrayList<Passenger> passengerList;

    public PassengerRepository() {

        passengerList = new ArrayList<>();
    }

    public void savePassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public ArrayList<Passenger> getAllPassengers(){
        return passengerList;
    }

    public Passenger findPassengerById(String id){

        for(Passenger passenger : passengerList){

            if(passenger.getId().equals(id)){
                return passenger;
            }
        }

        return null;
    }

    public Passenger findPassengerByPassport(String passportNumber){

        for(Passenger passenger : passengerList){

            if (passenger.getPassportNumber().equals(passportNumber)){
                return passenger;
            }
        }

        return null;
    }

    public int getTotalPassengers(){
        return passengerList.size();
    }
}
