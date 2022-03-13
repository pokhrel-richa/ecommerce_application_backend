package com.ecommerce.ecommerce.credit.repository;

import com.ecommerce.ecommerce.credit.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditRepository extends JpaRepository<Credit,Long> {

    @Query("SELECT c FROM Credit c WHERE c.customerId =:id")
    Credit getByCustomerId(@Param("id") long id);
}
