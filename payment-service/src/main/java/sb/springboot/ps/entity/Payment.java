package sb.springboot.ps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_TB")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue
	private Long paymentId;
	private String paymentStatus;
	private String transactionId;
	private Long orderId;
	private double amount;

}
