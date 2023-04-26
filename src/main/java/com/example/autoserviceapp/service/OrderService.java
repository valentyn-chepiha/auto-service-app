package com.example.autoserviceapp.service;

import java.math.BigDecimal;

public interface OrderService<E, T> extends OperationService<E, T> {
    E addDetail(T id, T idDetail);

    E updateStatus(T id, String statusName);

    BigDecimal calculateOrder(T id);
}
