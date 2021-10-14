package com.shoppee.study.service;

import com.shoppee.study.model.Comment;
import com.shoppee.study.model.Product;
import com.shoppee.study.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements IService<Comment> {
    @Autowired
    ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
    public Iterable<Comment> showListCommentInProduct(Product product) {
        return commentRepository.findAllByProduct(product);
    }
}
