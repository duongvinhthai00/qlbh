package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.PaymentInfoDTO;
import com.quanlybanhang.qlbh.service.PaymentInfoService;
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
@RequestMapping("api/v10")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    @Autowired
    private MapValidationService mapValidationService;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("payment-info-all")
    public ResponseEntity<?> GetAllPaymentInfo(){
        return new ResponseEntity<List<PaymentInfoDTO>>(this.paymentInfoService.GetAllPaymentInfo(), HttpStatus.OK);
    }

    @DeleteMapping("payment-info/{id}")
    public Boolean DeletePaymentInfo(@PathVariable Integer id){
        paymentInfoService.DeletePaymentInfo(id);
        return true;
    }

    @PostMapping("payment-info-add")
    public ResponseEntity<?> AddPaymentInfo(@Valid @RequestBody PaymentInfoDTO paymentInfoDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        paymentInfoDTO = paymentInfoService.AddPaymentInfo(paymentInfoDTO);
        return new ResponseEntity<PaymentInfoDTO>(paymentInfoDTO,HttpStatus.CREATED);
    }

    @PostMapping("payment-upload/{id}")
    public ResponseEntity<?> UpdatePaymentInfo(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
        PaymentInfoDTO paymentInfoDTO = paymentInfoService.findPaymentInfoById(id);
        String fileName = UploadFileService.UploadOneFile(file,fileUpload);
        paymentInfoDTO.setImage(fileName);
        paymentInfoDTO = paymentInfoService.UpdatePaymentInfo(paymentInfoDTO);
        return new ResponseEntity<>(paymentInfoDTO,HttpStatus.OK);
    }

    @GetMapping("payment-info/{id}")
    public ResponseEntity<?> findPaymentInfoById(@PathVariable Integer id){
        PaymentInfoDTO paymentInfoDTO = paymentInfoService.findPaymentInfoById(id);
        return new ResponseEntity<>(paymentInfoDTO,HttpStatus.OK);
    }

    @PutMapping("payment-update")
    public ResponseEntity<?> UpdatePaymentInfo2(@Valid @RequestBody PaymentInfoDTO paymentInfoDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        paymentInfoDTO =  paymentInfoService.UpdatePaymentInfo(paymentInfoDTO);
        return new ResponseEntity<PaymentInfoDTO>(paymentInfoDTO,HttpStatus.OK);
    }

}
