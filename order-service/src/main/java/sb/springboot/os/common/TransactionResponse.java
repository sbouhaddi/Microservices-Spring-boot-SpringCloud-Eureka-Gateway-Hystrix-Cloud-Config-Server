package sb.springboot.os.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sb.springboot.os.entity.Order;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
