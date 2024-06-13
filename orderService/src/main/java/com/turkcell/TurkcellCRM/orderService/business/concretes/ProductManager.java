package com.turkcell.TurkcellCRM.orderService.business.concretes;

import com.turkcell.TurkcellCRM.orderService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.orderService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    @Transactional
    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllByOrderId(int id) {
        return productRepository.getAllByOrderId(id);
    }
}
