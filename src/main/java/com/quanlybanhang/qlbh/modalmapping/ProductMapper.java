package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.entity.ProductEntity;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static ProductDTO entity2DTO(ProductEntity productEntity) {
        ProductDTO productDTO = modelMapper.map(productEntity,ProductDTO.class);
        return productDTO;
    }

    public static ProductEntity dto2Entity(ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO,ProductEntity.class);
        return productEntity;
    }
}
