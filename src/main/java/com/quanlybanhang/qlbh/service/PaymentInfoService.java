package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.PaymentInfoDTO;

import java.util.List;

public interface PaymentInfoService {
    List<PaymentInfoDTO> GetAllPaymentInfo();
    Boolean DeletePaymentInfo(Integer id);
    PaymentInfoDTO AddPaymentInfo(PaymentInfoDTO paymentInfoDTO);
    PaymentInfoDTO UpdatePaymentInfo(PaymentInfoDTO paymentInfoDTO);
    PaymentInfoDTO findPaymentInfoById(Integer id);
}
