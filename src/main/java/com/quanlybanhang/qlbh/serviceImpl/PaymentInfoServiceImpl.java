package com.quanlybanhang.qlbh.serviceImpl;


import com.quanlybanhang.qlbh.dao.PaymentInfoDao;
import com.quanlybanhang.qlbh.dto.PaymentInfoDTO;
import com.quanlybanhang.qlbh.entity.PaymentInfoEntity;
import com.quanlybanhang.qlbh.modalmapping.PaymentInfoMapper;
import com.quanlybanhang.qlbh.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Autowired
    private PaymentInfoDao paymentInfoDao;

    @Override
    public List<PaymentInfoDTO> GetAllPaymentInfo() {
        List<PaymentInfoEntity> entityList = paymentInfoDao.findAll();
        List<PaymentInfoDTO> paymentInfoDTOS = new ArrayList<>();
        for(PaymentInfoEntity entity : entityList){
            paymentInfoDTOS.add(PaymentInfoMapper.entity2DTO(entity));
        }
        return paymentInfoDTOS;
    }

    @Override
    public Boolean DeletePaymentInfo(Integer id) {
        paymentInfoDao.deleteById(id);
        return true;
    }

    @Override
    public PaymentInfoDTO AddPaymentInfo(PaymentInfoDTO paymentInfoDTO) {
        PaymentInfoEntity paymentInfoEntity = PaymentInfoMapper.dto2Entity(paymentInfoDTO);
        paymentInfoDTO = PaymentInfoMapper.entity2DTO(paymentInfoDao.save(paymentInfoEntity));
        return paymentInfoDTO;
    }

    @Override
    public PaymentInfoDTO UpdatePaymentInfo(PaymentInfoDTO paymentInfoDTO) {
        PaymentInfoEntity paymentInfoEntity = PaymentInfoMapper.dto2Entity(paymentInfoDTO);
        paymentInfoDTO = PaymentInfoMapper.entity2DTO(paymentInfoDao.save(paymentInfoEntity));
        return paymentInfoDTO;
    }

    @Override
    public PaymentInfoDTO findPaymentInfoById(Integer id) {
        PaymentInfoEntity entity = paymentInfoDao.findById(id).get();
        PaymentInfoDTO dto = PaymentInfoMapper.entity2DTO(entity);
        return dto;
    }
}
