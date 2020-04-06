package top.aftery.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.jpademo.eneity.CoffeeOrder;

/**
 * @program: CoffeeOrderRepository
 * @description:
 * @author: aftery
 * @create: 2020-03-31 10:56
 **/
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
