package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.ImageDao;
import com.quanlybanhang.qlbh.dto.ImageDTO;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.entity.ImageEntity;
import com.quanlybanhang.qlbh.modalmapping.ImageMapper;
import com.quanlybanhang.qlbh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public List<ImageDTO> findImagesByProductId(Integer id) {
        List<ImageEntity> imageEntityList = imageDao.findImagesByProductId(id);
        List<ImageDTO> dtos = new ArrayList<>();
        for(ImageEntity imageEntity : imageEntityList){
            ImageDTO imageDTO = ImageMapper.entity2DTO(imageEntity);
            dtos.add(imageDTO);
        }
        return dtos;
    }

    @Override
    public void addImagesForProduct(String FileName, ProductDTO productDTO) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setIm_name(FileName);
        imageDTO.setIm_product_id(productDTO);
        imageDTO.setCreated_at(TimeService.getTimeNow());
        ImageEntity imageEntity = ImageMapper.dto2Entity(imageDTO);
        imageDao.save(imageEntity);
    }

    @Override
    public void DeleteImageProduct(Integer pro_id) {
        this.imageDao.DeleteImageProduct(pro_id);
    }

}
