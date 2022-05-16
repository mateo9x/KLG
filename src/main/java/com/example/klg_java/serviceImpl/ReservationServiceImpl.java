package com.example.klg_java.serviceImpl;

import com.example.klg_java.entity.RentObject;
import com.example.klg_java.entity.Reservation;
import com.example.klg_java.entity.Tenant;
import com.example.klg_java.repository.RentObjectRepository;
import com.example.klg_java.repository.ReservationRepository;
import com.example.klg_java.repository.TenantRepository;
import com.example.klg_java.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final static Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private ReservationRepository reservationRepository;
    private RentObjectRepository rentObjectRepository;
    private TenantRepository tenantRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RentObjectRepository rentObjectRepository, TenantRepository tenantRepository) {
        this.reservationRepository = reservationRepository;
        this.rentObjectRepository = rentObjectRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        logger.debug("Request to save new Reservation");
        doesReservationForSelectedObjectAndDatesAlreadyExists(reservation);
        doesRentObjectExists(reservation.getRentObject().getId());
        doesTenantExists(reservation.getTenant().getId());
        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }

    @Override
    public List<Reservation> getReservationsByTenantName(String name) {
        logger.debug("Request to get Reservations by Tenant name: ", name);
        return reservationRepository.findAllByTenantName(name);
    }

    @Override
    public List<Reservation> getReservationsForRentObject(Long id) {
        logger.debug("Request to get Reservations by Rent object ID: ", id);
        return reservationRepository.findAllByRentObjectId(id);
    }

    private Boolean doesReservationForSelectedObjectAndDatesAlreadyExists(Reservation reservation) {
        List<Reservation> reservationsExisting = reservationRepository.findByFromDateGreaterThanEqualAndToDateLessThanEqualAndRentObjectId(reservation.getFromDate(), reservation.getToDate(), reservation.getRentObject().getId());
        if (!reservationsExisting.isEmpty()) {
            throw new RuntimeException("Reservation for this object in this time already exists !");
        } else {
            return false;
        }
    }

    private Boolean doesRentObjectExists(Long rentObjectId) {
        Optional<RentObject> rentObjectOptional = rentObjectRepository.findById(rentObjectId);
        if (rentObjectOptional.isPresent()) {
            return true;
        } else {
            throw new RuntimeException("Rent object does not exists !");
        }
    }

    private Boolean doesTenantExists(Long tenantId) {
        Optional<Tenant> tenantOptional = tenantRepository.findById(tenantId);
        if (tenantOptional.isPresent()) {
            return true;
        } else {
            throw new RuntimeException("Tenant does not exists !");
        }
    }
}
