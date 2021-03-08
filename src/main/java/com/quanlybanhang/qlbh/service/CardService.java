package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.CardDTO;

import java.util.List;

public interface CardService {
    Boolean addOrUpdateCard(CardDTO cardDTO);
    List<CardDTO> findCardAllByUser(Integer userId);
    CardDTO updateCard(CardDTO cardDTO);
    void deleteCardDTO(Integer id);
    void deleteAllCard(Integer userId);
    Boolean checkCardToTransaction(List<CardDTO> listCardDTO,Integer userId);
}
