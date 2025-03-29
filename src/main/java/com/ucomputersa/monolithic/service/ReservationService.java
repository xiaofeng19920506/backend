package com.ucomputersa.monolithic.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.ucomputersa.monolithic.domain.Reservation;
import com.ucomputersa.monolithic.domain.User;
import com.ucomputersa.monolithic.domain.dto.ReservationDTO;
import com.ucomputersa.monolithic.domain.model.JwtModel;

import java.util.List;

public interface ReservationService {


    void createReservation(Reservation reservation, String userId);

    List<ReservationDTO> getReservationByUser(String userId);
}
