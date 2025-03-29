package com.ucomputersa.monolithic.service;

import com.ucomputersa.monolithic.domain.dto.ReservationDTO;
import com.ucomputersa.monolithic.domain.model.Product;
import com.ucomputersa.monolithic.domain.model.Reservation;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);
}
