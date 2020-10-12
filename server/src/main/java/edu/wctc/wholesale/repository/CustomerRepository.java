package edu.wctc.wholesale.repository;

import edu.wctc.wholesale.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
