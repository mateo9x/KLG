package com.example.klg_java.repository;

import com.example.klg_java.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByFromDateGreaterThanEqualAndToDateLessThanEqualAndRentObjectId(Date dateFrom, Date dateTo, Long rentObjectId);

    List<Reservation> findAllByTenantName(String name);

    List<Reservation> findAllByRentObjectId(Long rentObjectId);
}
