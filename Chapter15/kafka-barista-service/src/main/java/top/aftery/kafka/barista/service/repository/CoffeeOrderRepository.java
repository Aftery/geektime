package top.aftery.kafka.barista.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.kafka.barista.service.entity.CoffeeOrder;

/**
 * @classname: CoffeeOrderRespository
 * @Auther: aftery
 * @Date: 2020/5/19 20:39
 * @Description:
 */

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
