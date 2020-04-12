package sb.springboot.os.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TB")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	private Long id;
	private String name;
	private int qty;
	private double price;
}
