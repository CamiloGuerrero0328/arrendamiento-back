package com.arrendamiento.proyect.repository;

import com.arrendamiento.proyect.domain.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
