package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.service.ProductService;
import edu.wctc.wholesale.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
}
