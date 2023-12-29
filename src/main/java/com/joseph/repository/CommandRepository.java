package com.joseph.repository;

import com.joseph.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commandRepository")
public interface CommandRepository extends JpaRepository<Command, Integer> {
//    @Query("SELECT DISTINCT c FROM Command c " +
//            "LEFT JOIN FETCH c.customer " +
//            "LEFT JOIN FETCH c.commandArticleList ca " +
//            "LEFT JOIN FETCH ca.article")
//    List<Command> findAllWithCustomerAndCommandArticles();

    List<Command> findByOrderByPriceTotalAsc();

}
