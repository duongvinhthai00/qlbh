package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dto.TransactionDTO;
import com.quanlybanhang.qlbh.entity.TransactionEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.TransactionMapper;
import com.quanlybanhang.qlbh.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TransactionDTO> GetTransactionByUser(Integer userId) {
        List<TransactionEntity> transactionEntities = transactionDao.GetTransactionByUser(userId);
        List<TransactionDTO> transactionDTOList = new ArrayList<>();
        for(TransactionEntity entity : transactionEntities){
            transactionDTOList.add(TransactionMapper.entity2DTO(entity));
        }
        return transactionDTOList;
    }

    @Override
    public TransactionDTO getTransactionById(Integer tr_id) {
        TransactionEntity entity = transactionDao.findById(tr_id).get();
        TransactionDTO transactionDTO = TransactionMapper.entity2DTO(entity);
        return transactionDTO;
    }

    @Override
    public List<TransactionDTO> getAllTransaction() {
        List<TransactionEntity> entityList = transactionDao.findAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for(TransactionEntity transactionEntity : entityList){
            TransactionDTO transactionDTO = TransactionMapper.entity2DTO(transactionEntity);
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }

    @Override
    public TransactionDTO updateTransaction(TransactionDTO transactionDTO) {
        transactionDTO.setUpdated_at(TimeService.getTimeNow());
        TransactionEntity transactionEntity = TransactionMapper.dto2Entity(transactionDTO);
        return TransactionMapper.entity2DTO(transactionDao.save(transactionEntity));
    }
}
