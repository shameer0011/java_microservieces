package com.ProductServiece.ProductDemo.Serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductServiece.ProductDemo.DTO.ProductDTO;
import com.ProductServiece.ProductDemo.Entity.Product;
import com.ProductServiece.ProductDemo.Repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(ProductDTO productdto) {
        System.out.println("Product added successfully");
        Product product = new Product();
        product.setName(productdto.getName());
        product.setPrice(productdto.getPrice());
        product.setQuantity(productdto.getQuantity());
        productRepository.save(product);
        // orderService.getDetails();
    }

    @Override
    public Long updateProductQuantity(Long id, Long quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            return product.getId();
        }
        return null;
    }

    @Override
    public ProductDTO addProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(id);
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantity(product.getQuantity());
            return productDTO;

        }
        return null;
    }
}
