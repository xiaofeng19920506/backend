package com.ucomputersa.monolithic.repository;

import com.ucomputersa.monolithic.domain.Reservation;
import com.ucomputersa.monolithic.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {

}
