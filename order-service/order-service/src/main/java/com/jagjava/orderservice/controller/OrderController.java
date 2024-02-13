package com.jagjava.orderservice.controller;

import com.jagjava.basedomain.dto.Order;
import com.jagjava.basedomain.dto.OrderEvent;
import com.jagjava.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/admin/order")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping(value = "/send")
    public String sendMessage(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setMessage("Order Created");
        orderEvent.setStatus("SUCCESS");
        orderEvent.setOrder(order);
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return "Order Created";

    }
}
