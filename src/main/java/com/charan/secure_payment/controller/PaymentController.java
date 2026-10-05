package com.charan.secure_payment.controller;

import com.charan.secure_payment.model.Payment;
import com.charan.secure_payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String showPaymentForm(Model model) {

        model.addAttribute("payment", new Payment());

        return "payment-form";
    }

    @PostMapping("/payment")
    public String processPayment(
            @Valid @ModelAttribute("payment") Payment payment,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "payment-form";
        }

        Payment savedPayment =
                paymentService.processPayment(payment);

        model.addAttribute("payment", savedPayment);

        return "payment-success";
    }

    @GetMapping("/payments/search")
    @ResponseBody
    public List<Payment> searchPayments(
            @RequestParam String email) {

        return paymentService.searchByEmail(email);
    }
}