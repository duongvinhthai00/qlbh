package com.quanlybanhang.qlbh.controller;


import com.quanlybanhang.qlbh.dao.OrderDao;
import com.quanlybanhang.qlbh.dao.ProductDao;
import com.quanlybanhang.qlbh.dao.TransactionDao;
import com.quanlybanhang.qlbh.dto.CardDTO;
import com.quanlybanhang.qlbh.dto.OrderDTO;
import com.quanlybanhang.qlbh.dto.TransactionDTO;
import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.service.CardService;
import com.quanlybanhang.qlbh.service.OrderService;
import com.quanlybanhang.qlbh.service.TransactionService;
import com.quanlybanhang.qlbh.serviceImpl.MapValidationService;
import com.quanlybanhang.qlbh.serviceImpl.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v8")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    private CardService cardService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MapValidationService mapValidationService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TransactionDao transactionDao;

    @PostMapping("transaction")
    public ResponseEntity<?> addTransaction(@Valid @RequestBody TransactionDTO transactionDTO, BindingResult result){
        transactionDTO.setTr_status(0);
        transactionDTO.setCreated_at(TimeService.getTimeNow());
        if(result.hasErrors()){
            return mapValidationService.getMapValidationError(result);
        }
        transactionDTO = transactionService.addTransaction(transactionDTO);
        List<CardDTO> listCard = cardService.findCardAllByUser(transactionDTO.getTr_user_id().getId());
        List<ProductEntity> listProductEntity = productDao.findAll();
        for(CardDTO cardDTO : listCard){
            OrderDTO orderDTO = GetOrder(cardDTO,transactionDTO);
            orderService.addOrder(orderDTO);
            for(ProductEntity entity : listProductEntity){
                if(cardDTO.getC_product_id().getId() == entity.getId()){
                    entity.setPro_number(entity.getPro_number()-cardDTO.getC_qty());
                    productDao.save(entity);
                }
            }
        }
        cardService.deleteAllCard(transactionDTO.getTr_user_id().getId());
        return new ResponseEntity<TransactionDTO>(transactionDTO, HttpStatus.CREATED);
    }


    @GetMapping("transaction/{userId}")
    public ResponseEntity<?> GetTransactionByUser(@PathVariable Integer userId){
        List<TransactionDTO> list = transactionService.GetTransactionByUser(userId);
        return new ResponseEntity<List<TransactionDTO>>(list,HttpStatus.OK);
    }

    @DeleteMapping("transaction/{tr_id}")
    public Boolean deleteAllByTransaction(@PathVariable Integer tr_id){
        orderDao.deleteAllByTransaction(tr_id);
        transactionDao.deleteById(tr_id);
        return true;
    }

    @GetMapping("transaction-id/{tr_id}")
    public ResponseEntity<?> getTransactionByID(@PathVariable Integer tr_id){
        TransactionDTO transactionDTO = transactionService.getTransactionById(tr_id);
        return new ResponseEntity<TransactionDTO>(transactionDTO,HttpStatus.OK);
    }

    @GetMapping("order-transaction/{tr_id}")
    public ResponseEntity<?> getOrderByTransactionId(@PathVariable Integer tr_id){
        List<OrderDTO> orderDTOList = orderService.getOrderByTransactionID(tr_id);
        return new ResponseEntity<List<OrderDTO>>(orderDTOList,HttpStatus.OK);
    }

    @PutMapping("order-transaction")
    public Boolean updateProductNumber(@RequestBody Integer tr_id ){
        List<OrderDTO> orderDTOS = orderService.getOrderByTransactionID(tr_id);
        for(OrderDTO orderDTO : orderDTOS){
            ProductEntity productEntity = productDao.findById(orderDTO.getOr_product_id().getId()).get();
            productEntity.setPro_number(productEntity.getPro_number() + orderDTO.getOr_qty());
            productDao.save(productEntity);
        }
        return true;
    }

    @GetMapping("transaction-all")
    public ResponseEntity<?> GetAllTransaction(){
        return new ResponseEntity<List<TransactionDTO>>(transactionService.getAllTransaction(),HttpStatus.OK);
    }


    @PutMapping("transaction-update")
    public ResponseEntity<?> updateTransaction(@Valid @RequestBody TransactionDTO transactionDTO, BindingResult result){
        if(result.hasErrors()) {
            return mapValidationService.getMapValidationError(result);
        }
        transactionDTO = transactionService.updateTransaction(transactionDTO);
        return new ResponseEntity<>(transactionDTO,HttpStatus.OK);
    }

    public OrderDTO GetOrder(CardDTO cardDTO,TransactionDTO transactionDTO){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCreated_at(TimeService.getTimeNow());
        orderDTO.setOr_price(cardDTO.getC_product_id().getPro_pay());
        orderDTO.setOr_user_id(transactionDTO.getTr_user_id());
        orderDTO.setOr_sale(cardDTO.getC_product_id().getPro_sale());
        orderDTO.setOr_price_old(cardDTO.getC_product_id().getPro_price());
        orderDTO.setOr_product_id(cardDTO.getC_product_id());
        orderDTO.setOr_transaction_id(transactionDTO);
        orderDTO.setOr_qty(cardDTO.getC_qty());
        return orderDTO;
    }
}
