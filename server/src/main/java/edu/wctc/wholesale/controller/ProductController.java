package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId){
        try {
            productService.deleteProduct(Integer.parseInt(productId));
            return "Successfully deleted Product ID: " + productId;
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Product ID: " + productId, e);
        }
    }

    @PutMapping("/")
    public Product updateEvent(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        product.setId(0);
        //with id set to zero, hibernate now knows this is a create vs update
        productService.saveProduct(product);
        return product;
        //hibernate will automatically fill in the product id and make it available to send back
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
//        public Product getProduct(@PathVariable (name="productId") String id) {
//        using String vs int is easier to handle when it comes to throw exceptions
        try {
            return productService.getProduct(Integer.parseInt(productId));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Product ID: " + productId, e);
        }
    }

}
