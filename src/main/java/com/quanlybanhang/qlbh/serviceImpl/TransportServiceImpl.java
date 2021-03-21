package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dao.TransportDao;
import com.quanlybanhang.qlbh.dto.TransportDTO;
import com.quanlybanhang.qlbh.entity.TransportEntity;
import com.quanlybanhang.qlbh.modalmapping.TransportMapper;
import com.quanlybanhang.qlbh.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {
    @Autowired
    private TransportDao transportDao;

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<TransportDTO> GetAllTransport() {
        List<TransportEntity> transportEntityList = transportDao.findAll();
        List<TransportDTO> transportDTOS = new ArrayList<>();
        for(TransportEntity entity : transportEntityList){
            transportDTOS.add(TransportMapper.entity2DTO(entity));
        }
        return transportDTOS;
    }

    @Override
    public Boolean DeleteTransportById(Integer id) {
        try {
            transactionDao.UpdateTransactionByTransport(id);
            transportDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public TransportDTO addOrUpdateTransport(TransportDTO transportDTO) {
        TransportEntity transportEntity = TransportMapper.dto2Entity(transportDTO);
        transportDTO = TransportMapper.entity2DTO(transportDao.save(transportEntity));
        return transportDTO;
    }

    @Override
    public TransportDTO getTransportById(Integer id) {
        TransportEntity transportEntity = transportDao.findById(id).get();
        TransportDTO transportDTO = TransportMapper.entity2DTO(transportEntity);
        return transportDTO;
    }
}
