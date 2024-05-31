package com.turkcell.TurkcellCRM.orderService.dataAccess;

import com.turkcell.TurkcellCRM.orderService.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

