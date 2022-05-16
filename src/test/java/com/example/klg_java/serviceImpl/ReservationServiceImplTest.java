package com.example.klg_java.serviceImpl;

import com.example.klg_java.entity.RentObject;
import com.example.klg_java.entity.Reservation;
import com.example.klg_java.entity.Tenant;
import com.example.klg_java.repository.RentObjectRepository;
import com.example.klg_java.repository.ReservationRepository;
import com.example.klg_java.repository.TenantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {

    private final static Long TENANT_ID = 10L;
    private final static Long RENT_OBJECT_ID = 10L;
    private final static String TENANT_NAME = "TENANT";
    private final static String RENT_OBJECT_NAME = "RENT_OBJECT";
    @Mock
    ReservationRepository reservationRepository;
    @Mock
    RentObjectRepository rentObjectRepository;
    @Mock
    TenantRepository tenantRepository;
    @InjectMocks
    ReservationServiceImpl reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveReservation_shouldThrowRuntimeExceptionWhenTenantDoesNotExists() {
        Mockito.when(reservationRepository.findByFromDateGreaterThanEqualAndToDateLessThanEqualAndRentObjectId(any(Date.class), any(Date.class), anyLong())).thenReturn(new ArrayList<Reservation>());
        Mockito.when(rentObjectRepository.findById(anyLong())).thenReturn(Optional.ofNullable(RentObject.builder().id(1L).name("Pierwszy-wynajmujacy").build()));
        Tenant tenant = Tenant.builder().id(TENANT_ID).name(TENANT_NAME).build();
        RentObject rentObject = RentObject.builder().id(RENT_OBJECT_ID).name(RENT_OBJECT_NAME).build();
        Reservation reservation = Reservation.builder().fromDate(new Date()).toDate(new Date()).rentObject(rentObject).tenant(tenant).build();
        assertThatThrownBy(() -> reservationService.saveReservation(reservation))
                .isInstanceOf(RuntimeException.class).hasMessageContaining("Tenant does not exists !");
    }

}