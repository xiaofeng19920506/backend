package com.ucomputersa.monolithic.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Supplier;

@AllArgsConstructor
@Configuration
public class HibernateService {


    private final PlatformTransactionManager transactionManager;

    public <T> T synchronizeSession(Supplier<T> action) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        return transactionTemplate.execute(status -> action.get());
    }

    public void synchronizeSession(Runnable action) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            action.run();
            return null;
        });
    }

}