package com.turkcell.TurkcellCRM.accountService.dataAccess;

import com.turkcell.TurkcellCRM.accountService.core.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
