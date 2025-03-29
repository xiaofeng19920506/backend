package com.ucomputersa.monolithic.service.impl;

import com.ucomputersa.monolithic.config.HibernateService;
import com.ucomputersa.monolithic.domain.model.Product;
import com.ucomputersa.monolithic.repository.ProductRepository;
import com.ucomputersa.monolithic.service.ProductService;
import com.ucomputersa.monolithic.utils.TimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private HibernateService hibernateService;
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        hibernateService.synchronizeSession(() -> {
            LocalDateTime now = TimeUtil.getCurrentLocalDateTime();
            product.setCreateAt(now);
            product.setUpdatedAt(now);
            productRepository.save(product);
        });
    }
}
