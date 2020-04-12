package sb.springboot.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sb.springboot.ps.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query("SELECT p FROM Payment p WHERE p.orderId=:orderId")
	Payment findByOrderId(@Param("orderId")Long orderId);

}
