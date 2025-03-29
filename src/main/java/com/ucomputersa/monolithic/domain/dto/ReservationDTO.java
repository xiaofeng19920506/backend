package com.ucomputersa.monolithic.domain.dto;

import com.ucomputersa.monolithic.constant.ReservationStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReservationDTO {

    private String reservationId;

    private AssignedTechnicianDTO assignedTechnician;

    private String reservationTitle;

    private String reservationDescription;

    private LocalDateTime reservationTime;

    private LocalDateTime createDate;

    private LocalDateTime updatedAt;
    private BigDecimal reservationPrice;

    private ReservationStatus reservationStatuses;

}
