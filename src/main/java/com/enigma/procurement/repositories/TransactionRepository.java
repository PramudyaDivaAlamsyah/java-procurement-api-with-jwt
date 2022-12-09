package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findAll(Specification spec);

//    @Query("SELECT t FROM Transaction t WHERE t.date = CURRENT_DATE")
//    List<Transaction> findByDateToday();
}
