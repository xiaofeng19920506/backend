package com.ucomputersa.monolithic.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ucomputersa.monolithic.constant.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {


    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "reservation_id", unique = true, nullable = false)
    @Id
    private String reservationId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_technician_id")
    @JsonBackReference
    private User assignedTechnician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @Column(name = "reservation_title", nullable = false)
    private String reservationTitle;

    @Column(name = "reservation_description", nullable = false)
    private String reservationDescription;

    @Column(name = "reservation_time", nullable = false)
    private LocalDateTime reservationTime;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @Column(name = "reservation_price", nullable = false)
    private BigDecimal reservationPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus reservationStatuses = ReservationStatus.PENDING;

}
