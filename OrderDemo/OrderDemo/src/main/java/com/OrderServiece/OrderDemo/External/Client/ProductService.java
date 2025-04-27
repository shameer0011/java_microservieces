package com.OrderServiece.OrderDemo.External.Client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ProductDemo", path = "/api/product")
public interface ProductService {

    @PutMapping("/update_product_quantity/{id}")
    public ResponseEntity<Map<String, Object>> updateProductQuantity(
            @PathVariable("id") Long id,
            @RequestParam("qty") Long quantity);

}
