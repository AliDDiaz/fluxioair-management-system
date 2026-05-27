package repository;

import entities.Flight;

import java.util.ArrayList;

public class FlightRepository {

    private ArrayList<Flight> flightList;

    public FlightRepository(){
        flightList = new ArrayList<>();
    }

    public void saveFlight(Flight flight){
        flightList.add(flight);
    }

    public ArrayList<Flight> getAllFlights(){
        return flightList;
    }

    public Flight findFlightByCode(String code){

        for(Flight flight : flightList){

            if(flight.getCode().equals(code)){
                return flight;
            }
        }

        return null;
    }
}
