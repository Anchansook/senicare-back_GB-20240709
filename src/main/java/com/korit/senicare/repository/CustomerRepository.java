package com.korit.senicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.CustomerEntity;
import com.korit.senicare.repository.resultSet.GetCustomerResultSet;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query(
    value=
        "SELECT " + 
        "    C.customer_number as customerNumber, " +   
        "    C.name as name, " +
        "    C.birth as birth, " + 
        "    C.location as location, " +
        "    N.name as chargerName, " +
        "    N.userId as chargerId " +
        "FROM customers C LEFT JOIN nurses N " +
        "ON C.charger = N.userId " +
        "ORDER BY C.customer_number DESC ",
    nativeQuery=true
    )
    List<GetCustomerResultSet> getCustomers();
    
}
