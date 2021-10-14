package com.shoppee.study.repository;

import com.shoppee.study.model.Cart;
import com.shoppee.study.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    Iterable<Product> findAllByCart(Cart cart);
}
