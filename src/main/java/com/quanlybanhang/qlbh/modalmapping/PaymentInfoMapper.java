package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.PaymentInfoDTO;
import com.quanlybanhang.qlbh.entity.PaymentInfoEntity;
import org.modelmapper.ModelMapper;

public class PaymentInfoMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static PaymentInfoDTO entity2DTO(PaymentInfoEntity paymentInfoEntity) {
        PaymentInfoDTO paymentInfoDTO = modelMapper.map(paymentInfoEntity,PaymentInfoDTO.class);
        return paymentInfoDTO;
    }

    public static PaymentInfoEntity dto2Entity(PaymentInfoDTO paymentInfoDTO) {
        PaymentInfoEntity paymentInfoEntity = modelMapper.map(paymentInfoDTO,PaymentInfoEntity.class);
        return paymentInfoEntity;
    }
}
