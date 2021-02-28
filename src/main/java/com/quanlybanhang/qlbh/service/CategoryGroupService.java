package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.AdminDTO;
import com.quanlybanhang.qlbh.dto.CategoryGroupDTO;

import java.util.List;

public interface CategoryGroupService {
    List<CategoryGroupDTO> findCategoryGroupAll();
    CategoryGroupDTO findCategoryGroupById(Integer id);
    CategoryGroupDTO addCategoryGroup(CategoryGroupDTO categoryGroupDTO);
    void updateCategoryGroup(CategoryGroupDTO categoryGroupDTO);
}
