package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.dto.ViewDTO;

import java.util.List;

public interface ViewService {
    ViewDTO SaveView(ViewDTO viewDTO);
    ViewDTO SaveRating(ViewDTO viewDTO);
    ViewDTO GetView(Integer pro_id,Integer user_id);
    List<ProductDTO> GetListProductForUser(Integer pro_id, Integer group_id);
}
