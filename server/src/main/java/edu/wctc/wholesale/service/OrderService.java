package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Wholesale_order;
import edu.wctc.wholesale.exception.ResourceNotFoundException;

import java.util.List;

public interface OrderService {

    List<Wholesale_order> getAllOrders();

    Wholesale_order getOrder(int order_id) throws ResourceNotFoundException;

    void saveOrder(Wholesale_order wholesaleOrder);

    void deleteOrder(int order_id) throws ResourceNotFoundException;

}


