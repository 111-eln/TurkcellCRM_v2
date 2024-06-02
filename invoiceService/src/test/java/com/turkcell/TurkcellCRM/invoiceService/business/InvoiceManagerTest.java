package com.turkcell.TurkcellCRM.invoiceService.business;

import com.turkcell.TurkcellCRM.invoiceService.business.concretes.InvoiceManager;
import com.turkcell.TurkcellCRM.invoiceService.entities.Order;
import com.turkcell.TurkcellCRM.invoiceService.repositories.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;

public class InvoiceManagerTest {

    private InvoiceRepository invoiceRepository;
    private InvoiceManager invoiceManager;

    @BeforeEach
    public void setUp() {

        invoiceRepository = mock(InvoiceRepository.class);
        invoiceManager = new InvoiceManager(invoiceRepository);
    }

    @Test
    public void testAddOrder() {

        Order order = new Order();
        invoiceManager.add(order);
        verify(invoiceRepository, times(1)).save(any(Order.class));
    }
}