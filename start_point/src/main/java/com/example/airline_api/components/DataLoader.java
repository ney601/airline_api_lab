package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Fab Flight
        Flight fabFlight = new Flight("Miami", 2, "Tomorrow", "12:10");
        flightRepository.save(fabFlight);

        Passenger zsolt = new Passenger("Zsolt", "zsolt@zsolt.com");
        zsolt.addFlight(fabFlight);
        passengerRepository.save(zsolt);

        Passenger paneer = new Passenger("Paneer", "paneer@paneer.com");
        paneer.addFlight(fabFlight);
        passengerRepository.save(paneer);

        Flight speedyFlight = new Flight("Bali", 5, "05/04/24", "13:10");
        flightRepository.save(speedyFlight);

        Passenger anna = new Passenger("Anna", "anna@anna.com");
        anna.addFlight(speedyFlight);
        passengerRepository.save(anna);

        Passenger colin = new Passenger("Colin", "colin@colin.com");
        colin.addFlight(speedyFlight);
        passengerRepository.save(colin);


    }
}
