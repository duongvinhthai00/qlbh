package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.OrderDao;
import com.quanlybanhang.qlbh.dto.OrderDTO;
import com.quanlybanhang.qlbh.entity.OrderEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.OrderMapper;
import com.quanlybanhang.qlbh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        try {
            OrderEntity orderEntity = OrderMapper.dto2Entity(orderDTO);
            orderDao.save(orderEntity);
            orderDTO = OrderMapper.entity2DTO(orderEntity);
        }catch (Exception e){
            throw new ExceptionGobal("Thêm Order Thất Bại");
        }
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrderByTransactionID(Integer tr_id) {
        List<OrderEntity> orderEntities = orderDao.getOrderByTransactionID(tr_id);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(OrderEntity entity : orderEntities){
            OrderDTO orderDTO = OrderMapper.entity2DTO(entity);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }
}
