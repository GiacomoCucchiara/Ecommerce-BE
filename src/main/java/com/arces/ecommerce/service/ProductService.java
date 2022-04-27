package com.arces.ecommerce.service;

import java.util.List;
import javax.transaction.Transactional;

import com.arces.ecommerce.entity.Product;
import com.arces.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);

    }

    public Product get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

	public List<Product> getProductsByTitle(String title) {
		return repo.findByTitle(title);
	}
}