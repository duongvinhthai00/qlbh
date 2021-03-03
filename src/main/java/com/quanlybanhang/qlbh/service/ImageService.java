package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ImageDTO;

import java.util.List;

public interface ImageService {
    List<ImageDTO> findImagesByProductId(Integer id);
}
