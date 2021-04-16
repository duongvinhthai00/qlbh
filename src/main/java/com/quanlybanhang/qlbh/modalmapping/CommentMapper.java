package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.CommentDTO;
import com.quanlybanhang.qlbh.entity.CommentEntity;
import org.modelmapper.ModelMapper;

public class CommentMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static CommentDTO entity2DTO(CommentEntity commentEntity) {
        CommentDTO commentDTO = modelMapper.map(commentEntity, CommentDTO.class);
        return commentDTO;
    }

    public static CommentEntity dto2Entity(CommentDTO commentDTO) {
        CommentEntity commentEntity = modelMapper.map(commentDTO,CommentEntity.class);
        return commentEntity;
    }
}
