package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.ProductDao;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.entity.UserEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.ProductMapper;
import com.quanlybanhang.qlbh.modalmapping.UserMapper;
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

    @Override
    public ProductDTO getProductById(Integer id) {
        ProductEntity productEntity = productDao.findById(id).get();
        ProductDTO productDTO = ProductMapper.entity2DTO(productEntity);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductAll() {
        List<ProductEntity> entityList = productDao.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity entity : entityList){
            ProductDTO productDTO = ProductMapper.entity2DTO(entity);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> SearchProducts(String searchInput) {
        List<ProductEntity> entityList = productDao.SearchProducts(searchInput);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity entity : entityList){
            ProductDTO productDTO = ProductMapper.entity2DTO(entity);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public Boolean DeleteProduct(Integer id) {
        try {
            productDao.deleteById(id);
        }catch (Exception e){
            throw new ExceptionGobal("Xóa Thất Bại");
        }
        return true;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.dto2Entity(productDTO);
        productEntity.setCreated_at(TimeService.getTimeNow());
        productEntity = productDao.save(productEntity);
        productDTO = ProductMapper.entity2DTO(productEntity);
        return productDTO;
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = null;
        try {
            productEntity = productDao.findById(productDTO.getId()).get();
        }catch (Exception e){
            throw  new ExceptionGobal("Không Tìm Thấy Product Để Chỉnh Sửa");
        }

        try {
            if(productEntity != null) {
                productEntity = ProductMapper.dto2Entity(productDTO);
                productDao.save(productEntity);
            }
        }catch (Exception e){
            throw new ExceptionGobal("Cập Nhật Thất Bại");
        }
    }


}
