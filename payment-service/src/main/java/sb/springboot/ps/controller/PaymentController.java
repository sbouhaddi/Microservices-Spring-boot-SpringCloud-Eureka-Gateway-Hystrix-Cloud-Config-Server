package sb.springboot.ps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sb.springboot.ps.entity.Payment;
import sb.springboot.ps.service.PaymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping("/doPayment")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment) {
		return new ResponseEntity<>(paymentService.doPayment(payment), HttpStatus.CREATED);
	}

	@GetMapping("/{orderId}")
	public Payment findPaymentHistoryByOrderId(@PathVariable Long orderId) {
		return paymentService.findPaymentHistoryByOrderId(orderId);
	}

}
