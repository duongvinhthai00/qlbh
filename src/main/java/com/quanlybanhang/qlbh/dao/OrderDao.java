package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity,Integer> {

    @Transactional
    @Modifying
    @Query("delete from OrderEntity o where o.or_transaction_id.id = ?1")
    void deleteAllByTransaction(Integer tr_id);

    @Query("select k from OrderEntity k where k.or_transaction_id.id = ?1")
    List<OrderEntity> getOrderByTransactionID(Integer tr_id);
}
