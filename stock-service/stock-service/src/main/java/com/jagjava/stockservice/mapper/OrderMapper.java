package com.jagjava.stockservice.mapper;

import com.jagjava.basedomain.dto.OrderEvent;
import com.jagjava.stockservice.document.OrderDocument;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

    public OrderDocument doToDoc(OrderEvent orderEvent) {
        OrderDocument orderDocument = new OrderDocument();
        orderDocument.setOrderId(orderEvent.getOrder().getOrderId());
        orderDocument.setName(orderEvent.getOrder().getName());
        orderDocument.setQty(orderEvent.getOrder().getQty());
        orderDocument.setPrice(orderEvent.getOrder().getPrice());
        return orderDocument;

    }
}
