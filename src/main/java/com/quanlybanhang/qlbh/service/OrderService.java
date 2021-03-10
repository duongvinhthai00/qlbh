package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.OrderDTO;
import com.quanlybanhang.qlbh.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrderByTransactionID(Integer tr_id);
}
