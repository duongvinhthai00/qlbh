package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dto.TransactionDTO;
import com.quanlybanhang.qlbh.entity.TransactionEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.TransactionMapper;
import com.quanlybanhang.qlbh.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        try {
            TransactionEntity transactionEntity = TransactionMapper.dto2Entity(transactionDTO);
            transactionDao.save(transactionEntity);
            transactionDTO = TransactionMapper.entity2DTO(transactionEntity);
        }catch (Exception e){
            throw new ExceptionGobal("Thêm Transaction Thất Bại");
        }
        return transactionDTO;
    }
}