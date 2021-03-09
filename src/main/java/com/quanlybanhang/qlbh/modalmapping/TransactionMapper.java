package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.TransactionDTO;
import com.quanlybanhang.qlbh.entity.TransactionEntity;
import org.modelmapper.ModelMapper;

public class TransactionMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static TransactionDTO entity2DTO(TransactionEntity transactionEntity) {
        TransactionDTO transactionDTO = modelMapper.map(transactionEntity,TransactionDTO.class);
        return transactionDTO;
    }

    public static TransactionEntity dto2Entity(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO,TransactionEntity.class);
        return transactionEntity;
    }
}
