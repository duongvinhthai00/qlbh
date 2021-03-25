package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findCategoryAll();
    CategoryDTO findCategoryById(Integer id);
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    void updateCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> findAllByCategoryGroup(Integer id,Integer idCr);
    Boolean deleteCategoryById(Integer id);
}
