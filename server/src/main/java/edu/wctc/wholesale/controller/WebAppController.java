package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.entity.Wholesale_order;
import edu.wctc.wholesale.service.OrderService;
import edu.wctc.wholesale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebAppController {
    private String appMode;

    //What does this do?
    @Autowired
    public void WebAppContoller(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index(Model model){

        List<Wholesale_order> list = new ArrayList<>();

        list = orderService.getAllOrders();

        model.addAttribute("orderList", list);

        return "index";
    }
}
