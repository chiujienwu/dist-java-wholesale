package edu.wctc.wholesale.repository;

import edu.wctc.wholesale.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
