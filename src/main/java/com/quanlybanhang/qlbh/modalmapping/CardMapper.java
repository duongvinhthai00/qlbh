package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.CardDTO;
import com.quanlybanhang.qlbh.entity.CardEntity;
import org.modelmapper.ModelMapper;

public class CardMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static CardDTO entity2DTO(CardEntity cardEntity) {
        CardDTO cardDTO = modelMapper.map(cardEntity, CardDTO.class);
        return cardDTO;
    }

    public static CardEntity dto2Entity(CardDTO cardDTO) {
        CardEntity cardEntity = modelMapper.map(cardDTO,CardEntity.class);
        return cardEntity;
    }
}
