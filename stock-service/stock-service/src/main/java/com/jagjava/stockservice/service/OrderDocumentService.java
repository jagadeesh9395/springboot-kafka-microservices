package com.jagjava.stockservice.service;

import com.jagjava.stockservice.OrderDocumentRepository;
import com.jagjava.stockservice.document.OrderDocument;
import org.springframework.stereotype.Service;

@Service
public class OrderDocumentService {
    OrderDocumentRepository orderDocumentRepository;

    public OrderDocumentService(OrderDocumentRepository orderDocumentRepository) {
        this.orderDocumentRepository = orderDocumentRepository;
    }

    public void saveOrder(OrderDocument orderDocument) {
        orderDocumentRepository.save(orderDocument);
    }

}
