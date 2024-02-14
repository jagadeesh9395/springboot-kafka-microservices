package com.jagjava.stockservice.kafka;

import com.jagjava.basedomain.dto.OrderEvent;
import com.jagjava.stockservice.OrderDocumentRepository;
import com.jagjava.stockservice.mapper.OrderMapper;
import com.jagjava.stockservice.service.OrderDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    OrderDocumentService orderDocumentService;

    @Autowired
    OrderMapper orderMapper;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    private void consume(OrderEvent orderEvent) {
        LOGGER.info("Stock Service Received OrderEvent : {}", orderEvent);


        //Save Data to Database
        orderDocumentService.saveOrder(orderMapper.doToDoc(orderEvent));
    }
}
