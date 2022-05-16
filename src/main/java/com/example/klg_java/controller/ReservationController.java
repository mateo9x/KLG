package com.example.klg_java.controller;

import com.example.klg_java.entity.Reservation;
import com.example.klg_java.service.ReservationService;
import com.example.klg_java.serviceImpl.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    private final static Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    ResponseEntity<Reservation> createReservation(@RequestBody @Validated Reservation reservation) {
        logger.debug("Rest request to create Reservation");
        Reservation createdReservation = reservationService.saveReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Reservation> updateReservation(@RequestBody @Validated Reservation reservation) {
        logger.debug("Rest request to update Reservation");
        Reservation updateReservation = reservationService.saveReservation(reservation);
        return new ResponseEntity<>(updateReservation, HttpStatus.OK);
    }

    @GetMapping("/tenant/{name}")
    ResponseEntity<List<Reservation>> findAllReservationsByTenantName(@PathVariable String name) {
        logger.debug("Rest request to get Reservations by Tenant name: ", name);
        List<Reservation> reservations = reservationService.getReservationsByTenantName(name);
        return new ResponseEntity<>(reservations, HttpStatus.FOUND);
    }

    @GetMapping("/rent-object/{id}")
    ResponseEntity<List<Reservation>> findAllReservationsForRentObject(@PathVariable Long id) {
        logger.debug("Rest request to get Reservations by RentObject id: ", id);
        List<Reservation> reservations = reservationService.getReservationsForRentObject(id);
        return new ResponseEntity<>(reservations, HttpStatus.FOUND);
    }

}
