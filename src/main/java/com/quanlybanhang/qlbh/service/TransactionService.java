package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    TransactionDTO addTransaction(TransactionDTO transactionDTO);
    List<TransactionDTO> GetTransactionByUser(Integer userId);
    TransactionDTO getTransactionById(Integer tr_id);
}
