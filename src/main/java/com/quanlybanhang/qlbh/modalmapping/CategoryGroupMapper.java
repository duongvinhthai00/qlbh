package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.CategoryGroupDTO;
import com.quanlybanhang.qlbh.entity.CategoryGroupEntity;
import org.modelmapper.ModelMapper;

public class CategoryGroupMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static CategoryGroupDTO entity2DTO(CategoryGroupEntity categoryGroupEntity) {
        CategoryGroupDTO categoryGroupDTO = modelMapper.map(categoryGroupEntity, CategoryGroupDTO.class);
        return categoryGroupDTO;
    }

    public static CategoryGroupEntity dto2Entity(CategoryGroupDTO categoryGroupDTO) {
        CategoryGroupEntity categoryGroupEntity = modelMapper.map(categoryGroupDTO,CategoryGroupEntity.class);
        return categoryGroupEntity;
    }

}
