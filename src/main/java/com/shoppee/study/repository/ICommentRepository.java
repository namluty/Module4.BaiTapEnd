package com.shoppee.study.repository;

import com.shoppee.study.model.Comment;
import com.shoppee.study.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> findAllByProduct(Product product); //Lay ra list commet o trong product
}
