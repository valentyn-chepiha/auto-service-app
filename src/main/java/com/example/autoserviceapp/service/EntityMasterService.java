package com.example.autoserviceapp.service;

import java.math.BigDecimal;

public interface EntityMasterService<E, T> extends EntityService<E, T> {
    BigDecimal calculateSalary(T id);
}
