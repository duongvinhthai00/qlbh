package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.CategoryDTO;
import com.quanlybanhang.qlbh.entity.CategoryEntity;
import org.modelmapper.ModelMapper;

public class CategoryMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static CategoryDTO entity2DTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
        return categoryDTO;
    }

    public static CategoryEntity dto2Entity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = modelMapper.map(categoryDTO,CategoryEntity.class);
        return categoryEntity;
    }
}
