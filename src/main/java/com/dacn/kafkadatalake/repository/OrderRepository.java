package com.dacn.kafkadatalake.repository;

import com.dacn.kafkadatalake.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select * from `orders` where ID = ?1", nativeQuery = true)
    Order getAllById(int id);
}
