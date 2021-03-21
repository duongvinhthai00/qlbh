package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity,Integer> {

    @Query("select k from TransactionEntity k where k.tr_user_id.id = ?1")
    List<TransactionEntity> GetTransactionByUser(Integer userId);

    @Transactional
    @Modifying
    @Query("update TransactionEntity k set k.tr_transport_id = NULL where k.tr_transport_id.id=?1")
    void UpdateTransactionByTransport(Integer id);

    @Query(value="SELECT" +
            "  SUM(CASE month(tr.created_at) WHEN 1 THEN tr.tr_total ELSE 0 END) as th1," +
            "  SUM(CASE month(tr.created_at) WHEN 2 THEN tr.tr_total ELSE 0 END) as th2," +
            "  SUM(CASE month(tr.created_at) WHEN 3 THEN tr.tr_total ELSE 0 END) as th3," +
            "  SUM(CASE month(tr.created_at) WHEN 4 THEN tr.tr_total ELSE 0 END) as th4," +
            "  SUM(CASE month(tr.created_at) WHEN 5 THEN tr.tr_total ELSE 0 END) as th5," +
            "  SUM(CASE month(tr.created_at) WHEN 6 THEN tr.tr_total ELSE 0 END) as th6," +
            "  SUM(CASE month(tr.created_at) WHEN 7 THEN tr.tr_total ELSE 0 END) as th7," +
            "  SUM(CASE month(tr.created_at) WHEN 8 THEN tr.tr_total ELSE 0 END) as th8," +
            "  SUM(CASE month(tr.created_at) WHEN 9 THEN tr.tr_total ELSE 0 END) as th9," +
            "  SUM(CASE month(tr.created_at) WHEN 10 THEN tr.tr_total ELSE 0 END) as th10," +
            "  SUM(CASE month(tr.created_at) WHEN 11 THEN tr.tr_total ELSE 0 END) as th11," +
            "  SUM(CASE month(tr.created_at) WHEN 12 THEN tr.tr_total ELSE 0 END) as th12," +
            "  SUM(tr.tr_total) as total " +
            "from " +
            "transactions as tr" +
            " WHERE " +
            "  tr.created_at BETWEEN :fromDay AND :toDay and tr.payment_status = 1",nativeQuery=true)
    RevenueDao GetRevenueDao(@Param("fromDay") String fromDay, @Param("toDay") String toDay);
}
