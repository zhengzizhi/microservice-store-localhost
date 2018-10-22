package com.contoso.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.contoso.product.Product;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1")
public class InventoryControllerV1 {
	private static Logger log = LoggerFactory.getLogger(InventoryControllerV1.class);

    private InventoryServiceV1 inventoryService;

    @Autowired
    public InventoryControllerV1(InventoryServiceV1 inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET, name = "getProduct")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId,HttpServletRequest request) {
    	log.info("/products/{productId} === "+request.getRequestURL());
    	return Optional.ofNullable(inventoryService.getProduct(productId))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/inventory", method = RequestMethod.GET, name = "getAvailableInventoryForProductIds")
    public ResponseEntity<?> getAvailableInventoryForProductIds(@RequestParam("productIds") String productIds,HttpServletRequest request) {
    	log.info("/inventory === "+request.getRequestURL());
    	log.info("@RequestParam(\"productIds\") === "+productIds);
    	return Optional.ofNullable(inventoryService.getAvailableInventoryForProductIds(productIds))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
