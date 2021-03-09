package com.quanlybanhang.qlbh.modalmapping;

import com.quanlybanhang.qlbh.dto.OrderDTO;
import com.quanlybanhang.qlbh.entity.OrderEntity;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static OrderDTO entity2DTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = modelMapper.map(orderEntity,OrderDTO.class);
        return orderDTO;
    }

    public static OrderEntity dto2Entity(OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapper.map(orderDTO,OrderEntity.class);
        return orderEntity;
    }
}
