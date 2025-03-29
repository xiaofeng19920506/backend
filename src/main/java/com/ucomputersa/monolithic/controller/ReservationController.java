package com.ucomputersa.monolithic.controller;

import com.ucomputersa.monolithic.constant.UserConstant;
import com.ucomputersa.monolithic.domain.R;
import com.ucomputersa.monolithic.domain.Reservation;
import com.ucomputersa.monolithic.domain.User;
import com.ucomputersa.monolithic.domain.dto.ReservationDTO;
import com.ucomputersa.monolithic.service.ReservationService;
import com.ucomputersa.monolithic.service.UserService;
import com.ucomputersa.monolithic.utils.AuthenticationUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    ReservationService reservationService;

    @Autowired
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
