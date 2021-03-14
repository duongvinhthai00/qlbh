package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> GetProductByCategoryId(Integer CategoryId);
    ProductDTO getProductById(Integer id);
    List<ProductDTO> getProductAll();
    List<ProductDTO> SearchProducts(String searchInput);
}
