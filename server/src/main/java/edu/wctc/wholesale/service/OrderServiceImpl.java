package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Wholesale_order;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // Not sure we need this since a customer can order the same product again
//    public boolean isOrdered(Wholesale_order wholesaleOrder) {
//        return orderRepository.existsByCustomerAndProduct(wholesaleOrder.getCustomer(), wholesaleOrder.getProduct());
//    }

    @Override
    public List<Wholesale_order> getAllOrders() {

        List<Wholesale_order> list = new ArrayList<>();
        orderRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Wholesale_order getOrder(int order_id) throws ResourceNotFoundException {
        return orderRepository.findById(order_id).orElseThrow(
                () -> new ResourceNotFoundException("Order", "order_id", order_id));
    }

    @Override
    public void saveOrder(Wholesale_order wholesaleOrder) {
        orderRepository.save(wholesaleOrder);
    }

    // Cannot cancel if ship date is in the past
    @Override
    public void deleteOrder(int order_id) throws ResourceNotFoundException {
        orderRepository.deleteById(order_id);
    }
}
