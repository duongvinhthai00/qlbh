package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ImageDTO;
import com.quanlybanhang.qlbh.dto.ProductDTO;

import java.util.List;

public interface ImageService {
    List<ImageDTO> findImagesByProductId(Integer id);
    void addImagesForProduct(String FileName, ProductDTO productDTO);

    void DeleteImageProduct(Integer pro_id);
}
