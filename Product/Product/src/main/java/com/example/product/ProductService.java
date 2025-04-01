package com.example.product;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.ws.core.ProductCreatedEvent;


@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;
	KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
	private final Logger LOGGER  = LoggerFactory.getLogger(this.getClass());

    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    public Product getproductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public String addProduct(Product product) throws Exception{
    	String productId = UUID.randomUUID().toString();
		
		// TODO: Persist Product Details into database table before publishing an Event
    	productRepository.save(product);
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId,
				product.getName(), product.getPrice(), product.getQuantity());
		
		LOGGER.info("Before publishing a ProductCreatedEvent");
		
		SendResult<String, ProductCreatedEvent> result = 
				kafkaTemplate.send("product-created-events-topic",productId, productCreatedEvent).get();
		
		LOGGER.info("Partition: " + result.getRecordMetadata().partition());
		LOGGER.info("Topic: " + result.getRecordMetadata().topic());
		LOGGER.info("Offset: " + result.getRecordMetadata().offset());
		
		LOGGER.info("***** Returning product id");
        return productId;
    }
}