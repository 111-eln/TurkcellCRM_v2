package com.turkcell.TurkcellCRM.orderService.business.rules;

import com.turkcell.TurkcellCRM.orderService.business.messages.Messages;
import com.turkcell.TurkcellCRM.orderService.core.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.orderService.dataAccess.OrderRepository;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderBusinnesRules {

    private final OrderRepository orderRepository;

    public void orderShouldBeExists(int orderId) {
        Optional<Order> foundOrderCustomer = orderRepository.findById(orderId);
        if (foundOrderCustomer.isEmpty()) {
            throw new BusinessException(Messages.OrderErrorMessages.ORDER_NOT_FOUND);
        }
    }

    public void ordersShouldBeExist() {
        List<Order> orderList = this.orderRepository.findAll();
        if (orderList.isEmpty()) {
            throw new BusinessException(Messages.OrderErrorMessages.ORDERS_NOT_FOUND);
        }
    }
}
