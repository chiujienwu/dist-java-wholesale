package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(int product_id) throws ResourceNotFoundException;

    void saveProduct(Product product);

    void deleteProduct(int product_id) throws ResourceNotFoundException;

}
