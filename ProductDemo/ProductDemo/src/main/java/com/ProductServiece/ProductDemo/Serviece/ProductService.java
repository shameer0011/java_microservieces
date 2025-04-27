package com.ProductServiece.ProductDemo.Serviece;

import com.ProductServiece.ProductDemo.DTO.ProductDTO;

public interface ProductService {
    void addProduct(ProductDTO productdto);

    Long updateProductQuantity(Long id, Long quantity);

    ProductDTO addProduct(Long id);

}
