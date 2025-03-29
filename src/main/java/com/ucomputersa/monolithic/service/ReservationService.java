package com.ucomputersa.monolithic.service;

import com.ucomputersa.monolithic.domain.model.Reservation;
import com.ucomputersa.monolithic.domain.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {


    void createReservation(Reservation reservation, String userId);

    List<ReservationDTO> getReservationByUser(String userId);
}
