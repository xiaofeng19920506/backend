package com.ucomputersa.monolithic.controller;

import com.ucomputersa.monolithic.domain.R;
import com.ucomputersa.monolithic.domain.model.Product;
import com.ucomputersa.monolithic.domain.model.Reservation;
import com.ucomputersa.monolithic.service.ProductService;
import com.ucomputersa.monolithic.utils.AuthenticationUtil;
import com.ucomputersa.monolithic.utils.TimeUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("")
    public ResponseEntity<R> createProduct(@RequestBody Product product) {
        productService.createProduct(product);

        return ResponseEntity.ok(R.ok());
    }
}
