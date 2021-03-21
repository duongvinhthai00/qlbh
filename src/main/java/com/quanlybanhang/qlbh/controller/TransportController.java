package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dto.TransportDTO;
import com.quanlybanhang.qlbh.service.TransportService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v9")
@CrossOrigin(origins = "http://localhost:4200")
public class TransportController {
    @Autowired
    private TransportService transportService;

    @Autowired
    private MapValidationService mapValidationService;

    @GetMapping("transport-all")
    public ResponseEntity<?> GetAllTransport(){
        List<TransportDTO> list = transportService.GetAllTransport();
        return new ResponseEntity<List<TransportDTO>>(list, HttpStatus.OK);
    }

    @DeleteMapping("transport-del/{id}")
    public Boolean DeleteTransportById(@PathVariable Integer id){
        transportService.DeleteTransportById(id);
       return true;
    }

    @PostMapping("transport-add")
    public ResponseEntity<?> addOrUpdateTransport(@Valid @RequestBody TransportDTO transportDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        transportDTO = transportService.addOrUpdateTransport(transportDTO);
        return new ResponseEntity<TransportDTO>(transportDTO,HttpStatus.OK);
    }

    @GetMapping("get-transport/{id}")
    public ResponseEntity<?> getTransportById(@PathVariable Integer id){
        TransportDTO transportDTO = transportService.getTransportById(id);
        return new ResponseEntity<>(transportDTO,HttpStatus.OK);
    }
}
