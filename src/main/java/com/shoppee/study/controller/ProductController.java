package com.shoppee.study.controller;

import com.shoppee.study.model.Cart;
import com.shoppee.study.model.Comment;
import com.shoppee.study.model.Product;
import com.shoppee.study.service.CartService;
import com.shoppee.study.service.CommentService;
import com.shoppee.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;
    @Autowired
    CommentService commentService;

    @GetMapping("/listAllProduct")
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = (List<Product>) productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/listAllCart")
    public ResponseEntity<List<Cart>> listCart() {
        List<Cart> carts = (List<Cart>) cartService.findAll();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/listComment/{id}")
    public ResponseEntity<List<Comment>> listComments(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        List<Comment> comments = (List<Comment>) commentService.showListCommentInProduct(product);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/listProduct/{id}")
    public ResponseEntity<List<Product>> listProduct(@PathVariable Long id) {
        Cart cart = cartService.findById(id).get();
        List<Product> products = (List<Product>) productService.showListProductInCart(cart);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) { //Tu FE xuong BE
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK); //Gui tu BE sang FE
    }

    @PostMapping("/createCart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) { //Tu FE xuong BE
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK); //Gui tu BE sang FE
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) { //Tu FE xuong BE}product){ //Tu FE xuong BE
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.OK); //Gui tu BE sang FE
    }

    @GetMapping("/detailProduct/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
