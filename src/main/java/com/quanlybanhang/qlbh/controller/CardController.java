package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.CardDTO;
import com.quanlybanhang.qlbh.service.CardService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v7")
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {
    @Autowired
    private CardService cardService;

    @Autowired
    private MapValidationService mapValidationService;

    @PostMapping("card")
    public ResponseEntity<?> addCard(@Valid @RequestBody CardDTO cardDTO, BindingResult result){
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        CardDTO dto = cardService.addOrUpdateCard(cardDTO);
        return new ResponseEntity<CardDTO>(dto, HttpStatus.CREATED);
    }

    @GetMapping("cards/{userId}")
    public ResponseEntity<?> findCardAll(@PathVariable Integer userId){
        List<CardDTO> listCardDTO = cardService.findCardAllByUser(userId);
        return new ResponseEntity<List<CardDTO>>(listCardDTO,HttpStatus.OK);
    }

    @PutMapping("cards")
    public ResponseEntity<?> updateCard(@RequestBody CardDTO cardDTO){
        cardDTO = cardService.updateCard(cardDTO);
        return new ResponseEntity<CardDTO>(cardDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("cards/{id}")
    public void deleteCard(@PathVariable Integer id){
        cardService.deleteCardDTO(id);
    }
}
