package com.ucomputersa.monolithic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", unique = true, nullable = false)
    @Id
    private String productId;

    @Column(name = "product_title", unique = true, nullable = false)
    private String productTitle;

    private List<String> productImage;

    private String productDescription;
    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    @Column(name = "stock_number", nullable = false)
    private BigInteger stockNumber;

}
