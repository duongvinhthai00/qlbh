package com.quanlybanhang.qlbh.dao;

import com.quanlybanhang.qlbh.entity.ViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ViewDao extends JpaRepository<ViewEntity,Integer> {

    @Query("select v from ViewEntity v where v.pro_id.id = ?1 and v.user_id.id = ?2")
    ViewEntity GetView(Integer pro_id,Integer user_id);

    @Transactional
    @Modifying
    @Query(value="update products p \n" +
            "join (select v.pro_id, round(sum(v.rating_number)/count(v.pro_id)) as ratingnumber\n" +
            "from view as v\n" +
            "where v.rating_number > 0\n" +
            "group by v.pro_id) as rate on p.id = rate.pro_id\n" +
            "set p.pro_rate_number = rate.ratingnumber",nativeQuery=true)
    void UpdateProductWithRate();

    @Query("select v from ViewEntity v where v.pro_id.pro_category_id.c_group_id.id = ?1")
    List<ViewEntity> GetListView(Integer group_id);
}
