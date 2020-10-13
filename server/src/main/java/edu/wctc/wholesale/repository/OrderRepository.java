package edu.wctc.wholesale.repository;

import edu.wctc.wholesale.entity.Wholesale_order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Wholesale_order, Integer> {
//    boolean existsByCustomerAndProduct(Customer customer, Product product);
}
