package com.fitnessCentre.app.restca.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessCentre.app.restca.Models.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
