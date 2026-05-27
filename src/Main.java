import entities.InternationalFlight;
import entities.NationalFlight;
import entities.Passenger;
import entities.Reservation;
import exceptions.*;
import service.FlightService;
import service.PassengerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PassengerService passengerService = new PassengerService();

        FlightService flightService = new FlightService();

        ReservationService reservationService = new ReservationService(passengerService, flightService);

        int option;

        do {

            System.out.println("\n======== FLUXIOAIR ========");
            System.out.println("1. Registrar pasajero.");
            System.out.println("2. Crear vuelo nacional.");
            System.out.println("3. Crear vuelo internacional.");
            System.out.println("4. Realizar reserva.");
            System.out.println("5. Cancelar reserva.");
            System.out.println("6. Buscar reserva por código.");
            System.out.println("7. Ver reservas por pasajero.");
            System.out.println("8. Total pasajeros.");
            System.out.println("0. Salir.");
            System.out.print("Seleccione una opción: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option){

                case 1:

                    try {

                        System.out.println("\n=== REGISTRO PASAJERO ===");

                        System.out.println("Cédula: ");
                        String id = sc.nextLine();

                        System.out.println("Nombres: ");
                        String firstName = sc.nextLine();

                        System.out.println("Apellidos: ");
                        String lastName = sc.nextLine();

                        System.out.println("Edad: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Email: ");
                        String email = sc.nextLine();

                        System.out.println("Teléfono: ");
                        String phone = sc.nextLine();

                        System.out.println("Pasaporte: ");
                        String passport = sc.nextLine();

                        System.out.println("Nacionalidad: ");
                        String nationality = sc.nextLine();

                        Passenger passenger = new Passenger(id, firstName, lastName, age,
                                email, phone, passport, nationality);

                        passengerService.registerPassenger(passenger);

                        System.out.println("Pasajero registrado correctamente.");
                    } catch(DuplicatePassengerException | InvalidEmailException e){

                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    try {

                        System.out.println("\n=== CREAR VUELO NACIONAL ===");

                        System.out.println("Código: ");
                        String code = sc.nextLine();

                        System.out.println("Origen: ");
                        String origin = sc.nextLine();

                        System.out.println("Destino: ");
                        String destination = sc.nextLine();

                        System.out.println("Fecha: ");
                        String date = sc.nextLine();

                        System.out.println("Hora salida: ");
                        String departure = sc.nextLine();

                        System.out.println("Hora llegada: ");
                        String arrival = sc.nextLine();

                        System.out.println("Capacidad: ");
                        int capacity = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Precio base: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Duración estimada: ");
                        double duration = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("¿Incluye alimentación? true/false: ");
                        boolean meal = sc.nextBoolean();
                        sc.nextLine();

                        NationalFlight nationalFlight = new NationalFlight(code, origin, destination, date,
                                departure, arrival, capacity, price, "Programado", duration, meal);

                        flightService.registerFlight(nationalFlight);

                        System.out.println("Vuelo nacional registrado correctamente.");
                    } catch (Exception e){

                        System.out.println(e.getMessage());

                    }

                    break;

                case 3:

                    try {

                        System.out.println("\n=== CREAR VUELO INTERNACIONAL ===");

                        System.out.println("Código: ");
                        String code = sc.nextLine();

                        System.out.println("Origen: ");
                        String origin = sc.nextLine();

                        System.out.println("Destino: ");
                        String destination = sc.nextLine();

                        System.out.println("Fecha: ");
                        String date = sc.nextLine();

                        System.out.println("Hora salida: ");
                        String departure = sc.nextLine();

                        System.out.println("Hora llegada: ");
                        String arrival = sc.nextLine();

                        System.out.println("Capacidad: ");
                        int capacity = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Precio base: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("País destino: ");
                        String country = sc.nextLine();

                        System.out.println("¿Requiere visa? true/false: ");
                        boolean visa = sc.nextBoolean();
                        sc.nextLine();

                        System.out.println("Cargo internacional: ");

                        double fee = sc.nextDouble();
                        sc.nextLine();

                        InternationalFlight internationalFlight = new InternationalFlight(code, origin, destination,
                                date, departure, arrival, capacity, price, "Programado", country, visa, fee);

                        flightService.registerFlight(internationalFlight);

                        System.out.println("Vuelo internacional registrado correctamente.");

                    }catch (Exception e){

                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    try {

                        System.out.println("\n=== REALIZAR RESERVAR ===");

                        System.out.println("Código reserva: ");
                        String reservationCode = sc.nextLine();

                        System.out.println("Cédula pasajero: ");
                        String passengerId = sc.nextLine();

                        System.out.println("Código vuelo: ");
                        String flightCode = sc.nextLine();

                        System.out.println("Cantidad asientos: ");
                        int seats = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Fecha reservada: ");
                        String reservationDate = sc.nextLine();

                        reservationService.createReservation(reservationCode, passengerId,
                                flightCode, seats, reservationDate);

                        System.out.println("reserva realizada correctamente.");

                    }catch (FlightNotFoundException | NoSeatsAvailableException | InvalidReservationException e){

                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    try {

                        System.out.println("\n=== CANCELAR RESERVA ===");

                        System.out.println("Código reserva: ");
                        String reservationCode = sc.nextLine();

                        reservationService.cancelReservation(reservationCode);

                        System.out.println("Reserva cancaleda correctamente.");

                    }catch (ReservationNotFoundException e){

                        System.out.println(e.getMessage());
                    }

                    break;

                case 6:

                    System.out.println("\n=== BUSCAR RESERVA ===");

                    System.out.println("Código reserva: ");
                    String code = sc.nextLine();

                    Reservation reservation = reservationService.findReservationByCode(code);

                    if(reservation != null){

                        System.out.println(reservation);
                    } else {

                        System.out.println("Reserva no encontrada.");
                    }

                    break;

                case 7:

                    System.out.println("\n=== RESERVAS POR PASAJERO ===");

                    System.out.println("Cédula pasajero: ");
                    String passengerId = sc.nextLine();

                    ArrayList<Reservation> reservations = reservationService.getReservationsByPassenger(passengerId);

                    if(reservations.isEmpty()){

                        System.out.println("El pasajero no tiene reservas.");

                    } else {

                        for(Reservation r : reservations){

                            System.out.println(r);
                        }
                    }

                    break;

                case 8:

                    System.out.println("\nTotal pasajeros registrados: " + passengerService.getTotalPassengers());

                    break;

                case 0:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(option != 0);
    }
}