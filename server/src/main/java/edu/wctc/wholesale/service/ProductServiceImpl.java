package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    // cannot delete product if there are product ordered
    public void deleteProduct(int product_id) {
        productRepository.deleteById(product_id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    public Product getProduct(int product_id) throws ResourceNotFoundException {
        return productRepository.findById(product_id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "product_id", product_id));
    }
}
