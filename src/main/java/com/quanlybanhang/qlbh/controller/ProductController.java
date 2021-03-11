package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("products/{id}")
    public ResponseEntity<?> GetProductByCategoryId(@PathVariable Integer id){
        List<ProductDTO> productDTOList = this.productService.GetProductByCategoryId(id);
        return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.ACCEPTED);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        ProductDTO productDTO = this.productService.getProductById(id);
        return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);
    }
    

}
