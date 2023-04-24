package com.example.autoserviceapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.DetailRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.EntityOrderService;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements EntityOrderService<Order, Long> {

    private OrderRepository orderRepository;
    private DetailRepository detailRepository;
    private EntityService<Owner, Long> ownerService;

    @Override
    public List<Order> getAllByIds(Set<Long> ids) {
        return orderRepository.findAllByIdIn(ids);
    }

    @Override
    public Order add(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Optional<Order> get(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order addDetail(Long id, Long idDetail) {
        Order order = orderRepository.findById(id).get();
        Detail detail = detailRepository.findById(idDetail).get();

        List<Detail> details = order.getDetails();
        details.add(detail);

        order.setDetails(details);
        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(Long id, String statusName) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(Order.StatusService.valueOf(statusName));
        if(Order.StatusService.valueOf(statusName) == Order.StatusService.DONE ||
            Order.StatusService.valueOf(statusName) == Order.StatusService.FAIL) {
            order.setDateEnd(LocalDate.now());
        }
        return orderRepository.save(order);
    }

    @Override
    public BigDecimal calculateOrder(Long id) {
        Order order = orderRepository.findById(id).get();
        BigDecimal totalDetail = order.getDetails().stream()
                .map(Detail::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalOperation = order.getOperations().stream()
                .map(Operation::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (order.getOperations().size() == 0) {
            totalOperation = BigDecimal.valueOf(500);
        }

        BigDecimal total = new BigDecimal(0);
        total = total.add(totalDetail);
        total = total.add(totalOperation);
        order.setTotal(total);

        int countOrders = ownerService.get(order.getOwner().getId()).get().getOrders().size();
        BigDecimal totalCost = new BigDecimal(0);
        totalCost = totalCost.add(totalOperation.multiply(BigDecimal.valueOf(1 - 2 * countOrders / 100)));
        totalCost = totalCost.add(totalDetail.multiply(BigDecimal.valueOf(1 - countOrders / 100)));
        return totalCost;
    }
}
