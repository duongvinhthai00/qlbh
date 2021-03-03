package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> GetProductByCategoryId(Integer CategoryId);
}
