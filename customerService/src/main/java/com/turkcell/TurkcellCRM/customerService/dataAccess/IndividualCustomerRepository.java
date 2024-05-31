package com.turkcell.TurkcellCRM.customerService.dataAccess;

import com.turkcell.TurkcellCRM.customerService.entities.concretes.BaseCustomer;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    Optional<IndividualCustomer> findByNationalityNumber(String nationalityId);

}
