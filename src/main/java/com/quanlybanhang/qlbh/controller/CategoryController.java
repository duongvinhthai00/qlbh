package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.CategoryDTO;
import com.quanlybanhang.qlbh.service.CategoryService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v4")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MapValidationService mapValidationService;


    @GetMapping("category")
    public ResponseEntity<?> getAllCategoryGroup() {
        List<CategoryDTO> listCategory = categoryService.findCategoryAll();
        return new ResponseEntity<List<CategoryDTO>>(listCategory, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> getCategoryGroupById(@PathVariable int id){
        CategoryDTO categoryDTO = categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(categoryDTO);
    }

    @PostMapping("category")
    public ResponseEntity<?> addCategoryGroup(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        CategoryDTO dto = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(dto,HttpStatus.CREATED);
    }

    @PutMapping("category")
    public ResponseEntity<?> updateCategoryGroup(@Valid @RequestBody CategoryDTO categoryDTO,BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        categoryService.updateCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(categoryDTO,HttpStatus.OK);
    }

    @PostMapping("categorygetgroup/{id}")
    public ResponseEntity<?> findAllByCategoryGroup(@PathVariable Integer id,@RequestBody Integer idCr){
        List<CategoryDTO> categoryDTOList = categoryService.findAllByCategoryGroup(id,idCr);
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOList,HttpStatus.OK);
    }
}
