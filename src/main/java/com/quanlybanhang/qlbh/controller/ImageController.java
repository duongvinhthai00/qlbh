package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.ImageDTO;
import com.quanlybanhang.qlbh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v6")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("images/{id}")
    public ResponseEntity<?> findImagesByProductId(@PathVariable Integer id){
        List<ImageDTO> list = imageService.findImagesByProductId(id);
        return new ResponseEntity<List<ImageDTO>>(list, HttpStatus.OK);
    }
}
