package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.ImageDTO;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.service.ImageService;
import com.quanlybanhang.qlbh.service.ProductService;
import com.quanlybanhang.qlbh.serviceImpl.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v6")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductService productService;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("images/{id}")
    public ResponseEntity<?> findImagesByProductId(@PathVariable Integer id){
        List<ImageDTO> list = imageService.findImagesByProductId(id);
        return new ResponseEntity<List<ImageDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("product-image-upload/{id}")
    public Boolean uploadManyFile(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
        ProductDTO productDTO = productService.getProductById(id);
        String fileName = UploadFileService.UploadOneFile(file,fileUpload);
        imageService.addImagesForProduct(fileName,productDTO);
        return true;
    }

    @DeleteMapping("delete-product-image/{pro_id}")
    public Boolean DeleteImageProduct(@PathVariable Integer pro_id){
        this.imageService.DeleteImageProduct(pro_id);
        return true;
    }

}
