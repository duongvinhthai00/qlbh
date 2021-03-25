package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.CategoryGroupDTO;
import com.quanlybanhang.qlbh.service.CategoryGroupService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v3")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryGroupController {

    @Autowired
    private CategoryGroupService categoryGroupService;

    @Autowired
    private MapValidationService mapValidationService;


    @GetMapping("categorygroup")
    public ResponseEntity<?> getAllCategoryGroup() {
        List<CategoryGroupDTO> listCategoryGroup = categoryGroupService.findCategoryGroupAll();
        return new ResponseEntity<List<CategoryGroupDTO>>(listCategoryGroup, HttpStatus.OK);
    }

    @GetMapping("categorygroup/{id}")
    public ResponseEntity<?> getCategoryGroupById(@PathVariable int id){
        CategoryGroupDTO categoryGroupDTO = categoryGroupService.findCategoryGroupById(id);
        return ResponseEntity.ok().body(categoryGroupDTO);
    }

    @PostMapping("categorygroup")
    public ResponseEntity<?> addCategoryGroup(@Valid @RequestBody CategoryGroupDTO categoryGroupDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        CategoryGroupDTO dto = categoryGroupService.addCategoryGroup(categoryGroupDTO);
        return new ResponseEntity<CategoryGroupDTO>(dto,HttpStatus.CREATED);
    }

    @PutMapping("categorygroup")
    public ResponseEntity<?> updateCategoryGroup(@Valid @RequestBody CategoryGroupDTO categoryGroupDTO,BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        categoryGroupService.updateCategoryGroup(categoryGroupDTO);
        return new ResponseEntity<CategoryGroupDTO>(categoryGroupDTO,HttpStatus.OK);
    }

    @DeleteMapping("categorygroup/{id}")
    public Boolean deleteCateGroup(@PathVariable Integer id){
        categoryGroupService.deleteCateGroup(id);
        return true;
    }
}
