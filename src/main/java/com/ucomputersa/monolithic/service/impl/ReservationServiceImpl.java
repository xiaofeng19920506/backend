package com.ucomputersa.monolithic.service.impl;

import com.ucomputersa.monolithic.config.HibernateService;
import com.ucomputersa.monolithic.constant.ReservationStatus;
import com.ucomputersa.monolithic.domain.Reservation;
import com.ucomputersa.monolithic.domain.User;
import com.ucomputersa.monolithic.domain.dto.AssignedTechnicianDTO;
import com.ucomputersa.monolithic.domain.dto.ReservationDTO;
import com.ucomputersa.monolithic.repository.ReservationRepository;
import com.ucomputersa.monolithic.service.ReservationService;
import com.ucomputersa.monolithic.service.UserService;
import com.ucomputersa.monolithic.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    HibernateService hibernateService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserService userService;

    @Override
    public void createReservation(Reservation reservation, String userId) {
        hibernateService.synchronizeSession(() -> {
            LocalDateTime now = TimeUtil.getCurrentLocalDateTime();

            if (now.isAfter(reservation.getReservationTime())) {
                throw new IllegalArgumentException("Please enter a validate Reservation Time");
            }
            User savedUser = userService.findUserByIdWithValidation(userId);

            reservation.setUser(savedUser);
            reservation.setCreateDate(now);
            reservation.setUpdatedAt(now);
            reservation.setReservationStatuses(ReservationStatus.PENDING);

            reservationRepository.save(reservation);

        });
    }

    @Override
    public List<ReservationDTO> getReservationByUser(String userId) {
        return hibernateService.synchronizeSession(() -> {
            User savedUser = userService.findUserByIdWithValidation(userId);
            return savedUser.getOwnedReservations().stream().map(reservation -> {
                ReservationDTO reservationDTO = new ReservationDTO();
                BeanUtils.copyProperties(reservation, reservationDTO);
                if (reservation.getAssignedTechnician() != null) {
                    AssignedTechnicianDTO assignedTechnicianDTO = new AssignedTechnicianDTO();
                    BeanUtils.copyProperties(reservation.getAssignedTechnician(), assignedTechnicianDTO);
                    reservationDTO.setAssignedTechnician(assignedTechnicianDTO);
                }
                return reservationDTO;
            }).toList();
        });
    }
}