package com.jagjava.stockservice.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class OrderDocument {
    @Id
    String orderId;
    String name;
    int qty;
    double price;
}
