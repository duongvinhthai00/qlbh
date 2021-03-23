package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.ViewDTO;

public interface ViewService {
    ViewDTO SaveView(ViewDTO viewDTO);
    ViewDTO SaveRating(ViewDTO viewDTO);
    ViewDTO GetView(Integer pro_id,Integer user_id);
}
