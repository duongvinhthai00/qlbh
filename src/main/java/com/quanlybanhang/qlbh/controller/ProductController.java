package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dao.CardDao;
import com.quanlybanhang.qlbh.dao.OrderDao;
import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.service.OrderService;
import com.quanlybanhang.qlbh.service.ProductService;
import com.quanlybanhang.qlbh.service.TransactionService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import com.quanlybanhang.qlbh.serviceImpl.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v5")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private MapValidationService mapValidationService;

    @Value("${upload.path}")
    private String fileUpload;

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
    

    @PostMapping("add-product")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        productDTO.setPro_pay(productDTO.getPro_price() - (productDTO.getPro_price()*(productDTO.getPro_sale()/100)));
        productDTO = productService.addProduct(productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
    }

    @PostMapping("product/upload/{id}")
    public Boolean ProductUploadFile(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
        ProductDTO productDTO = productService.getProductById(id);
        String fileName = UploadFileService.UploadOneFile(file,fileUpload);
        productDTO.setPro_avatar(fileName);
        productService.updateProduct(productDTO);
        return true;
    }
}
