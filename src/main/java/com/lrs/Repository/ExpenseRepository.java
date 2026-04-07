package com.lrs.Repository;

import com.lrs.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
    List<Expenses> findAll();
    Optional<Expenses> findById(Long id);
}
