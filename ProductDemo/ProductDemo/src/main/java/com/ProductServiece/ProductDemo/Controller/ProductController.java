package com.ProductServiece.ProductDemo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProductServiece.ProductDemo.DTO.ProductDTO;
import com.ProductServiece.ProductDemo.External.Client.OrderService;
import com.ProductServiece.ProductDemo.Serviece.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PutMapping("/update_product_quantity/{id}")
    public ResponseEntity<Map<String, Object>> updateProductQuantity(
            @PathVariable("id") Long id,
            @RequestParam("qty") Long quantity) {
        Long updatedId = productService.updateProductQuantity(id, quantity);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Updated successfully");
        response.put("id", updatedId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Long id) {
        ProductDTO product = productService.addProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO product) {
        productService.addProduct(product);
        return new ResponseEntity<>(orderService.getDetails(), HttpStatus.CREATED);
    }

}
