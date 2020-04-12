package sb.springboot.ps.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sb.springboot.ps.entity.Payment;
import sb.springboot.ps.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public String paymentProcessing() {
		return new Random().nextBoolean() ? "success" : "false";
	}

	public Payment findPaymentHistoryByOrderId(Long orderId) {
		return paymentRepository.findByOrderId(orderId);
	}

}
