package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dao.CardDao;
import com.quanlybanhang.qlbh.dao.OrderDao;
import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.service.OrderService;
import com.quanlybanhang.qlbh.service.ProductService;
import com.quanlybanhang.qlbh.service.TransactionService;
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

    @GetMapping("products")
    public  ResponseEntity<?> getProductAll(){
        List<ProductDTO> productDTOList = productService.getProductAll();
        return new ResponseEntity<List<ProductDTO>>(productDTOList,HttpStatus.OK);
    }

    @PostMapping("search-products")
    public ResponseEntity<?> SearchProducts(@RequestBody String searchInput){
        List<ProductDTO> productDTOList = productService.SearchProducts(searchInput);
        return new ResponseEntity<List<ProductDTO>>(productDTOList,HttpStatus.OK);
    }

    @DeleteMapping("products/{id}")
    public Boolean DeleteProduct(@PathVariable Integer id){
        return productService.DeleteProduct(id);
    }
    

}
