package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.ViewDao;
import com.quanlybanhang.qlbh.dto.ViewDTO;
import com.quanlybanhang.qlbh.entity.ViewEntity;
import com.quanlybanhang.qlbh.modalmapping.ViewMapper;
import com.quanlybanhang.qlbh.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewDao viewDao;

    @Override
    public ViewDTO SaveView(ViewDTO viewDTO) {
        List<ViewEntity> list = viewDao.findAll();
        for(ViewEntity entity : list){
            if(viewDTO.getPro_id().getId() == entity.getPro_id().getId() && viewDTO.getUser_id().getId() == entity.getUser_id().getId()){
                ViewEntity viewEntity = entity;
                viewEntity.setView_number(entity.getView_number() + 1);
                viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
                return viewDTO;
            }
        }
        viewDTO.setView_number(1);
        ViewEntity viewEntity = ViewMapper.dto2Entity(viewDTO);
        viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
        return viewDTO;
    }

    public ViewDTO SaveRating(ViewDTO viewDTO) {
        List<ViewEntity> list = viewDao.findAll();
        for(ViewEntity entity : list){
            if(viewDTO.getPro_id().getId() == entity.getPro_id().getId() && viewDTO.getUser_id().getId() == entity.getUser_id().getId()){
                ViewEntity viewEntity = entity;
                viewEntity.setRating_number(viewDTO.getRating_number());
                viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
                return viewDTO;
            }
        }
        viewDTO.setView_number(1);
        ViewEntity viewEntity = ViewMapper.dto2Entity(viewDTO);
        viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
        return viewDTO;
    }

    @Override
    public ViewDTO GetView(Integer pro_id,Integer user_id) {
        ViewEntity viewEntity = viewDao.GetView(pro_id,user_id);
        ViewDTO viewDTO = ViewMapper.entity2DTO(viewEntity);
        return viewDTO;
    }
}
