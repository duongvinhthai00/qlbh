package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.CardDao;
import com.quanlybanhang.qlbh.dto.CardDTO;
import com.quanlybanhang.qlbh.entity.CardEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.CardMapper;
import com.quanlybanhang.qlbh.service.CardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardDao cardDao;

    @Override
    public Boolean addOrUpdateCard(CardDTO cardDTO) {
        List<CardEntity> listCardEntity = cardDao.findAll();
        boolean ktra = false;
        CardEntity cardEntity1 = null;
        for (CardEntity cardEntity : listCardEntity){
           if(cardDTO.getC_product_id().getId() == cardEntity.getC_product_id().getId() && cardDTO.getC_user_id().getId() == cardEntity.getC_user_id().getId()){
               if(cardDTO.getC_qty() + cardEntity.getC_qty() > cardEntity.getC_product_id().getPro_number()){
                   throw  new ExceptionGobal("Vượt Quá Số Lượng Hàng !!!");
               }
               cardEntity1 = cardEntity;
               ktra = true;
               break;
           }
        }
        if(ktra == true){
            cardEntity1.setC_qty(cardEntity1.getC_qty() + cardDTO.getC_qty());
            cardDao.save(cardEntity1);
            return true;
        }
        cardEntity1 = CardMapper.dto2Entity(cardDTO);
        cardDao.save(cardEntity1);
        return  true;
    }

    @Override
    public List<CardDTO> findCardAllByUser(Integer userId) {
        List<CardEntity> cardEntities =  cardDao.findCardAllByUser(userId);
        List<CardDTO> listCardDTO = new ArrayList<>();
        for(CardEntity cardEntity : cardEntities){
            CardDTO cardDTO = CardMapper.entity2DTO(cardEntity);
            listCardDTO.add(cardDTO);
        }
        return listCardDTO;
    }

    @Override
    public CardDTO updateCard(CardDTO  cardDTO) {
        if(cardDTO.getC_qty() > cardDTO.getC_product_id().getPro_number()){
            throw new ExceptionGobal("Vượt Quá Số Lượng Hàng !!!");
        }
        CardEntity cardEntity = CardMapper.dto2Entity(cardDTO);
        cardDTO =  CardMapper.entity2DTO(cardDao.save(cardEntity));
        return cardDTO;
    }

    @Override
    public void deleteCardDTO(Integer id) {
        CardEntity cardEntity =null;
        try {
            cardEntity = cardDao.findById(id).get();
        }catch (Exception e){
            throw new ExceptionGobal("Card Không Tồn Tại");
        }
        try {
            cardDao.delete(cardEntity);
        }catch (Exception e){
            throw new ExceptionGobal("Xóa Không Thành Công");
        }
    }

    public void deleteAllCard(Integer userId){
        cardDao.deleteAllCard(userId);
    }

    @Override
    public Boolean checkCardToTransaction(List<CardDTO> listCardDTO,Integer userId) {
        StringBuilder error = new StringBuilder();
        List<CardDTO> dtos = findCardAllByUser(userId);
        for(int i = 0;i<dtos.size();i++){
            for(int j = 0;j<listCardDTO.size();j++){
                if(dtos.get(i).getId() == listCardDTO.get(j).getId()){
                    int k = dtos.get(i).getC_product_id().getPro_number() - listCardDTO.get(j).getC_qty();
                    if(k < 0){
                        if(dtos.get(i).getC_product_id().getPro_number() == 0){
                            error.append(dtos.get(i).getC_product_id().getPr_name() + " Đã Hết Hàng !\n");
                        }else{
                            error.append(dtos.get(i).getC_product_id().getPr_name() + " Chỉ Còn " + dtos.get(i).getC_product_id().getPro_number() + " Sản Phẩm !\n");
                        }
                    }
                }
            }
        }
        if(StringUtils.isNotEmpty(error)){
            error.append("VUI LÒNG CẬP NHẬT LẠI !!!");
            throw new ExceptionGobal(error.toString());
        }
        return true;
    }


}
