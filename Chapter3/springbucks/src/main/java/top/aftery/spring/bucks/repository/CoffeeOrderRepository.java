package top.aftery.spring.bucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.spring.bucks.entity.CoffeeOrder;

/**
 * @classname: CoffeeOrderRepository
 * @Auther: aftery
 * @Date: 2020-04-05 14:35
 * @Description:
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
