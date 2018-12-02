package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    // @Query(value = "SELECT id, first_name, last_name FROM customers ORDER BY first_name, last_name", nativeQuery = true)
    // @Query(value = "SELECT x FROM customers x ORDER BY x.first_name, x.last_name", nativeQuery = true) --> 요건 안되네..
    List<Customer> findAllOrderByName();

    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    Page<Customer> findAllOrderByNameWithPaging(Pageable pageable);


    /**
     * nativeQuery 모드에서 jpa 기능 제한됨
     *
    // @Query(value = "SELECT x FROM customers x ORDER BY x.first_name, x.last_name", nativeQuery = true) --> 요건 안되네..
    Caused by: org.h2.jdbc.JdbcSQLException: Column "X" not found; SQL statement:
    SELECT x FROM customers x ORDER BY x.first_name, x.last_name [42122-187]
    *
    */
}
