package com.adamantsystems.adamantecommerce.controllers;
import com.adamantsystems.adamantecommerce.models.*;
import com.adamantsystems.adamantecommerce.repo.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Set;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductCart productOrderCart;


    public OrderController(OrderRepository orderRepository, ProductCart productOrderCart) {
        this.orderRepository = orderRepository;
        this.productOrderCart = productOrderCart;
    }


    @GetMapping("/order")
    public String get(Model model){

    model.addAttribute(new Order());

    Set<Product> orderList = productOrderCart.getTempleProdCart();
    model.addAttribute("ordersToBuy", orderList);


    return "order";
    }



    @PostMapping("/order")
    public String makeOrder(@RequestParam String order_name,@RequestParam String order_lastname,@RequestParam String order_email
            ,@RequestParam String order_address,@RequestParam String order_phone){
        Set<Product> orderList = productOrderCart.getTempleProdCart();
        Order order = new Order(order_name, order_lastname, order_email, order_address, order_phone, orderList);
        orderRepository.save(order);
        productOrderCart.clear();
        return "home";
    }

    @GetMapping("/order/show")
    public String showOrders(Model model) {
        Iterable<Order> orderList = orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "ordersShowAll";
    }

}
