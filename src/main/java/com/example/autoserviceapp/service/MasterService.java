package com.example.autoserviceapp.service;

import java.math.BigDecimal;

public interface MasterService<E, T> extends BaseService<E, T> {
    BigDecimal calculateSalary(T id);
}
