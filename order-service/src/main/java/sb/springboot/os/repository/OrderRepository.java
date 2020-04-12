package sb.springboot.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sb.springboot.os.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
