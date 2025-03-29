package com.ucomputersa.monolithic.repository;

import com.ucomputersa.monolithic.domain.model.Product;
import com.ucomputersa.monolithic.domain.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}
