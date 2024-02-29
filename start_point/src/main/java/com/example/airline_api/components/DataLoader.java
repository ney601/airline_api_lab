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

        Passenger colin = new Passenger("Colin", "Colin@Colin.com");
        passengerRepository.save(colin);

        Passenger zsolt = new Passenger("Zsolt", "Zsolt@Zsolt.com");
        passengerRepository.save(zsolt);

        Passenger anna = new Passenger("Anna", "Anna@Anna.com");
        passengerRepository.save(zsolt);

        Passenger paneer = new Passenger("Paneer", "Paneer@doggyemails.com");
        passengerRepository.save(paneer);

        Flight fabFlight = new Flight("Miami", 2, "Tomorrow", "12:10");
        fabFlight.addPassenger(zsolt);
        fabFlight.addPassenger(paneer);
        flightRepository.save(fabFlight);

        Flight speedyFlight = new Flight("Bali", 5, "05/04/24", "13:10");
        speedyFlight.addPassenger(colin);
        speedyFlight.addPassenger(anna);
        flightRepository.save(fabFlight);

    }
}
