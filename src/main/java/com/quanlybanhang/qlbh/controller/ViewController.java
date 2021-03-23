package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dao.OrderDao;
import com.quanlybanhang.qlbh.dto.ViewDTO;
import com.quanlybanhang.qlbh.entity.OrderEntity;
import com.quanlybanhang.qlbh.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v11")
@CrossOrigin(origins = "http://localhost:4200")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @Autowired
    private OrderDao orderDao;

    @PostMapping("save-view")
    public ResponseEntity<?> SaveView(@RequestBody ViewDTO viewDTO){
        viewDTO = viewService.SaveView(viewDTO);
        return new ResponseEntity<>(viewDTO, HttpStatus.CREATED);
    }

    @PostMapping("check-rating")
    public Boolean CheckRating(@RequestBody ViewDTO viewDTO){
        List<OrderEntity> list = orderDao.getListOrderEntity(viewDTO.getPro_id().getId(),viewDTO.getUser_id().getId());
        if(list.size() == 0){
            return false;
        }
        return true;
    }

    @PostMapping("save-rating")
    public ResponseEntity<?> SaveRating(@RequestBody ViewDTO viewDTO){
        viewDTO = viewService.SaveRating(viewDTO);
        return new ResponseEntity<>(viewDTO, HttpStatus.CREATED);
    }

    @GetMapping("get-view/{pro_id}/{user_id}")
    public ResponseEntity<?> GetView(@PathVariable Integer pro_id,@PathVariable Integer user_id){
        return new ResponseEntity<>(viewService.GetView(pro_id,user_id),HttpStatus.OK);
    }

}
