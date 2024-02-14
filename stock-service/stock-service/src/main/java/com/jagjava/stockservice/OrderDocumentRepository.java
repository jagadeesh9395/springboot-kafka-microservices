package com.jagjava.stockservice;

import com.jagjava.stockservice.document.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDocumentRepository extends MongoRepository<OrderDocument, String> {
}
