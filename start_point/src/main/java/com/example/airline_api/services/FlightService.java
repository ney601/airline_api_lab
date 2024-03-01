package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.NewFlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight addNewFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight addPassengerToFlight(NewFlightDTO newflightDTO, Long id) {
        Flight updatedFlight = flightRepository.findById(id).get();
        updatedFlight.setPassengers(new ArrayList<>());
        updatedFlight.setDestination(newflightDTO.getDestination());
        updatedFlight.setCapacity(newflightDTO.getCapacity());
        updatedFlight.setDepartureDate(newflightDTO.getDepartureDate());
        updatedFlight.setDepartureTime(newflightDTO.getDepartureTime());

        for (Long passengerId : newflightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            updatedFlight.addPassenger(passenger);
        }
        return flightRepository.save(updatedFlight);
    }

    public void cancelFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findAllFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }
}
