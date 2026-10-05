package com.charan.secure_payment.repository;


import com.charan.secure_payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByEmail(String email);
}
