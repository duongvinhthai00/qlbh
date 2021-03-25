package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.CategoryGroupDao;
import com.quanlybanhang.qlbh.dto.CategoryGroupDTO;
import com.quanlybanhang.qlbh.entity.CategoryGroupEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.exception.NotFoundException;
import com.quanlybanhang.qlbh.modalmapping.CategoryGroupMapper;
import com.quanlybanhang.qlbh.service.CategoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryGroupImpl implements CategoryGroupService {
    @Autowired
    private CategoryGroupDao categoryGroupDao;

    @Override
    public List<CategoryGroupDTO> findCategoryGroupAll() {
        List<CategoryGroupEntity> listCategoryGroupEntity = categoryGroupDao.findAll();
        List<CategoryGroupDTO> listCategoryGroupDTO = new ArrayList<>();
        for(CategoryGroupEntity categoryGroupEntity : listCategoryGroupEntity) {
            CategoryGroupDTO categoryGroupDTO = CategoryGroupMapper.entity2DTO(categoryGroupEntity);
            listCategoryGroupDTO.add(categoryGroupDTO);
        }
        return listCategoryGroupDTO;
    }

    @Override
    public CategoryGroupDTO findCategoryGroupById(Integer id) {
        try {
            CategoryGroupEntity categoryGroupEntity = categoryGroupDao.findById(id).get();
            CategoryGroupDTO categoryGroupDTO = CategoryGroupMapper.entity2DTO(categoryGroupEntity);
            return categoryGroupDTO;
        }catch (Exception e){
            throw new NotFoundException("Không Tìm Thấy CategoryGroup");
        }
    }

    @Override
    public CategoryGroupDTO addCategoryGroup(CategoryGroupDTO categoryGroupDTO) {
        try {
            CategoryGroupEntity categoryGroupEntity = CategoryGroupMapper.dto2Entity(categoryGroupDTO);
            categoryGroupDao.save(categoryGroupEntity);
            return categoryGroupDTO;
        }catch (Exception e){
            throw new ExceptionGobal("Thêm CategoryGroup Thất Bại");
        }
    }

    @Override
    public void updateCategoryGroup(CategoryGroupDTO categoryGroupDTO) {
        CategoryGroupEntity categoryGroupEntity = null;
        try {
            categoryGroupEntity = categoryGroupDao.findById(categoryGroupDTO.getId()).get();
        }catch (Exception e){
            throw  new ExceptionGobal("Không Tìm Thấy CategoryGroup Để Chỉnh Sửa");
        }

        try {
            if(categoryGroupEntity != null) {
                categoryGroupEntity = CategoryGroupMapper.dto2Entity(categoryGroupDTO);
                categoryGroupDao.save(categoryGroupEntity);
            }
        }catch (Exception e){
            throw new ExceptionGobal("Cập Nhật CategoryGroup Thất Bại");
        }

    }

    @Override
    public Boolean deleteCateGroup(Integer id) {
        categoryGroupDao.deleteById(id);
        return true;
    }

}
