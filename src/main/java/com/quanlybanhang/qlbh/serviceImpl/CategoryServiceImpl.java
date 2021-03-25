package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.CategoryDao;
import com.quanlybanhang.qlbh.dto.CategoryDTO;
import com.quanlybanhang.qlbh.entity.CategoryEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.exception.NotFoundException;
import com.quanlybanhang.qlbh.modalmapping.CategoryMapper;
import com.quanlybanhang.qlbh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<CategoryDTO> findCategoryAll() {
        List<CategoryEntity> listCategoryEntity = categoryDao.findAll();
        List<CategoryDTO> listCategoryDTO = new ArrayList<>();
        for(CategoryEntity categoryEntity : listCategoryEntity) {
            CategoryDTO categoryDTO = CategoryMapper.entity2DTO(categoryEntity);
            listCategoryDTO.add(categoryDTO);
        }
        return listCategoryDTO;
    }

    @Override
    public CategoryDTO findCategoryById(Integer id) {
        try {
            CategoryEntity categoryEntity = categoryDao.findById(id).get();
            CategoryDTO categoryDTO = CategoryMapper.entity2DTO(categoryEntity);
            return categoryDTO;
        }catch (Exception e){
            throw new NotFoundException("Không Tìm Thấy Category");
        }
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        try {
            CategoryEntity categoryEntity = CategoryMapper.dto2Entity(categoryDTO);
            categoryDao.save(categoryEntity);
            return categoryDTO;
        }catch (Exception e){
            throw new ExceptionGobal("Thêm Category Thất Bại");
        }
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = null;
        try {
            categoryEntity = categoryDao.findById(categoryDTO.getId()).get();
        }catch (Exception e){
            throw  new ExceptionGobal("Không Tìm Thấy Category Để Chỉnh Sửa");
        }

        try {
            if(categoryEntity != null) {
                categoryEntity = CategoryMapper.dto2Entity(categoryDTO);
                categoryDao.save(categoryEntity);
            }
        }catch (Exception e){
            throw new ExceptionGobal("Cập Nhật Category Thất Bại");
        }

    }

    @Override
    public List<CategoryDTO> findAllByCategoryGroup(Integer id,Integer idCr) {
        List<CategoryEntity> listCategory = categoryDao.findAllByCategoryGroup(id,idCr);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity categoryEntity : listCategory){
            CategoryDTO categoryDTO = CategoryMapper.entity2DTO(categoryEntity);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

}
