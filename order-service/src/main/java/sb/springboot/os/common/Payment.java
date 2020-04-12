package sb.springboot.os.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


	private Long paymentId;
	private String paymentStatus;
	private String transactionId;
	private Long orderId;
	private double amount;

}
