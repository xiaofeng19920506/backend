package com.ucomputersa.monolithic.controller;

import com.ucomputersa.monolithic.domain.R;
import com.ucomputersa.monolithic.domain.model.Reservation;
import com.ucomputersa.monolithic.domain.dto.ReservationDTO;
import com.ucomputersa.monolithic.service.ReservationService;
import com.ucomputersa.monolithic.service.UserService;
import com.ucomputersa.monolithic.utils.AuthenticationUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    ReservationService reservationService;

    UserService userService;


    @PostMapping("")
    public ResponseEntity<R> createReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        String userId = AuthenticationUtil.getUserId();
        reservationService.createReservation(reservation, userId);
        return ResponseEntity.ok(R.ok());
    }

    @GetMapping("")
    public ResponseEntity<R> getUserReservation(HttpServletRequest request) {
        String userId = AuthenticationUtil.getUserId();
        List<ReservationDTO> reservationList =  reservationService.getReservationByUser(userId);
        return ResponseEntity.ok(R.ok().with("data", reservationList));
    }

}
