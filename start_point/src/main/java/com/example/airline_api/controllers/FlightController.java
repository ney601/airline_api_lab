package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.NewFlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity<>(flightService.getFlightById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        return new ResponseEntity<>(flightService.addNewFlight(flight), HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody NewFlightDTO newFlightDTO, @PathVariable Long id){
        return new ResponseEntity<>(flightService.addPassengerToFlight(newFlightDTO, id), HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
