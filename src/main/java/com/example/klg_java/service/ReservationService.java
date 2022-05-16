package com.example.klg_java.service;

import com.example.klg_java.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation saveReservation(Reservation reservation);

    List<Reservation> getReservationsByTenantName(String name);

    List<Reservation> getReservationsForRentObject(Long id);
}
