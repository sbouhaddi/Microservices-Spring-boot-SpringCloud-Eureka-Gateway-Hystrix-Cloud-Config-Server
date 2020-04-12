package sb.springboot.os.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sb.springboot.os.common.TransactionRequest;
import sb.springboot.os.common.TransactionResponse;
import sb.springboot.os.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/bookOrder")
	public ResponseEntity<TransactionResponse> bookOrder(@RequestBody TransactionRequest request) {

		return new ResponseEntity<TransactionResponse>(orderService.saveOrder(request), HttpStatus.CREATED);
	}

}
