package com.turkcell.TurkcellCRM.invoiceService.business;

import com.turkcell.TurkcellCRM.invoiceService.entities.Order;
import com.turkcell.TurkcellCRM.invoiceService.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService{
    private InvoiceRepository invoiceRepository;
    @Override
    public void add(Order order) {
        invoiceRepository.save(order);

    }
}
