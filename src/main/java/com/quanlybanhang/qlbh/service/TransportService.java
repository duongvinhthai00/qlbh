package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.TransportDTO;

import java.util.List;

public interface TransportService {
    List<TransportDTO> GetAllTransport();
    Boolean DeleteTransportById(Integer id);
    TransportDTO addOrUpdateTransport(TransportDTO transportDTO);
    TransportDTO getTransportById(Integer id);
}
