package com.shoppee.study.service;

import com.shoppee.study.model.Cart;
import com.shoppee.study.model.Comment;
import com.shoppee.study.model.Product;
import com.shoppee.study.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IService<Product> {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public Iterable<Product> showListProductInCart(Cart cart){
        return productRepository.findAllByCart(cart);
    }
}
