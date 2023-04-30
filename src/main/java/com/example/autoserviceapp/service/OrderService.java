package com.example.autoserviceapp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface OrderService<E, T> extends BaseService<E, T> {
    E addDetail(T id, T idDetail);

    E updateStatus(T id, String statusName);

    BigDecimal calculateOrder(T id);

    List<E> getAllByIds(Set<T> ids);
}
