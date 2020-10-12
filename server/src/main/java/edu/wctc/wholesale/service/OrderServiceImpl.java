package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Customer;
import edu.wctc.wholesale.entity.Wholesale_order;
import edu.wctc.wholesale.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;

    // Cannot cancel if ship date is in the past
    public void cancelOrder(int order_id) {
        orderRepository.deleteById(order_id);
    }

    // Not sure we need this since a customer can order the same product again
    public boolean isOrdered(Wholesale_order wholesaleOrder) {
        return orderRepository.existsByCustomerAndProduct(wholesaleOrder.getCustomer(), wholesaleOrder.getProduct());
    }

    public void order(Wholesale_order wholesaleOrder) {
        orderRepository.save(wholesaleOrder);
    }

}
