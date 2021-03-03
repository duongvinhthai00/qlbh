package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.ImageDTO;
import com.quanlybanhang.qlbh.entity.ImageEntity;
import org.modelmapper.ModelMapper;

public class ImageMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static ImageDTO entity2DTO(ImageEntity imageEntity) {
        ImageDTO imageDTO = modelMapper.map(imageEntity, ImageDTO.class);
        return imageDTO;
    }

    public static ImageEntity dto2Entity(ImageDTO imageDTO) {
        ImageEntity imageEntity = modelMapper.map(imageDTO,ImageEntity.class);
        return imageEntity;
    }
}
