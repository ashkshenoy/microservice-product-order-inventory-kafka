package com.example.product;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @GetMapping
    public List<Product> getAllproducts() {
        return productService.getAllproducts();
    }

    @GetMapping("/{id}")
    public Product getproductById(@PathVariable String id) {
        return productService.getproductById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
    	
    	String productId;
		try { 
			productId = productService.addProduct(product);
		} catch (Exception e) {
			//e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(new Date(), e.getMessage(),"/products"));
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}