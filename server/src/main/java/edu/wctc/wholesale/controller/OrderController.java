package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.dto.Order;
import edu.wctc.wholesale.entity.Wholesale_order;
import edu.wctc.wholesale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    // TODO how do I know if it's working?
    private Order convertToDto(Wholesale_order wholesale_order) {
//      for modelMapper configurations see: http://modelmapper.org/user-manual/configuration/
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE)
//                .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
//        Order order = modelMapper.map(wholesale_order, Order.class);

//        Getter/Setter is alternative to modelmapper
        Order order = new Order();
        order.setCustomerName(wholesale_order.getCustomer().getName());
        order.setDate(wholesale_order.getPurchaseDate());
        order.setPoNumber(wholesale_order.getPurchaseOrderNumber());
        order.setProductName(wholesale_order.getProduct().getName());
        order.setTerms(wholesale_order.getTerms());
        order.setShipped(wholesale_order.getShippedDate());
        order.setTotal(wholesale_order.getProduct().getCost());

//        copied from script.js
//        tr.append("<td>" + order.customerName + "</td>");
//        tr.append("<td>" + order.date + "</td>");
//        tr.append("<td>" + order.poNumber + "</td>");
//        tr.append("<td>" + order.productName + "</td>");
//        tr.append("<td>" + order.terms + "</td>");
//        tr.append("<td>" + order.shipped + "</td>");
//        tr.append("<td>" + order.total + "</td>");
        return order;
    }

    private Wholesale_order convertToEntity(Order order) {
        Wholesale_order wholesale_order = modelMapper.map(order, Wholesale_order.class);
        //TODO set appropriate setter/getter combinations
        //ambiguity flag set to true
        return wholesale_order;
    }

//    @GetMapping("/")
//    public List<Order> getAllOrders() {
//        //convert List of WholeSaleOrders to List of Orders
//        List<Wholesale_order> wList = orderService.getAllOrders();
//        List<Order> oList = null;
//        Iterator<Wholesale_order> wholesale_orderIterator = wList.iterator();
//        while (wholesale_orderIterator.hasNext()) {
//            Order order = convertToDto(wholesale_orderIterator.next());
//            oList.add(order);
//        }
//        return oList;
//    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }
}
