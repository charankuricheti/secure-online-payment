package com.charan.secure_payment.service;

import com.charan.secure_payment.model.Payment;
import com.charan.secure_payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Payment payment) {

        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);
    }

    public List<Payment> searchByEmail(String email) {

        return paymentRepository.findByEmail(email);
    }
}