package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> GetProductByCategoryId(Integer CategoryId);
    ProductDTO getProductById(Integer id);
    List<ProductDTO> getProductAll();
    List<ProductDTO> SearchProducts(String searchInput);
    Boolean DeleteProduct(Integer id);
    ProductDTO addProduct(ProductDTO productDTO);
    void updateProduct(ProductDTO productDTO);
    ProductDTO updateProduct2(ProductDTO productDTO);
}
