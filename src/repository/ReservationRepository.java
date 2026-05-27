package repository;

import entities.Reservation;

import java.util.ArrayList;

public class ReservationRepository {

    private ArrayList<Reservation> reservationList;

    public ReservationRepository(){

        reservationList = new ArrayList<>();
    }

    public void saveReservation(Reservation reservation){

        reservationList.add(reservation);
    }

    public ArrayList<Reservation> getAllReservations(){
        return reservationList;
    }

    public Reservation findReservationByCode(String code){

        for(Reservation reservation : reservationList){

            if(reservation.getReservationCode().equals(code)){
                return reservation;
            }
        }

        return null;
    }
}
