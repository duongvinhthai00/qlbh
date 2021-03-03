package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.ProductDao;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.modalmapping.ProductMapper;
import com.quanlybanhang.qlbh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductDTO> GetProductByCategoryId(Integer CategoryId) {
        List<ProductEntity> listProduct = productDao.GetProductByCategoryId(CategoryId);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity productEntity : listProduct){
            ProductDTO productDTO = ProductMapper.entity2DTO(productEntity);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}
