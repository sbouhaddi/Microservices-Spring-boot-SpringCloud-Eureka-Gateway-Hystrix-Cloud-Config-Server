package sb.springboot.os.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import sb.springboot.os.common.Payment;
import sb.springboot.os.common.TransactionRequest;
import sb.springboot.os.common.TransactionResponse;
import sb.springboot.os.entity.Order;
import sb.springboot.os.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;

	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,
				Payment.class);

		response = paymentResponse.getPaymentStatus().equals("success") ? "Payment successful, order placed"
				: " Payment failed , order in cart";

		Order orderResponse = orderRepository.save(order);

		return TransactionResponse.builder().order(orderResponse).transactionId(paymentResponse.getTransactionId())
				.amount(paymentResponse.getAmount()).message(response).build();
	}

}
